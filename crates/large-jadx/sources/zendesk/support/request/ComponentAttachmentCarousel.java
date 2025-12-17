package zendesk.support.request;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import f.g.d.f;
import java.util.Collection;
import java.util.List;
import o.b.f;
import o.b.k;
import o.b.o;
import o.b.p;
import zendesk.belvedere.e;
import zendesk.belvedere.e.b;
import zendesk.belvedere.p;
import zendesk.belvedere.s;

/* loaded from: classes3.dex */
class ComponentAttachmentCarousel implements e.b, k<zendesk.support.request.ComponentAttachmentCarousel.AttachmentCarouselModel>, zendesk.support.request.RequestViewConversationsDisabled.MenuItemsDelegate {

    private final zendesk.support.request.ActionFactory actionFactory;
    private final d activity;
    private MenuItem attachmentButton;
    private final zendesk.support.request.AttachmentHelper attachmentHelper;
    private boolean attachmentSupportEnabled = false;
    private final f dispatcher;
    private final e imageStream;
    private final RecyclerView recyclerView;
    private final ScrollView scrollView;
    private final p<zendesk.support.request.ComponentAttachmentCarousel.AttachmentCarouselModel> selector;

    static class AttachmentCarouselModel {

        private final Collection<zendesk.support.request.StateRequestAttachment> additionalAttachments;
        private final boolean isAttachmentSupportEnabled;
        private final boolean isLoading;
        private final long maxAttachmentSize;
        private final Collection<zendesk.support.request.StateRequestAttachment> selectedAttachments;
        AttachmentCarouselModel(Collection<zendesk.support.request.StateRequestAttachment> collection, Collection<zendesk.support.request.StateRequestAttachment> collection2, boolean z3, boolean z4, long l5) {
            super();
            this.selectedAttachments = collection;
            this.additionalAttachments = collection2;
            this.isLoading = z3;
            this.isAttachmentSupportEnabled = z4;
            this.maxAttachmentSize = l5;
        }

        Collection<zendesk.support.request.StateRequestAttachment> getAdditionalAttachments() {
            return this.additionalAttachments;
        }

        long getMaxAttachmentSize() {
            return this.maxAttachmentSize;
        }

        Collection<zendesk.support.request.StateRequestAttachment> getSelectedAttachments() {
            return this.selectedAttachments;
        }

        boolean isAttachmentSupportEnabled() {
            return this.isAttachmentSupportEnabled;
        }

        boolean isLoading() {
            return this.isLoading;
        }
    }

    static class AttachmentCarouselSelector implements p<zendesk.support.request.ComponentAttachmentCarousel.AttachmentCarouselModel> {
        @Override // o.b.p
        public Object selectData(o o) {
            return selectData(o);
        }

        @Override // o.b.p
        public zendesk.support.request.ComponentAttachmentCarousel.AttachmentCarouselModel selectData(o o) {
            int obj11;
            final zendesk.support.request.StateAttachments state = StateAttachments.fromState(o);
            final zendesk.support.request.StateConfig state2 = StateConfig.fromState(o);
            obj11 = StateProgress.fomState(o).getRunningRequests() > 0 ? 1 : 0;
            super(state.getSelectedAttachments(), state.getAllSelectedAttachments(), obj11, state2.getSettings().isAttachmentsEnabled(), state2.getSettings().getMaxAttachmentSize(), obj8);
            return attachmentCarouselModel2;
        }
    }
    ComponentAttachmentCarousel(f f, zendesk.support.request.ActionFactory actionFactory2, e e3, d d4, zendesk.support.request.AttachmentHelper attachmentHelper5, RecyclerView recyclerView6) {
        super();
        final int i = 0;
        this.dispatcher = f;
        this.actionFactory = actionFactory2;
        this.imageStream = e3;
        this.activity = d4;
        this.attachmentHelper = attachmentHelper5;
        this.recyclerView = recyclerView6;
        this.scrollView = (ScrollView)d4.findViewById(f.U);
        ComponentAttachmentCarousel.AttachmentCarouselSelector obj2 = new ComponentAttachmentCarousel.AttachmentCarouselSelector();
        this.selector = obj2;
        initImagePicker();
    }

    static void access$000(zendesk.support.request.ComponentAttachmentCarousel componentAttachmentCarousel, boolean z2) {
        componentAttachmentCarousel.onAddAttachmentsRequested(z2);
    }

    static ScrollView access$100(zendesk.support.request.ComponentAttachmentCarousel componentAttachmentCarousel) {
        return componentAttachmentCarousel.scrollView;
    }

    private void attachmentButtonVisibility(boolean z, boolean z2) {
        boolean obj2;
        final MenuItem attachmentButton = this.attachmentButton;
        if (attachmentButton != null) {
            attachmentButton.setVisible(z);
            this.attachmentButton.getActionView().setEnabled(z2);
        }
    }

    private void attachmentCount(int i) {
        Object attachmentButton;
        attachmentButton = this.attachmentButton;
        if (attachmentButton != null) {
            (ViewCellAttachmentMenuItem)attachmentButton.getActionView().setBadgeCount(i);
        }
    }

    private void initImagePicker() {
        boolean scrollView2;
        boolean scrollView;
        zendesk.support.request.ComponentAttachmentCarousel.1 anon;
        this.imageStream.C1(this);
        if (this.imageStream.E1().getInputTrap().hasFocus()) {
            this.scrollView.requestFocus();
        }
        if (this.imageStream.O1()) {
            anon = new ComponentAttachmentCarousel.1(this);
            this.scrollView.post(anon);
        }
    }

    private void onAddAttachmentsRequested(boolean z) {
        d activity;
        Object obj2;
        if (!this.imageStream.G1()) {
            this.attachmentHelper.showImagePicker(this.activity);
        } else {
            if (z != null) {
                this.imageStream.dismiss();
            }
        }
    }

    private void scroll(int i) {
        ComponentAttachmentCarousel.2 anon = new ComponentAttachmentCarousel.2(this, i);
        this.scrollView.post(anon);
    }

    p<zendesk.support.request.ComponentAttachmentCarousel.AttachmentCarouselModel> getSelector() {
        return this.selector;
    }

    @Override // zendesk.belvedere.e$b
    public void onDismissed() {
        this.scrollView.requestFocus();
        scroll(33);
    }

    public void onMediaDeselected(List<s> list) {
        this.dispatcher.c(this.actionFactory.deselectAttachment(list));
        onAddAttachmentsRequested(false);
    }

    public void onMediaSelected(List<s> list) {
        this.dispatcher.c(this.actionFactory.selectAttachment(list));
        onAddAttachmentsRequested(false);
    }

    @Override // zendesk.belvedere.e$b
    public void onMenuItemsClicked(MenuItem menuItem) {
    }

    @Override // zendesk.belvedere.e$b
    public void onMenuItemsInflated(MenuItem menuItem, MenuItem menuItem2) {
        this.attachmentButton = menuItem2;
        ComponentAttachmentCarousel.3 obj2 = new ComponentAttachmentCarousel.3(this);
        menuItem2.getActionView().setOnClickListener(obj2);
        attachmentButtonVisibility(this.attachmentSupportEnabled, true);
    }

    @Override // zendesk.belvedere.e$b
    public void onVisible() {
        scroll(130);
    }

    @Override // zendesk.belvedere.e$b
    public void update(Object object) {
        update((ComponentAttachmentCarousel.AttachmentCarouselModel)object);
    }

    @Override // zendesk.belvedere.e$b
    public void update(zendesk.support.request.ComponentAttachmentCarousel.AttachmentCarouselModel componentAttachmentCarousel$AttachmentCarouselModel) {
        boolean attachmentHelper;
        int maxAttachmentSize;
        Collection additionalAttachments;
        int obj4;
        boolean attachmentSupportEnabled = attachmentCarouselModel.isAttachmentSupportEnabled();
        this.attachmentSupportEnabled = attachmentSupportEnabled;
        attachmentButtonVisibility(attachmentSupportEnabled, loading ^= 1);
        if (!attachmentCarouselModel.isLoading()) {
            additionalAttachments = attachmentCarouselModel.getAdditionalAttachments();
            this.attachmentHelper.updateAttachments(attachmentCarouselModel.getSelectedAttachments(), additionalAttachments);
            this.attachmentHelper.updateMaxFileSize(attachmentCarouselModel.getMaxAttachmentSize());
            attachmentCount(this.attachmentHelper.getSelectedAttachments().size());
            if (this.attachmentHelper.getSelectedAttachments().size() > 0) {
                scroll(130);
            } else {
                scroll(33);
            }
            this.recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}

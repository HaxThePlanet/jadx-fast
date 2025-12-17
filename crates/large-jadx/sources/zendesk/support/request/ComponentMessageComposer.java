package zendesk.support.request;

import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.app.d;
import f.g.d.f;
import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.List;
import o.b.f;
import o.b.k;
import o.b.o;
import o.b.p;
import zendesk.belvedere.e;
import zendesk.belvedere.e.b;
import zendesk.belvedere.p;
import zendesk.belvedere.s;
import zendesk.support.RequestStatus;
import zendesk.support.UiUtils;

/* loaded from: classes3.dex */
class ComponentMessageComposer implements k<zendesk.support.request.ComponentMessageComposer.MessageComposerModel>, zendesk.support.request.ViewMessageComposer.InputListener, e.b {

    private final zendesk.support.request.ActionFactory actionFactory;
    private final d activity;
    private final zendesk.support.request.AttachmentHelper attachmentHelper;
    private final f dispatcher;
    private final e imageStream;
    private final zendesk.support.request.ViewMessageComposer messageComposerView;
    private final zendesk.support.request.ComponentMessageComposer.MessageComposerSelector messageFieldSelector;

    static class MessageComposerModel {

        private final boolean attachmentsButtonEnabled;
        private final List<zendesk.support.request.StateRequestAttachment> extraAttachments;
        private final long maxFileSize;
        private final boolean messageComposerVisible;
        private final List<zendesk.support.request.StateRequestAttachment> requestAttachments;
        private final boolean sendButtonEnabled;
        MessageComposerModel(List<zendesk.support.request.StateRequestAttachment> list, List<zendesk.support.request.StateRequestAttachment> list2, long l3, boolean z4, boolean z5, boolean z6) {
            super();
            this.requestAttachments = list;
            this.extraAttachments = list2;
            this.maxFileSize = l3;
            this.sendButtonEnabled = z5;
            this.attachmentsButtonEnabled = z6;
            this.messageComposerVisible = obj7;
        }

        List<zendesk.support.request.StateRequestAttachment> getExtraAttachments() {
            return this.extraAttachments;
        }

        long getMaxFileSize() {
            return this.maxFileSize;
        }

        List<zendesk.support.request.StateRequestAttachment> getRequestAttachments() {
            return this.requestAttachments;
        }

        boolean isAttachmentsButtonEnabled() {
            return this.attachmentsButtonEnabled;
        }

        boolean isMessageComposerVisible() {
            return this.messageComposerVisible;
        }

        boolean isSendButtonEnabled() {
            return this.sendButtonEnabled;
        }
    }

    static class MessageComposerSelector implements p<zendesk.support.request.ComponentMessageComposer.MessageComposerModel> {
        @Override // o.b.p
        public Object selectData(o o) {
            return selectData(o);
        }

        @Override // o.b.p
        public zendesk.support.request.ComponentMessageComposer.MessageComposerModel selectData(o o) {
            int obj11;
            zendesk.support.request.StateAttachments state = StateAttachments.fromState(o);
            final zendesk.support.request.StateConfig state2 = StateConfig.fromState(o);
            obj11 = StateConversation.fromState(o);
            ArrayList arrayList = new ArrayList(state.getAllSelectedAttachments());
            obj11 = obj11.getStatus() != RequestStatus.Closed ? 1 : 0;
            super(a.c(state.getSelectedAttachments()), arrayList, state2.getSettings().getMaxAttachmentSize(), obj6, g.c(obj11.getRemoteId()), state2.getSettings().isAttachmentsEnabled(), obj11);
            return obj11;
        }
    }
    ComponentMessageComposer(d d, e e2, zendesk.support.request.ViewMessageComposer viewMessageComposer3, f f4, zendesk.support.request.ActionFactory actionFactory5) {
        super();
        this.activity = d;
        this.messageComposerView = viewMessageComposer3;
        this.dispatcher = f4;
        this.actionFactory = actionFactory5;
        this.imageStream = e2;
        ComponentMessageComposer.MessageComposerSelector obj1 = new ComponentMessageComposer.MessageComposerSelector();
        this.messageFieldSelector = obj1;
        int[] obj2 = new int[2];
        obj1 = new AttachmentHelper(obj2);
        this.attachmentHelper = obj1;
        viewMessageComposer3.addListener(this);
        initImagePicker();
    }

    static zendesk.support.request.ViewMessageComposer access$000(zendesk.support.request.ComponentMessageComposer componentMessageComposer) {
        return componentMessageComposer.messageComposerView;
    }

    private void initImagePicker() {
        boolean messageComposerView;
        boolean messageComposerView2;
        zendesk.support.request.ComponentMessageComposer.1 anon;
        this.imageStream.C1(this);
        if (this.imageStream.E1().getInputTrap().hasFocus()) {
            this.messageComposerView.requestFocusForInput();
        }
        if (this.imageStream.O1()) {
            anon = new ComponentMessageComposer.1(this);
            this.messageComposerView.post(anon);
        }
    }

    public p<zendesk.support.request.ComponentMessageComposer.MessageComposerModel> getSelector() {
        return this.messageFieldSelector;
    }

    @Override // o.b.k
    boolean hasUnsavedInput() {
        int i;
        boolean z;
        if (!g.c(this.messageComposerView.getMessage())) {
            if (a.i(this.attachmentHelper.getSelectedAttachments())) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // o.b.k
    public void onAddAttachmentsRequested() {
        Object attachmentHelper;
        d activity;
        if (!this.imageStream.G1()) {
            this.attachmentHelper.showImagePicker(this.activity);
        } else {
            this.imageStream.dismiss();
        }
    }

    @Override // o.b.k
    public void onDismissed() {
        this.messageComposerView.requestFocusForInput();
    }

    public void onMediaDeselected(List<s> list) {
        this.dispatcher.c(this.actionFactory.deselectAttachment(list));
        if (!this.imageStream.G1()) {
            onAddAttachmentsRequested();
        }
    }

    public void onMediaSelected(List<s> list) {
        this.dispatcher.c(this.actionFactory.selectAttachment(list));
        if (!this.imageStream.G1()) {
            onAddAttachmentsRequested();
        }
    }

    @Override // o.b.k
    public void onSendMessageRequested(String string) {
        boolean imageStream;
        if (this.imageStream.G1()) {
            this.imageStream.dismiss();
        }
        this.dispatcher.c(this.actionFactory.createCommentAsync(string, this.attachmentHelper.getSelectedAttachments()));
        this.dispatcher.c(this.actionFactory.clearAttachments());
        this.dispatcher.c(this.actionFactory.updateCommentsAsync());
    }

    @Override // o.b.k
    public void onVisible() {
        ComponentMessageComposer.2 anon = new ComponentMessageComposer.2(this);
        this.messageComposerView.post(anon);
    }

    @Override // o.b.k
    public void update(Object object) {
        update((ComponentMessageComposer.MessageComposerModel)object);
    }

    @Override // o.b.k
    public void update(zendesk.support.request.ComponentMessageComposer.MessageComposerModel componentMessageComposer$MessageComposerModel) {
        boolean obj4;
        this.attachmentHelper.updateMaxFileSize(messageComposerModel.getMaxFileSize());
        this.attachmentHelper.updateAttachments(messageComposerModel.getRequestAttachments(), messageComposerModel.getExtraAttachments());
        this.messageComposerView.setAttachmentsCount(messageComposerModel.getRequestAttachments().size());
        this.messageComposerView.enableSendButton(messageComposerModel.isSendButtonEnabled());
        this.messageComposerView.enableAttachmentsButton(messageComposerModel.isAttachmentsButtonEnabled());
        this.messageComposerView.hide(messageComposerVisible ^= 1);
        if (!messageComposerModel.isMessageComposerVisible()) {
            UiUtils.dismissKeyboard(this.messageComposerView);
        }
    }
}

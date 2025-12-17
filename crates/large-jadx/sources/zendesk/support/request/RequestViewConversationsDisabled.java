package zendesk.support.request;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.t;
import f.g.d.f;
import f.g.d.h;
import f.g.d.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.b.d;
import o.b.q;
import o.b.t;
import zendesk.belvedere.b;
import zendesk.belvedere.e;
import zendesk.belvedere.p;

/* loaded from: classes3.dex */
public class RequestViewConversationsDisabled extends FrameLayout implements zendesk.support.request.RequestView {

    private d activity;
    zendesk.support.request.ActionFactory af;
    private zendesk.support.request.AttachmentHelper attachmentHelper;
    private e imageStream;
    private zendesk.support.request.ComponentInputForm inputFormComponent;
    private List<zendesk.support.request.RequestViewConversationsDisabled.MenuItemsDelegate> menuItemsDelegates;
    t picasso;
    q store;
    private t subscription;

    interface MenuItemsDelegate {
        public abstract void onMenuItemsClicked(MenuItem menuItem);

        public abstract void onMenuItemsInflated(MenuItem menuItem, MenuItem menuItem2);
    }
    public RequestViewConversationsDisabled(Context context) {
        super(context);
        ArrayList arrayList = new ArrayList();
        this.menuItemsDelegates = arrayList;
        viewInit(context);
    }

    public RequestViewConversationsDisabled(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        ArrayList obj2 = new ArrayList();
        this.menuItemsDelegates = obj2;
        viewInit(context);
    }

    public RequestViewConversationsDisabled(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        ArrayList obj2 = new ArrayList();
        this.menuItemsDelegates = obj2;
        viewInit(context);
    }

    private t bindAttachmentCarousel(q q, zendesk.support.request.ActionFactory actionFactory2) {
        android.view.View viewById = this.activity.findViewById(f.K);
        AdapterAttachmentCarousel adapterAttachmentCarousel = new AdapterAttachmentCarousel(this.attachmentHelper, this.picasso, actionFactory2, q);
        super(q, actionFactory2, this.imageStream, this.activity, this.attachmentHelper, (RecyclerView)viewById);
        int i2 = 0;
        LinearLayoutManager obj12 = new LinearLayoutManager(this.activity, i2, i2);
        viewById.setLayoutManager(obj12);
        viewById.setAdapter(adapterAttachmentCarousel);
        this.menuItemsDelegates.add(componentAttachmentCarousel2);
        return q.e(componentAttachmentCarousel2.getSelector(), componentAttachmentCarousel2);
    }

    private t bindComponents(q q, zendesk.support.request.ActionFactory actionFactory2) {
        t[] arr = new t[2];
        return d.d(bindInput(q), bindAttachmentCarousel(q, actionFactory2));
    }

    private t bindInput(q q) {
        zendesk.support.request.ComponentInputForm create = ComponentInputForm.create(this, q, this.af, this.attachmentHelper);
        this.inputFormComponent = create;
        this.menuItemsDelegates.add(create);
        this.imageStream.E1().i(this.inputFormComponent);
        return q.e(this.inputFormComponent.getSelector(), this.inputFormComponent);
    }

    private void viewInit(Context context) {
        FrameLayout.inflate(context, h.s, this);
        this.activity = (d)context;
    }

    @Override // android.widget.FrameLayout
    public boolean hasUnsavedInput() {
        zendesk.support.request.ComponentInputForm inputFormComponent;
        int i;
        inputFormComponent = this.inputFormComponent;
        if (inputFormComponent != null && inputFormComponent.hasUnsavedInput()) {
            i = inputFormComponent.hasUnsavedInput() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.widget.FrameLayout
    public boolean inflateMenu(MenuInflater menuInflater, Menu menu2) {
        Object next;
        menuInflater.inflate(i.a, menu2);
        Iterator iterator = this.menuItemsDelegates.iterator();
        for (RequestViewConversationsDisabled.MenuItemsDelegate next : iterator) {
            next.onMenuItemsInflated(menu2.findItem(f.T), menu2.findItem(f.S));
        }
        return 1;
    }

    @Override // android.widget.FrameLayout
    public void init(zendesk.support.request.RequestComponent requestComponent) {
        requestComponent.inject(this);
        this.imageStream = b.b(this.activity);
        AttachmentHelper obj2 = new AttachmentHelper(new int[0]);
        this.attachmentHelper = obj2;
        obj2 = bindComponents(this.store, this.af);
        this.subscription = obj2;
        obj2.a();
    }

    @Override // android.widget.FrameLayout
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final t subscription = this.subscription;
        if (subscription != null) {
            subscription.c();
        }
    }

    @Override // android.widget.FrameLayout
    public boolean onOptionsItemClicked(MenuItem menuItem) {
        Object next;
        Iterator iterator = this.menuItemsDelegates.iterator();
        for (RequestViewConversationsDisabled.MenuItemsDelegate next : iterator) {
            next.onMenuItemsClicked(menuItem);
        }
        return 1;
    }
}

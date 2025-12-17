package zendesk.messaging.ui;

import androidx.appcompat.app.d;
import g.b.b;
import j.a.a;
import zendesk.belvedere.e;
import zendesk.messaging.BelvedereMediaHolder;

/* loaded from: classes3.dex */
public final class InputBoxAttachmentClickListener_Factory implements b<zendesk.messaging.ui.InputBoxAttachmentClickListener> {

    private final a<d> activityProvider;
    private final a<BelvedereMediaHolder> belvedereMediaHolderProvider;
    private final a<e> imageStreamProvider;
    public InputBoxAttachmentClickListener_Factory(a<d> a, a<e> a2, a<BelvedereMediaHolder> a3) {
        super();
        this.activityProvider = a;
        this.imageStreamProvider = a2;
        this.belvedereMediaHolderProvider = a3;
    }

    public static zendesk.messaging.ui.InputBoxAttachmentClickListener_Factory create(a<d> a, a<e> a2, a<BelvedereMediaHolder> a3) {
        InputBoxAttachmentClickListener_Factory inputBoxAttachmentClickListener_Factory = new InputBoxAttachmentClickListener_Factory(a, a2, a3);
        return inputBoxAttachmentClickListener_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.ui.InputBoxAttachmentClickListener get() {
        InputBoxAttachmentClickListener inputBoxAttachmentClickListener = new InputBoxAttachmentClickListener((d)this.activityProvider.get(), (e)this.imageStreamProvider.get(), (BelvedereMediaHolder)this.belvedereMediaHolderProvider.get());
        return inputBoxAttachmentClickListener;
    }
}

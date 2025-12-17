package zendesk.messaging.ui;

import android.content.res.Resources;
import g.b.b;
import j.a.a;

/* loaded from: classes3.dex */
public final class MessagingCellPropsFactory_Factory implements b<zendesk.messaging.ui.MessagingCellPropsFactory> {

    private final a<Resources> resourcesProvider;
    public MessagingCellPropsFactory_Factory(a<Resources> a) {
        super();
        this.resourcesProvider = a;
    }

    public static zendesk.messaging.ui.MessagingCellPropsFactory_Factory create(a<Resources> a) {
        MessagingCellPropsFactory_Factory messagingCellPropsFactory_Factory = new MessagingCellPropsFactory_Factory(a);
        return messagingCellPropsFactory_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.ui.MessagingCellPropsFactory get() {
        MessagingCellPropsFactory messagingCellPropsFactory = new MessagingCellPropsFactory((Resources)this.resourcesProvider.get());
        return messagingCellPropsFactory;
    }
}

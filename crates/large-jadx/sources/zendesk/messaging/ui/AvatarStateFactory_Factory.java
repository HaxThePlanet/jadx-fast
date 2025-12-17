package zendesk.messaging.ui;

import g.b.b;

/* loaded from: classes3.dex */
public final class AvatarStateFactory_Factory implements b<zendesk.messaging.ui.AvatarStateFactory> {

    private static final zendesk.messaging.ui.AvatarStateFactory_Factory INSTANCE;
    static {
        AvatarStateFactory_Factory avatarStateFactory_Factory = new AvatarStateFactory_Factory();
        AvatarStateFactory_Factory.INSTANCE = avatarStateFactory_Factory;
    }

    public static zendesk.messaging.ui.AvatarStateFactory_Factory create() {
        return AvatarStateFactory_Factory.INSTANCE;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.ui.AvatarStateFactory get() {
        AvatarStateFactory avatarStateFactory = new AvatarStateFactory();
        return avatarStateFactory;
    }
}

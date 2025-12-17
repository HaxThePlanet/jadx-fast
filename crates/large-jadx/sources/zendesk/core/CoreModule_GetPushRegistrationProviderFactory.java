package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetPushRegistrationProviderFactory implements b<zendesk.core.PushRegistrationProvider> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetPushRegistrationProviderFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetPushRegistrationProviderFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetPushRegistrationProviderFactory coreModule_GetPushRegistrationProviderFactory = new CoreModule_GetPushRegistrationProviderFactory(coreModule);
        return coreModule_GetPushRegistrationProviderFactory;
    }

    public static zendesk.core.PushRegistrationProvider getPushRegistrationProvider(zendesk.core.CoreModule coreModule) {
        final zendesk.core.PushRegistrationProvider obj1 = coreModule.getPushRegistrationProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (PushRegistrationProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.PushRegistrationProvider get() {
        return CoreModule_GetPushRegistrationProviderFactory.getPushRegistrationProvider(this.module);
    }
}

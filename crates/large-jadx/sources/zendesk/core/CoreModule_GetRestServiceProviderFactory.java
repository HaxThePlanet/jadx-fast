package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetRestServiceProviderFactory implements b<zendesk.core.RestServiceProvider> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetRestServiceProviderFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetRestServiceProviderFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetRestServiceProviderFactory coreModule_GetRestServiceProviderFactory = new CoreModule_GetRestServiceProviderFactory(coreModule);
        return coreModule_GetRestServiceProviderFactory;
    }

    public static zendesk.core.RestServiceProvider getRestServiceProvider(zendesk.core.CoreModule coreModule) {
        final zendesk.core.RestServiceProvider obj1 = coreModule.getRestServiceProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (RestServiceProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.RestServiceProvider get() {
        return CoreModule_GetRestServiceProviderFactory.getRestServiceProvider(this.module);
    }
}

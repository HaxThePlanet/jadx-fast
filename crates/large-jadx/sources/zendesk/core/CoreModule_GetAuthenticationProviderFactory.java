package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetAuthenticationProviderFactory implements b<zendesk.core.AuthenticationProvider> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetAuthenticationProviderFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetAuthenticationProviderFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetAuthenticationProviderFactory coreModule_GetAuthenticationProviderFactory = new CoreModule_GetAuthenticationProviderFactory(coreModule);
        return coreModule_GetAuthenticationProviderFactory;
    }

    public static zendesk.core.AuthenticationProvider getAuthenticationProvider(zendesk.core.CoreModule coreModule) {
        final zendesk.core.AuthenticationProvider obj1 = coreModule.getAuthenticationProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (AuthenticationProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.AuthenticationProvider get() {
        return CoreModule_GetAuthenticationProviderFactory.getAuthenticationProvider(this.module);
    }
}

package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetNetworkInfoProviderFactory implements b<zendesk.core.NetworkInfoProvider> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetNetworkInfoProviderFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetNetworkInfoProviderFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetNetworkInfoProviderFactory coreModule_GetNetworkInfoProviderFactory = new CoreModule_GetNetworkInfoProviderFactory(coreModule);
        return coreModule_GetNetworkInfoProviderFactory;
    }

    public static zendesk.core.NetworkInfoProvider getNetworkInfoProvider(zendesk.core.CoreModule coreModule) {
        final zendesk.core.NetworkInfoProvider obj1 = coreModule.getNetworkInfoProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (NetworkInfoProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.NetworkInfoProvider get() {
        return CoreModule_GetNetworkInfoProviderFactory.getNetworkInfoProvider(this.module);
    }
}

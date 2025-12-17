package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetSettingsProviderFactory implements b<zendesk.core.SettingsProvider> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetSettingsProviderFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetSettingsProviderFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetSettingsProviderFactory coreModule_GetSettingsProviderFactory = new CoreModule_GetSettingsProviderFactory(coreModule);
        return coreModule_GetSettingsProviderFactory;
    }

    public static zendesk.core.SettingsProvider getSettingsProvider(zendesk.core.CoreModule coreModule) {
        final zendesk.core.SettingsProvider obj1 = coreModule.getSettingsProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (SettingsProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.SettingsProvider get() {
        return CoreModule_GetSettingsProviderFactory.getSettingsProvider(this.module);
    }
}

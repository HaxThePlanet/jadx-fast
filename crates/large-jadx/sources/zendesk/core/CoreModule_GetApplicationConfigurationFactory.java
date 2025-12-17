package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetApplicationConfigurationFactory implements b<zendesk.core.ApplicationConfiguration> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetApplicationConfigurationFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetApplicationConfigurationFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetApplicationConfigurationFactory coreModule_GetApplicationConfigurationFactory = new CoreModule_GetApplicationConfigurationFactory(coreModule);
        return coreModule_GetApplicationConfigurationFactory;
    }

    public static zendesk.core.ApplicationConfiguration getApplicationConfiguration(zendesk.core.CoreModule coreModule) {
        final zendesk.core.ApplicationConfiguration obj1 = coreModule.getApplicationConfiguration();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ApplicationConfiguration)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ApplicationConfiguration get() {
        return CoreModule_GetApplicationConfigurationFactory.getApplicationConfiguration(this.module);
    }
}

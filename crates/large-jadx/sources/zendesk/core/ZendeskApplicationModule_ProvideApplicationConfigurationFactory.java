package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideApplicationConfigurationFactory implements b<zendesk.core.ApplicationConfiguration> {

    private final zendesk.core.ZendeskApplicationModule module;
    public ZendeskApplicationModule_ProvideApplicationConfigurationFactory(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
        super();
        this.module = zendeskApplicationModule;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideApplicationConfigurationFactory create(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
        ZendeskApplicationModule_ProvideApplicationConfigurationFactory zendeskApplicationModule_ProvideApplicationConfigurationFactory = new ZendeskApplicationModule_ProvideApplicationConfigurationFactory(zendeskApplicationModule);
        return zendeskApplicationModule_ProvideApplicationConfigurationFactory;
    }

    public static zendesk.core.ApplicationConfiguration provideApplicationConfiguration(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
        final zendesk.core.ApplicationConfiguration obj1 = zendeskApplicationModule.provideApplicationConfiguration();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ApplicationConfiguration)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ApplicationConfiguration get() {
        return ZendeskApplicationModule_ProvideApplicationConfigurationFactory.provideApplicationConfiguration(this.module);
    }
}

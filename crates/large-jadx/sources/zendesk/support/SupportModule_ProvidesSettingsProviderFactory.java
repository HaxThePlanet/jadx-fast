package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class SupportModule_ProvidesSettingsProviderFactory implements b<zendesk.support.SupportSettingsProvider> {

    private final zendesk.support.SupportModule module;
    public SupportModule_ProvidesSettingsProviderFactory(zendesk.support.SupportModule supportModule) {
        super();
        this.module = supportModule;
    }

    public static zendesk.support.SupportModule_ProvidesSettingsProviderFactory create(zendesk.support.SupportModule supportModule) {
        SupportModule_ProvidesSettingsProviderFactory supportModule_ProvidesSettingsProviderFactory = new SupportModule_ProvidesSettingsProviderFactory(supportModule);
        return supportModule_ProvidesSettingsProviderFactory;
    }

    public static zendesk.support.SupportSettingsProvider providesSettingsProvider(zendesk.support.SupportModule supportModule) {
        final zendesk.support.SupportSettingsProvider obj1 = supportModule.providesSettingsProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (SupportSettingsProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.SupportSettingsProvider get() {
        return SupportModule_ProvidesSettingsProviderFactory.providesSettingsProvider(this.module);
    }
}

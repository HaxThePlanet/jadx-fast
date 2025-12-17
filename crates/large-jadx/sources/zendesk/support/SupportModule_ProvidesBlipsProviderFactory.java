package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class SupportModule_ProvidesBlipsProviderFactory implements b<zendesk.support.SupportBlipsProvider> {

    private final zendesk.support.SupportModule module;
    public SupportModule_ProvidesBlipsProviderFactory(zendesk.support.SupportModule supportModule) {
        super();
        this.module = supportModule;
    }

    public static zendesk.support.SupportModule_ProvidesBlipsProviderFactory create(zendesk.support.SupportModule supportModule) {
        SupportModule_ProvidesBlipsProviderFactory supportModule_ProvidesBlipsProviderFactory = new SupportModule_ProvidesBlipsProviderFactory(supportModule);
        return supportModule_ProvidesBlipsProviderFactory;
    }

    public static zendesk.support.SupportBlipsProvider providesBlipsProvider(zendesk.support.SupportModule supportModule) {
        final zendesk.support.SupportBlipsProvider obj1 = supportModule.providesBlipsProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (SupportBlipsProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.SupportBlipsProvider get() {
        return SupportModule_ProvidesBlipsProviderFactory.providesBlipsProvider(this.module);
    }
}

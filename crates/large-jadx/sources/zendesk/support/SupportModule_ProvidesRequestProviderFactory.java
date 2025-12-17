package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class SupportModule_ProvidesRequestProviderFactory implements b<zendesk.support.RequestProvider> {

    private final zendesk.support.SupportModule module;
    public SupportModule_ProvidesRequestProviderFactory(zendesk.support.SupportModule supportModule) {
        super();
        this.module = supportModule;
    }

    public static zendesk.support.SupportModule_ProvidesRequestProviderFactory create(zendesk.support.SupportModule supportModule) {
        SupportModule_ProvidesRequestProviderFactory supportModule_ProvidesRequestProviderFactory = new SupportModule_ProvidesRequestProviderFactory(supportModule);
        return supportModule_ProvidesRequestProviderFactory;
    }

    public static zendesk.support.RequestProvider providesRequestProvider(zendesk.support.SupportModule supportModule) {
        final zendesk.support.RequestProvider obj1 = supportModule.providesRequestProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.RequestProvider get() {
        return SupportModule_ProvidesRequestProviderFactory.providesRequestProvider(this.module);
    }
}

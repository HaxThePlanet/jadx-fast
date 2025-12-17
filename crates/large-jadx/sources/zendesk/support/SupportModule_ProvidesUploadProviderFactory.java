package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class SupportModule_ProvidesUploadProviderFactory implements b<zendesk.support.UploadProvider> {

    private final zendesk.support.SupportModule module;
    public SupportModule_ProvidesUploadProviderFactory(zendesk.support.SupportModule supportModule) {
        super();
        this.module = supportModule;
    }

    public static zendesk.support.SupportModule_ProvidesUploadProviderFactory create(zendesk.support.SupportModule supportModule) {
        SupportModule_ProvidesUploadProviderFactory supportModule_ProvidesUploadProviderFactory = new SupportModule_ProvidesUploadProviderFactory(supportModule);
        return supportModule_ProvidesUploadProviderFactory;
    }

    public static zendesk.support.UploadProvider providesUploadProvider(zendesk.support.SupportModule supportModule) {
        final zendesk.support.UploadProvider obj1 = supportModule.providesUploadProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (UploadProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.UploadProvider get() {
        return SupportModule_ProvidesUploadProviderFactory.providesUploadProvider(this.module);
    }
}

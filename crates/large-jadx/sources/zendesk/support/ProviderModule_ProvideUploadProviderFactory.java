package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ProviderModule_ProvideUploadProviderFactory implements b<zendesk.support.UploadProvider> {

    private final zendesk.support.ProviderModule module;
    private final a<zendesk.support.ZendeskUploadService> uploadServiceProvider;
    public ProviderModule_ProvideUploadProviderFactory(zendesk.support.ProviderModule providerModule, a<zendesk.support.ZendeskUploadService> a2) {
        super();
        this.module = providerModule;
        this.uploadServiceProvider = a2;
    }

    public static zendesk.support.ProviderModule_ProvideUploadProviderFactory create(zendesk.support.ProviderModule providerModule, a<zendesk.support.ZendeskUploadService> a2) {
        ProviderModule_ProvideUploadProviderFactory providerModule_ProvideUploadProviderFactory = new ProviderModule_ProvideUploadProviderFactory(providerModule, a2);
        return providerModule_ProvideUploadProviderFactory;
    }

    public static zendesk.support.UploadProvider provideUploadProvider(zendesk.support.ProviderModule providerModule, Object object2) {
        final zendesk.support.UploadProvider obj0 = providerModule.provideUploadProvider((ZendeskUploadService)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (UploadProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.UploadProvider get() {
        return ProviderModule_ProvideUploadProviderFactory.provideUploadProvider(this.module, this.uploadServiceProvider.get());
    }
}

package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ProviderModule_ProvideProviderStoreFactory implements b<zendesk.support.ProviderStore> {

    private final a<zendesk.support.HelpCenterProvider> helpCenterProvider;
    private final zendesk.support.ProviderModule module;
    private final a<zendesk.support.RequestProvider> requestProvider;
    private final a<zendesk.support.UploadProvider> uploadProvider;
    public ProviderModule_ProvideProviderStoreFactory(zendesk.support.ProviderModule providerModule, a<zendesk.support.HelpCenterProvider> a2, a<zendesk.support.RequestProvider> a3, a<zendesk.support.UploadProvider> a4) {
        super();
        this.module = providerModule;
        this.helpCenterProvider = a2;
        this.requestProvider = a3;
        this.uploadProvider = a4;
    }

    public static zendesk.support.ProviderModule_ProvideProviderStoreFactory create(zendesk.support.ProviderModule providerModule, a<zendesk.support.HelpCenterProvider> a2, a<zendesk.support.RequestProvider> a3, a<zendesk.support.UploadProvider> a4) {
        ProviderModule_ProvideProviderStoreFactory providerModule_ProvideProviderStoreFactory = new ProviderModule_ProvideProviderStoreFactory(providerModule, a2, a3, a4);
        return providerModule_ProvideProviderStoreFactory;
    }

    public static zendesk.support.ProviderStore provideProviderStore(zendesk.support.ProviderModule providerModule, zendesk.support.HelpCenterProvider helpCenterProvider2, zendesk.support.RequestProvider requestProvider3, zendesk.support.UploadProvider uploadProvider4) {
        final zendesk.support.ProviderStore obj0 = providerModule.provideProviderStore(helpCenterProvider2, requestProvider3, uploadProvider4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ProviderStore)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.ProviderStore get() {
        return ProviderModule_ProvideProviderStoreFactory.provideProviderStore(this.module, (HelpCenterProvider)this.helpCenterProvider.get(), (RequestProvider)this.requestProvider.get(), (UploadProvider)this.uploadProvider.get());
    }
}

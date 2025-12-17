package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.AuthenticationProvider;

/* loaded from: classes3.dex */
public final class ProviderModule_ProvideRequestProviderFactory implements b<zendesk.support.RequestProvider> {

    private final a<AuthenticationProvider> authenticationProvider;
    private final a<zendesk.support.SupportBlipsProvider> blipsProvider;
    private final zendesk.support.ProviderModule module;
    private final a<zendesk.support.ZendeskRequestService> requestServiceProvider;
    private final a<zendesk.support.RequestSessionCache> requestSessionCacheProvider;
    private final a<zendesk.support.RequestStorage> requestStorageProvider;
    private final a<zendesk.support.SupportSettingsProvider> settingsProvider;
    private final a<zendesk.support.SupportSdkMetadata> supportSdkMetadataProvider;
    private final a<zendesk.support.ZendeskTracker> zendeskTrackerProvider;
    public ProviderModule_ProvideRequestProviderFactory(zendesk.support.ProviderModule providerModule, a<zendesk.support.SupportSettingsProvider> a2, a<AuthenticationProvider> a3, a<zendesk.support.ZendeskRequestService> a4, a<zendesk.support.RequestStorage> a5, a<zendesk.support.RequestSessionCache> a6, a<zendesk.support.ZendeskTracker> a7, a<zendesk.support.SupportSdkMetadata> a8, a<zendesk.support.SupportBlipsProvider> a9) {
        super();
        this.module = providerModule;
        this.settingsProvider = a2;
        this.authenticationProvider = a3;
        this.requestServiceProvider = a4;
        this.requestStorageProvider = a5;
        this.requestSessionCacheProvider = a6;
        this.zendeskTrackerProvider = a7;
        this.supportSdkMetadataProvider = a8;
        this.blipsProvider = a9;
    }

    public static zendesk.support.ProviderModule_ProvideRequestProviderFactory create(zendesk.support.ProviderModule providerModule, a<zendesk.support.SupportSettingsProvider> a2, a<AuthenticationProvider> a3, a<zendesk.support.ZendeskRequestService> a4, a<zendesk.support.RequestStorage> a5, a<zendesk.support.RequestSessionCache> a6, a<zendesk.support.ZendeskTracker> a7, a<zendesk.support.SupportSdkMetadata> a8, a<zendesk.support.SupportBlipsProvider> a9) {
        super(providerModule, a2, a3, a4, a5, a6, a7, a8, a9);
        return providerModule_ProvideRequestProviderFactory;
    }

    public static zendesk.support.RequestProvider provideRequestProvider(zendesk.support.ProviderModule providerModule, zendesk.support.SupportSettingsProvider supportSettingsProvider2, AuthenticationProvider authenticationProvider3, Object object4, Object object5, Object object6, Object object7, Object object8, zendesk.support.SupportBlipsProvider supportBlipsProvider9) {
        zendesk.support.RequestProvider provideRequestProvider = providerModule.provideRequestProvider(supportSettingsProvider2, authenticationProvider3, (ZendeskRequestService)object4, (RequestStorage)object5, (RequestSessionCache)object6, (ZendeskTracker)object7, (SupportSdkMetadata)object8, supportBlipsProvider9);
        d.c(provideRequestProvider, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestProvider)provideRequestProvider;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.RequestProvider get() {
        return ProviderModule_ProvideRequestProviderFactory.provideRequestProvider(this.module, (SupportSettingsProvider)this.settingsProvider.get(), (AuthenticationProvider)this.authenticationProvider.get(), this.requestServiceProvider.get(), this.requestStorageProvider.get(), this.requestSessionCacheProvider.get(), this.zendeskTrackerProvider.get(), this.supportSdkMetadataProvider.get(), (SupportBlipsProvider)this.blipsProvider.get());
    }
}

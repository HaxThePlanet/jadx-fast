package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideSdkSettingsServiceFactory implements b<zendesk.core.SdkSettingsService> {

    private final a<Retrofit> retrofitProvider;
    public ZendeskProvidersModule_ProvideSdkSettingsServiceFactory(a<Retrofit> a) {
        super();
        this.retrofitProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideSdkSettingsServiceFactory create(a<Retrofit> a) {
        ZendeskProvidersModule_ProvideSdkSettingsServiceFactory zendeskProvidersModule_ProvideSdkSettingsServiceFactory = new ZendeskProvidersModule_ProvideSdkSettingsServiceFactory(a);
        return zendeskProvidersModule_ProvideSdkSettingsServiceFactory;
    }

    public static zendesk.core.SdkSettingsService provideSdkSettingsService(Retrofit retrofit) {
        final zendesk.core.SdkSettingsService obj1 = ZendeskProvidersModule.provideSdkSettingsService(retrofit);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (SdkSettingsService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.SdkSettingsService get() {
        return ZendeskProvidersModule_ProvideSdkSettingsServiceFactory.provideSdkSettingsService((Retrofit)this.retrofitProvider.get());
    }
}

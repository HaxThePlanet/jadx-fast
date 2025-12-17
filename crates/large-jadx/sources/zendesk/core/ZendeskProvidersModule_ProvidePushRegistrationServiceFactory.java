package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvidePushRegistrationServiceFactory implements b<zendesk.core.PushRegistrationService> {

    private final a<Retrofit> retrofitProvider;
    public ZendeskProvidersModule_ProvidePushRegistrationServiceFactory(a<Retrofit> a) {
        super();
        this.retrofitProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvidePushRegistrationServiceFactory create(a<Retrofit> a) {
        ZendeskProvidersModule_ProvidePushRegistrationServiceFactory zendeskProvidersModule_ProvidePushRegistrationServiceFactory = new ZendeskProvidersModule_ProvidePushRegistrationServiceFactory(a);
        return zendeskProvidersModule_ProvidePushRegistrationServiceFactory;
    }

    public static zendesk.core.PushRegistrationService providePushRegistrationService(Retrofit retrofit) {
        final zendesk.core.PushRegistrationService obj1 = ZendeskProvidersModule.providePushRegistrationService(retrofit);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (PushRegistrationService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.PushRegistrationService get() {
        return ZendeskProvidersModule_ProvidePushRegistrationServiceFactory.providePushRegistrationService((Retrofit)this.retrofitProvider.get());
    }
}

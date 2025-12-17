package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideUserServiceFactory implements b<zendesk.core.UserService> {

    private final a<Retrofit> retrofitProvider;
    public ZendeskProvidersModule_ProvideUserServiceFactory(a<Retrofit> a) {
        super();
        this.retrofitProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideUserServiceFactory create(a<Retrofit> a) {
        ZendeskProvidersModule_ProvideUserServiceFactory zendeskProvidersModule_ProvideUserServiceFactory = new ZendeskProvidersModule_ProvideUserServiceFactory(a);
        return zendeskProvidersModule_ProvideUserServiceFactory;
    }

    public static zendesk.core.UserService provideUserService(Retrofit retrofit) {
        final zendesk.core.UserService obj1 = ZendeskProvidersModule.provideUserService(retrofit);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (UserService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.UserService get() {
        return ZendeskProvidersModule_ProvideUserServiceFactory.provideUserService((Retrofit)this.retrofitProvider.get());
    }
}

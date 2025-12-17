package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideAccessServiceFactory implements b<zendesk.core.AccessService> {

    private final a<Retrofit> retrofitProvider;
    public ZendeskProvidersModule_ProvideAccessServiceFactory(a<Retrofit> a) {
        super();
        this.retrofitProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideAccessServiceFactory create(a<Retrofit> a) {
        ZendeskProvidersModule_ProvideAccessServiceFactory zendeskProvidersModule_ProvideAccessServiceFactory = new ZendeskProvidersModule_ProvideAccessServiceFactory(a);
        return zendeskProvidersModule_ProvideAccessServiceFactory;
    }

    public static zendesk.core.AccessService provideAccessService(Retrofit retrofit) {
        final zendesk.core.AccessService obj1 = ZendeskProvidersModule.provideAccessService(retrofit);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (AccessService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.AccessService get() {
        return ZendeskProvidersModule_ProvideAccessServiceFactory.provideAccessService((Retrofit)this.retrofitProvider.get());
    }
}

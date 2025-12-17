package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class ZendeskProvidersModule_ProvideBlipsServiceFactory implements b<zendesk.core.BlipsService> {

    private final a<Retrofit> retrofitProvider;
    public ZendeskProvidersModule_ProvideBlipsServiceFactory(a<Retrofit> a) {
        super();
        this.retrofitProvider = a;
    }

    public static zendesk.core.ZendeskProvidersModule_ProvideBlipsServiceFactory create(a<Retrofit> a) {
        ZendeskProvidersModule_ProvideBlipsServiceFactory zendeskProvidersModule_ProvideBlipsServiceFactory = new ZendeskProvidersModule_ProvideBlipsServiceFactory(a);
        return zendeskProvidersModule_ProvideBlipsServiceFactory;
    }

    public static zendesk.core.BlipsService provideBlipsService(Retrofit retrofit) {
        final zendesk.core.BlipsService obj1 = ZendeskProvidersModule.provideBlipsService(retrofit);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (BlipsService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.BlipsService get() {
        return ZendeskProvidersModule_ProvideBlipsServiceFactory.provideBlipsService((Retrofit)this.retrofitProvider.get());
    }
}

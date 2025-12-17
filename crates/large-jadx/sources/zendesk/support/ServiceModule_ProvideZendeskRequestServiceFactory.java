package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ServiceModule_ProvideZendeskRequestServiceFactory implements b<zendesk.support.ZendeskRequestService> {

    private final a<zendesk.support.RequestService> requestServiceProvider;
    public ServiceModule_ProvideZendeskRequestServiceFactory(a<zendesk.support.RequestService> a) {
        super();
        this.requestServiceProvider = a;
    }

    public static zendesk.support.ServiceModule_ProvideZendeskRequestServiceFactory create(a<zendesk.support.RequestService> a) {
        ServiceModule_ProvideZendeskRequestServiceFactory serviceModule_ProvideZendeskRequestServiceFactory = new ServiceModule_ProvideZendeskRequestServiceFactory(a);
        return serviceModule_ProvideZendeskRequestServiceFactory;
    }

    public static zendesk.support.ZendeskRequestService provideZendeskRequestService(Object object) {
        final zendesk.support.ZendeskRequestService obj1 = ServiceModule.provideZendeskRequestService((RequestService)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskRequestService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.ZendeskRequestService get() {
        return ServiceModule_ProvideZendeskRequestServiceFactory.provideZendeskRequestService(this.requestServiceProvider.get());
    }
}

package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.RestServiceProvider;

/* loaded from: classes3.dex */
public final class ServiceModule_ProvidesRequestServiceFactory implements b<zendesk.support.RequestService> {

    private final a<RestServiceProvider> restServiceProvider;
    public ServiceModule_ProvidesRequestServiceFactory(a<RestServiceProvider> a) {
        super();
        this.restServiceProvider = a;
    }

    public static zendesk.support.ServiceModule_ProvidesRequestServiceFactory create(a<RestServiceProvider> a) {
        ServiceModule_ProvidesRequestServiceFactory serviceModule_ProvidesRequestServiceFactory = new ServiceModule_ProvidesRequestServiceFactory(a);
        return serviceModule_ProvidesRequestServiceFactory;
    }

    public static zendesk.support.RequestService providesRequestService(RestServiceProvider restServiceProvider) {
        final zendesk.support.RequestService obj1 = ServiceModule.providesRequestService(restServiceProvider);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.RequestService get() {
        return ServiceModule_ProvidesRequestServiceFactory.providesRequestService((RestServiceProvider)this.restServiceProvider.get());
    }
}

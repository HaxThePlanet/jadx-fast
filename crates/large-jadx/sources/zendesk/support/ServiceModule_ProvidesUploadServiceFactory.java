package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.RestServiceProvider;

/* loaded from: classes3.dex */
public final class ServiceModule_ProvidesUploadServiceFactory implements b<zendesk.support.UploadService> {

    private final a<RestServiceProvider> restServiceProvider;
    public ServiceModule_ProvidesUploadServiceFactory(a<RestServiceProvider> a) {
        super();
        this.restServiceProvider = a;
    }

    public static zendesk.support.ServiceModule_ProvidesUploadServiceFactory create(a<RestServiceProvider> a) {
        ServiceModule_ProvidesUploadServiceFactory serviceModule_ProvidesUploadServiceFactory = new ServiceModule_ProvidesUploadServiceFactory(a);
        return serviceModule_ProvidesUploadServiceFactory;
    }

    public static zendesk.support.UploadService providesUploadService(RestServiceProvider restServiceProvider) {
        final zendesk.support.UploadService obj1 = ServiceModule.providesUploadService(restServiceProvider);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (UploadService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.UploadService get() {
        return ServiceModule_ProvidesUploadServiceFactory.providesUploadService((RestServiceProvider)this.restServiceProvider.get());
    }
}

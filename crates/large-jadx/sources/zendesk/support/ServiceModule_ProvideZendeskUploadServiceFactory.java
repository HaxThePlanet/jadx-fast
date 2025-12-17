package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ServiceModule_ProvideZendeskUploadServiceFactory implements b<zendesk.support.ZendeskUploadService> {

    private final a<zendesk.support.UploadService> uploadServiceProvider;
    public ServiceModule_ProvideZendeskUploadServiceFactory(a<zendesk.support.UploadService> a) {
        super();
        this.uploadServiceProvider = a;
    }

    public static zendesk.support.ServiceModule_ProvideZendeskUploadServiceFactory create(a<zendesk.support.UploadService> a) {
        ServiceModule_ProvideZendeskUploadServiceFactory serviceModule_ProvideZendeskUploadServiceFactory = new ServiceModule_ProvideZendeskUploadServiceFactory(a);
        return serviceModule_ProvideZendeskUploadServiceFactory;
    }

    public static zendesk.support.ZendeskUploadService provideZendeskUploadService(Object object) {
        final zendesk.support.ZendeskUploadService obj1 = ServiceModule.provideZendeskUploadService((UploadService)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskUploadService)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.ZendeskUploadService get() {
        return ServiceModule_ProvideZendeskUploadServiceFactory.provideZendeskUploadService(this.uploadServiceProvider.get());
    }
}

package zendesk.support.request;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesAttachmentToDiskServiceFactory implements b<zendesk.support.request.AttachmentDownloadService> {

    private final a<ExecutorService> executorProvider;
    private final a<OkHttpClient> okHttpClientProvider;
    public RequestModule_ProvidesAttachmentToDiskServiceFactory(a<OkHttpClient> a, a<ExecutorService> a2) {
        super();
        this.okHttpClientProvider = a;
        this.executorProvider = a2;
    }

    public static zendesk.support.request.RequestModule_ProvidesAttachmentToDiskServiceFactory create(a<OkHttpClient> a, a<ExecutorService> a2) {
        RequestModule_ProvidesAttachmentToDiskServiceFactory requestModule_ProvidesAttachmentToDiskServiceFactory = new RequestModule_ProvidesAttachmentToDiskServiceFactory(a, a2);
        return requestModule_ProvidesAttachmentToDiskServiceFactory;
    }

    public static zendesk.support.request.AttachmentDownloadService providesAttachmentToDiskService(OkHttpClient okHttpClient, ExecutorService executorService2) {
        final zendesk.support.request.AttachmentDownloadService obj0 = RequestModule.providesAttachmentToDiskService(okHttpClient, executorService2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AttachmentDownloadService)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.AttachmentDownloadService get() {
        return RequestModule_ProvidesAttachmentToDiskServiceFactory.providesAttachmentToDiskService((OkHttpClient)this.okHttpClientProvider.get(), (ExecutorService)this.executorProvider.get());
    }
}

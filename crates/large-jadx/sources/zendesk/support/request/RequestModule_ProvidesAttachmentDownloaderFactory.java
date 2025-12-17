package zendesk.support.request;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.belvedere.a;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesAttachmentDownloaderFactory implements b<zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader> {

    private final a<zendesk.support.request.AttachmentDownloadService> attachmentToDiskServiceProvider;
    private final a<a> belvedereProvider;
    public RequestModule_ProvidesAttachmentDownloaderFactory(a<a> a, a<zendesk.support.request.AttachmentDownloadService> a2) {
        super();
        this.belvedereProvider = a;
        this.attachmentToDiskServiceProvider = a2;
    }

    public static zendesk.support.request.RequestModule_ProvidesAttachmentDownloaderFactory create(a<a> a, a<zendesk.support.request.AttachmentDownloadService> a2) {
        RequestModule_ProvidesAttachmentDownloaderFactory requestModule_ProvidesAttachmentDownloaderFactory = new RequestModule_ProvidesAttachmentDownloaderFactory(a, a2);
        return requestModule_ProvidesAttachmentDownloaderFactory;
    }

    public static zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader providesAttachmentDownloader(a a, Object object2) {
        final zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader obj0 = RequestModule.providesAttachmentDownloader(a, (AttachmentDownloadService)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AttachmentDownloaderComponent.AttachmentDownloader)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader get() {
        return RequestModule_ProvidesAttachmentDownloaderFactory.providesAttachmentDownloader((a)this.belvedereProvider.get(), this.attachmentToDiskServiceProvider.get());
    }
}

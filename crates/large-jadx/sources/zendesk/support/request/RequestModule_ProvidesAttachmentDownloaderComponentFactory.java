package zendesk.support.request;

import g.b.b;
import g.b.d;
import j.a.a;
import o.b.f;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesAttachmentDownloaderComponentFactory implements b<zendesk.support.request.AttachmentDownloaderComponent> {

    private final a<zendesk.support.request.ActionFactory> actionFactoryProvider;
    private final a<zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader> attachmentDownloaderProvider;
    private final a<f> dispatcherProvider;
    public RequestModule_ProvidesAttachmentDownloaderComponentFactory(a<f> a, a<zendesk.support.request.ActionFactory> a2, a<zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader> a3) {
        super();
        this.dispatcherProvider = a;
        this.actionFactoryProvider = a2;
        this.attachmentDownloaderProvider = a3;
    }

    public static zendesk.support.request.RequestModule_ProvidesAttachmentDownloaderComponentFactory create(a<f> a, a<zendesk.support.request.ActionFactory> a2, a<zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader> a3) {
        RequestModule_ProvidesAttachmentDownloaderComponentFactory requestModule_ProvidesAttachmentDownloaderComponentFactory = new RequestModule_ProvidesAttachmentDownloaderComponentFactory(a, a2, a3);
        return requestModule_ProvidesAttachmentDownloaderComponentFactory;
    }

    public static zendesk.support.request.AttachmentDownloaderComponent providesAttachmentDownloaderComponent(f f, Object object2, Object object3) {
        final zendesk.support.request.AttachmentDownloaderComponent obj0 = RequestModule.providesAttachmentDownloaderComponent(f, (ActionFactory)object2, (AttachmentDownloaderComponent.AttachmentDownloader)object3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AttachmentDownloaderComponent)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.AttachmentDownloaderComponent get() {
        return RequestModule_ProvidesAttachmentDownloaderComponentFactory.providesAttachmentDownloaderComponent((f)this.dispatcherProvider.get(), this.actionFactoryProvider.get(), this.attachmentDownloaderProvider.get());
    }
}

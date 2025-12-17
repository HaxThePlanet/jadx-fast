package zendesk.support.request;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesComponentListenerFactory implements b<zendesk.support.request.HeadlessComponentListener> {

    private final a<zendesk.support.request.AttachmentDownloaderComponent> attachmentDownloaderProvider;
    private final a<zendesk.support.request.ComponentPersistence> persistenceProvider;
    private final a<zendesk.support.request.ComponentUpdateActionHandlers> updatesComponentProvider;
    public RequestModule_ProvidesComponentListenerFactory(a<zendesk.support.request.ComponentPersistence> a, a<zendesk.support.request.AttachmentDownloaderComponent> a2, a<zendesk.support.request.ComponentUpdateActionHandlers> a3) {
        super();
        this.persistenceProvider = a;
        this.attachmentDownloaderProvider = a2;
        this.updatesComponentProvider = a3;
    }

    public static zendesk.support.request.RequestModule_ProvidesComponentListenerFactory create(a<zendesk.support.request.ComponentPersistence> a, a<zendesk.support.request.AttachmentDownloaderComponent> a2, a<zendesk.support.request.ComponentUpdateActionHandlers> a3) {
        RequestModule_ProvidesComponentListenerFactory requestModule_ProvidesComponentListenerFactory = new RequestModule_ProvidesComponentListenerFactory(a, a2, a3);
        return requestModule_ProvidesComponentListenerFactory;
    }

    public static zendesk.support.request.HeadlessComponentListener providesComponentListener(Object object, Object object2, Object object3) {
        final zendesk.support.request.HeadlessComponentListener obj0 = RequestModule.providesComponentListener((ComponentPersistence)object, (AttachmentDownloaderComponent)object2, (ComponentUpdateActionHandlers)object3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (HeadlessComponentListener)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.HeadlessComponentListener get() {
        return RequestModule_ProvidesComponentListenerFactory.providesComponentListener(this.persistenceProvider.get(), this.attachmentDownloaderProvider.get(), this.updatesComponentProvider.get());
    }
}

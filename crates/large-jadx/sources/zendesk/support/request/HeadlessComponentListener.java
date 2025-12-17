package zendesk.support.request;

import o.b.q;

/* loaded from: classes3.dex */
class HeadlessComponentListener {

    private final zendesk.support.request.AttachmentDownloaderComponent attachment;
    private final zendesk.support.request.ComponentPersistence persistence;
    private boolean registered = false;
    private final zendesk.support.request.ComponentUpdateActionHandlers updateActionHandlersComponent;
    HeadlessComponentListener(zendesk.support.request.ComponentPersistence componentPersistence, zendesk.support.request.AttachmentDownloaderComponent attachmentDownloaderComponent2, zendesk.support.request.ComponentUpdateActionHandlers componentUpdateActionHandlers3) {
        super();
        final int i = 0;
        this.persistence = componentPersistence;
        this.attachment = attachmentDownloaderComponent2;
        this.updateActionHandlersComponent = componentUpdateActionHandlers3;
    }

    void startListening(q q) {
        boolean registered;
        zendesk.support.request.ComponentUpdateActionHandlers updateActionHandlersComponent;
        int obj3;
        if (!this.registered) {
            q.e(this.persistence.getSelector(), this.persistence);
            q.a(StateConversation.class, this.attachment);
            q.a(StateConversation.class, this.updateActionHandlersComponent);
            this.registered = true;
        }
    }
}

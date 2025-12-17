package zendesk.messaging;

import g.b.b;
import j.a.a;

/* loaded from: classes3.dex */
public final class MessagingViewModel_Factory implements b<zendesk.messaging.MessagingViewModel> {

    private final a<zendesk.messaging.MessagingModel> messagingModelProvider;
    public MessagingViewModel_Factory(a<zendesk.messaging.MessagingModel> a) {
        super();
        this.messagingModelProvider = a;
    }

    public static zendesk.messaging.MessagingViewModel_Factory create(a<zendesk.messaging.MessagingModel> a) {
        MessagingViewModel_Factory messagingViewModel_Factory = new MessagingViewModel_Factory(a);
        return messagingViewModel_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.MessagingViewModel get() {
        MessagingViewModel messagingViewModel = new MessagingViewModel((MessagingModel)this.messagingModelProvider.get());
        return messagingViewModel;
    }
}

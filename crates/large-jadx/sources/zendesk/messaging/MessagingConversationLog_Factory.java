package zendesk.messaging;

import g.b.b;
import j.a.a;

/* loaded from: classes3.dex */
public final class MessagingConversationLog_Factory implements b<zendesk.messaging.MessagingConversationLog> {

    private final a<zendesk.messaging.MessagingEventSerializer> messagingEventSerializerProvider;
    public MessagingConversationLog_Factory(a<zendesk.messaging.MessagingEventSerializer> a) {
        super();
        this.messagingEventSerializerProvider = a;
    }

    public static zendesk.messaging.MessagingConversationLog_Factory create(a<zendesk.messaging.MessagingEventSerializer> a) {
        MessagingConversationLog_Factory messagingConversationLog_Factory = new MessagingConversationLog_Factory(a);
        return messagingConversationLog_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.MessagingConversationLog get() {
        MessagingConversationLog messagingConversationLog = new MessagingConversationLog((MessagingEventSerializer)this.messagingEventSerializerProvider.get());
        return messagingConversationLog;
    }
}

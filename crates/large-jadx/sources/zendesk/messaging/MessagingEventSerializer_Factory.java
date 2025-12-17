package zendesk.messaging;

import android.content.Context;
import g.b.b;
import j.a.a;

/* loaded from: classes3.dex */
public final class MessagingEventSerializer_Factory implements b<zendesk.messaging.MessagingEventSerializer> {

    private final a<Context> contextProvider;
    private final a<zendesk.messaging.TimestampFactory> timestampFactoryProvider;
    public MessagingEventSerializer_Factory(a<Context> a, a<zendesk.messaging.TimestampFactory> a2) {
        super();
        this.contextProvider = a;
        this.timestampFactoryProvider = a2;
    }

    public static zendesk.messaging.MessagingEventSerializer_Factory create(a<Context> a, a<zendesk.messaging.TimestampFactory> a2) {
        MessagingEventSerializer_Factory messagingEventSerializer_Factory = new MessagingEventSerializer_Factory(a, a2);
        return messagingEventSerializer_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.MessagingEventSerializer get() {
        MessagingEventSerializer messagingEventSerializer = new MessagingEventSerializer((Context)this.contextProvider.get(), (TimestampFactory)this.timestampFactoryProvider.get());
        return messagingEventSerializer;
    }
}

package zendesk.messaging;

import android.os.Handler;
import g.b.b;
import j.a.a;

/* loaded from: classes3.dex */
public final class TypingEventDispatcher_Factory implements b<zendesk.messaging.TypingEventDispatcher> {

    private final a<zendesk.messaging.EventFactory> eventFactoryProvider;
    private final a<zendesk.messaging.EventListener> eventListenerProvider;
    private final a<Handler> handlerProvider;
    public TypingEventDispatcher_Factory(a<zendesk.messaging.EventListener> a, a<Handler> a2, a<zendesk.messaging.EventFactory> a3) {
        super();
        this.eventListenerProvider = a;
        this.handlerProvider = a2;
        this.eventFactoryProvider = a3;
    }

    public static zendesk.messaging.TypingEventDispatcher_Factory create(a<zendesk.messaging.EventListener> a, a<Handler> a2, a<zendesk.messaging.EventFactory> a3) {
        TypingEventDispatcher_Factory typingEventDispatcher_Factory = new TypingEventDispatcher_Factory(a, a2, a3);
        return typingEventDispatcher_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.TypingEventDispatcher get() {
        TypingEventDispatcher typingEventDispatcher = new TypingEventDispatcher((EventListener)this.eventListenerProvider.get(), (Handler)this.handlerProvider.get(), (EventFactory)this.eventFactoryProvider.get());
        return typingEventDispatcher;
    }
}

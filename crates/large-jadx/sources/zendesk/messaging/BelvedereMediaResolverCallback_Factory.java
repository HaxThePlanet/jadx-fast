package zendesk.messaging;

import g.b.b;
import j.a.a;

/* loaded from: classes3.dex */
public final class BelvedereMediaResolverCallback_Factory implements b<zendesk.messaging.BelvedereMediaResolverCallback> {

    private final a<zendesk.messaging.EventFactory> eventFactoryProvider;
    private final a<zendesk.messaging.EventListener> eventListenerProvider;
    public BelvedereMediaResolverCallback_Factory(a<zendesk.messaging.EventListener> a, a<zendesk.messaging.EventFactory> a2) {
        super();
        this.eventListenerProvider = a;
        this.eventFactoryProvider = a2;
    }

    public static zendesk.messaging.BelvedereMediaResolverCallback_Factory create(a<zendesk.messaging.EventListener> a, a<zendesk.messaging.EventFactory> a2) {
        BelvedereMediaResolverCallback_Factory belvedereMediaResolverCallback_Factory = new BelvedereMediaResolverCallback_Factory(a, a2);
        return belvedereMediaResolverCallback_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.BelvedereMediaResolverCallback get() {
        BelvedereMediaResolverCallback belvedereMediaResolverCallback = new BelvedereMediaResolverCallback((EventListener)this.eventListenerProvider.get(), (EventFactory)this.eventFactoryProvider.get());
        return belvedereMediaResolverCallback;
    }
}

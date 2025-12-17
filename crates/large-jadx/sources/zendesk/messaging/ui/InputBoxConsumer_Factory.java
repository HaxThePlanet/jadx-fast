package zendesk.messaging.ui;

import g.b.b;
import j.a.a;
import zendesk.belvedere.a;
import zendesk.belvedere.e;
import zendesk.messaging.BelvedereMediaHolder;
import zendesk.messaging.BelvedereMediaResolverCallback;
import zendesk.messaging.EventFactory;
import zendesk.messaging.EventListener;

/* loaded from: classes3.dex */
public final class InputBoxConsumer_Factory implements b<zendesk.messaging.ui.InputBoxConsumer> {

    private final a<BelvedereMediaHolder> belvedereMediaHolderProvider;
    private final a<BelvedereMediaResolverCallback> belvedereMediaResolverCallbackProvider;
    private final a<a> belvedereProvider;
    private final a<EventFactory> eventFactoryProvider;
    private final a<EventListener> eventListenerProvider;
    private final a<e> imageStreamProvider;
    public InputBoxConsumer_Factory(a<EventListener> a, a<EventFactory> a2, a<e> a3, a<a> a4, a<BelvedereMediaHolder> a5, a<BelvedereMediaResolverCallback> a6) {
        super();
        this.eventListenerProvider = a;
        this.eventFactoryProvider = a2;
        this.imageStreamProvider = a3;
        this.belvedereProvider = a4;
        this.belvedereMediaHolderProvider = a5;
        this.belvedereMediaResolverCallbackProvider = a6;
    }

    public static zendesk.messaging.ui.InputBoxConsumer_Factory create(a<EventListener> a, a<EventFactory> a2, a<e> a3, a<a> a4, a<BelvedereMediaHolder> a5, a<BelvedereMediaResolverCallback> a6) {
        super(a, a2, a3, a4, a5, a6);
        return inputBoxConsumer_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.ui.InputBoxConsumer get() {
        super((EventListener)this.eventListenerProvider.get(), (EventFactory)this.eventFactoryProvider.get(), (e)this.imageStreamProvider.get(), (a)this.belvedereProvider.get(), (BelvedereMediaHolder)this.belvedereMediaHolderProvider.get(), (BelvedereMediaResolverCallback)this.belvedereMediaResolverCallbackProvider.get());
        return inputBoxConsumer2;
    }
}

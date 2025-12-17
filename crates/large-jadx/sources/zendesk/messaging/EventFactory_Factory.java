package zendesk.messaging;

import g.b.b;
import j.a.a;
import zendesk.messaging.components.DateProvider;

/* loaded from: classes3.dex */
public final class EventFactory_Factory implements b<zendesk.messaging.EventFactory> {

    private final a<DateProvider> dateProvider;
    public EventFactory_Factory(a<DateProvider> a) {
        super();
        this.dateProvider = a;
    }

    public static zendesk.messaging.EventFactory_Factory create(a<DateProvider> a) {
        EventFactory_Factory eventFactory_Factory = new EventFactory_Factory(a);
        return eventFactory_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.EventFactory get() {
        EventFactory eventFactory = new EventFactory((DateProvider)this.dateProvider.get());
        return eventFactory;
    }
}

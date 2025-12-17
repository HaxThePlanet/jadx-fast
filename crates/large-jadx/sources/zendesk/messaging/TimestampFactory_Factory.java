package zendesk.messaging;

import android.content.Context;
import g.b.b;
import j.a.a;

/* loaded from: classes3.dex */
public final class TimestampFactory_Factory implements b<zendesk.messaging.TimestampFactory> {

    private final a<Context> contextProvider;
    public TimestampFactory_Factory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.messaging.TimestampFactory_Factory create(a<Context> a) {
        TimestampFactory_Factory timestampFactory_Factory = new TimestampFactory_Factory(a);
        return timestampFactory_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.TimestampFactory get() {
        TimestampFactory timestampFactory = new TimestampFactory((Context)this.contextProvider.get());
        return timestampFactory;
    }
}

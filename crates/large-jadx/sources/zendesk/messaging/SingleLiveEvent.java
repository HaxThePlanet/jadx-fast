package zendesk.messaging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import f.g.c.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
class SingleLiveEvent<T>  extends x<T> {

    private final AtomicBoolean pending;
    SingleLiveEvent() {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.pending = atomicBoolean;
    }

    static AtomicBoolean access$000(zendesk.messaging.SingleLiveEvent singleLiveEvent) {
        return singleLiveEvent.pending;
    }

    public void observe(q q, y<? super T> y2) {
        boolean activeObservers;
        String str;
        String str2;
        if (hasActiveObservers()) {
            a.k("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.", new Object[0]);
        }
        SingleLiveEvent.1 anon = new SingleLiveEvent.1(this, y2);
        super.observe(q, anon);
    }

    public void setValue(T t) {
        this.pending.set(true);
        super.setValue(t);
    }
}

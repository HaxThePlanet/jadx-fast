package i.b.m0.h;

import i.b.k;
import i.b.m0.i.g;
import i.b.m0.j.c;
import i.b.m0.j.l;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public class f<T>  extends AtomicInteger implements k<T>, c {

    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final b<? super T> downstream;
    final c error;
    final AtomicBoolean once;
    final AtomicLong requested;
    final AtomicReference<c> upstream;
    public f(b<? super T> b) {
        super();
        this.downstream = b;
        c obj1 = new c();
        this.error = obj1;
        obj1 = new AtomicLong();
        this.requested = obj1;
        obj1 = new AtomicReference();
        this.upstream = obj1;
        obj1 = new AtomicBoolean();
        this.once = obj1;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void cancel() {
        boolean upstream;
        if (!this.done) {
            g.cancel(this.upstream);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void onComplete() {
        this.done = true;
        l.b(this.downstream, this, this.error);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void onError(Throwable throwable) {
        this.done = true;
        l.d(this.downstream, throwable, this, this.error);
    }

    public void onNext(T t) {
        l.f(this.downstream, t, this, this.error);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void onSubscribe(c c) {
        Object upstream;
        AtomicLong requested;
        Object obj4;
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            g.deferredSetOnce(this.upstream, this.requested, c);
        } else {
            c.cancel();
            cancel();
            obj4 = new IllegalStateException("§2.12 violated: onSubscribe must be called at most once");
            onError(obj4);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void request(long l) {
        Object illegalArgumentException;
        Object stringBuilder;
        String str;
        String obj4;
        if (Long.compare(l, i) <= 0) {
            cancel();
            stringBuilder = new StringBuilder();
            stringBuilder.append("§3.9 violated: positive request amount required but it was ");
            stringBuilder.append(l);
            illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            onError(illegalArgumentException);
        } else {
            g.deferredRequest(this.upstream, this.requested, l);
        }
    }
}

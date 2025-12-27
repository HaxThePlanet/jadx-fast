package i.b.m0.h;

import i.b.k;
import i.b.m0.i.g;
import i.b.m0.j.l;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m.c.b;

/* compiled from: StrictSubscriber.java */
/* loaded from: classes3.dex */
public class f<T> extends AtomicInteger implements k<T>, m.c.c {

    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final b<? super T> downstream;
    final i.b.m0.j.c error = new c();
    final AtomicBoolean once = new AtomicBoolean();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<m.c.c> upstream = new AtomicReference<>();
    public f(b<? super T> bVar) {
        super();
        this.downstream = bVar;
        i.b.m0.j.c cVar = new c();
        AtomicLong atomicLong = new AtomicLong();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void cancel() {
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
    public void onError(Throwable th) {
        this.done = true;
        l.d(this.downstream, th, this, this.error);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void onNext(T t) {
        l.f(this.downstream, t, this, this.error);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void onSubscribe(m.c.c cVar) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            g.deferredSetOnce(this.upstream, this.requested, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public void request(long j) {
        if (j <= 0) {
            cancel();
            StringBuilder stringBuilder = new StringBuilder();
            str = "§3.9 violated: positive request amount required but it was ";
            str2 = str + j;
            onError(new IllegalArgumentException(str2));
        } else {
            g.deferredRequest(this.upstream, this.requested, j);
        }
    }
}

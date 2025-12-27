package i.b.m0.e.e;

import i.b.j0.b;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableSkipLastTimed.java */
/* loaded from: classes3.dex */
public final class i3<T> extends a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final int w;
    final boolean x;

    static final class a<T> extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final y<? super T> downstream;
        Throwable error;
        final i.b.m0.f.c<Object> queue = new c<>();
        final z scheduler;
        final long time;
        final TimeUnit unit;
        b upstream;
        a(y<? super T> yVar, long j, TimeUnit timeUnit, z zVar, int i, boolean z) {
            super();
            this.downstream = yVar;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = zVar;
            final i.b.m0.f.c cVar = new c(i);
            this.delayError = z;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andGet;
            Object poll;
            Object obj;
            long l;
            long value;
            final Object obj2 = this;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (obj2.cancelled) {
                obj = obj2.queue.m();
                int r12 = obj == null ? andGet : 0;
                if (andGet != 0) {
                }
            }
            obj2.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            this.queue.l(Long.valueOf(this.scheduler.b(this.unit)), t);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public i3(w<T> wVar, long j, TimeUnit timeUnit, z zVar, int i, boolean z) {
        super(wVar);
        this.b = j;
        this.c = timeUnit;
        this.v = zVar;
        this.w = i;
        this.x = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        i3.a aVar = new i3.a(yVar, this.b, timeUnit, this.c, this.v, this.w, this.x);
        this.a.subscribe(aVar);
    }
}

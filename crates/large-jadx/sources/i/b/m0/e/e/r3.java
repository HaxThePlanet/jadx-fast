package i.b.m0.e.e;

import i.b.j0.b;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableTakeLastTimed.java */
/* loaded from: classes3.dex */
public final class r3<T> extends a<T, T> {

    final long b;
    final long c;
    final TimeUnit v;
    final z w;
    final int x;
    final boolean y;

    static final class a<T> extends AtomicBoolean implements y<T>, b {

        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final y<? super T> downstream;
        Throwable error;
        final i.b.m0.f.c<Object> queue = new c<>();
        final z scheduler;
        final long time;
        final TimeUnit unit;
        b upstream;
        a(y<? super T> yVar, long j, long j2, TimeUnit timeUnit, z zVar, int i, boolean z) {
            super();
            this.downstream = yVar;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = zVar;
            final i.b.m0.f.c cVar = new c(i);
            this.delayError = z;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        void a() {
            boolean z;
            z = false;
            z = true;
            if (!compareAndSet(z, z)) {
                return;
            }
            long l2 = this.scheduler.b(this.unit) - this.time;
            while (this.cancelled) {
                Object poll2 = this.queue.poll();
                boolean r8 = z;
                if (z) {
                }
            }
            this.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            if (!this.cancelled) {
                boolean z2 = true;
                this.cancelled = z2;
                this.upstream.dispose();
                boolean z = false;
                if (compareAndSet(z, z2)) {
                    this.queue.clear();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onComplete() {
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onError(Throwable th) {
            this.error = th;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onNext(T t) {
            int i = 0;
            Long num;
            long l;
            int cmp;
            long l2 = this.scheduler.b(this.unit);
            i = 1;
            int r7 = this.count == 9223372036854775807L ? i : 0;
            this.queue.l(Long.valueOf(l2, this.unit), t);
            while (!this.queue.isEmpty()) {
                long value = (Long)this.queue.m().longValue();
                l = l2 - this.time;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public r3(w<T> wVar, long j, long j2, TimeUnit timeUnit, z zVar, int i, boolean z) {
        super(wVar);
        this.b = j;
        this.c = j2;
        this.v = timeUnit;
        this.w = zVar;
        this.x = i;
        this.y = z;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        r3.a aVar = new r3.a(yVar, this.b, l2, this.c, zVar, this.v, this.w, this.x, this.y);
        this.a.subscribe(aVar);
    }
}

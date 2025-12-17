package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.f.c;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class r3<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;
    final long c;
    final TimeUnit v;
    final z w;
    final int x;
    final boolean y;

    static final class a extends AtomicBoolean implements y<T>, b {

        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final y<? super T> downstream;
        Throwable error;
        final c<Object> queue;
        final z scheduler;
        final long time;
        final TimeUnit unit;
        b upstream;
        a(y<? super T> y, long l2, long l3, TimeUnit timeUnit4, z z5, int i6, boolean z7) {
            super();
            this.downstream = y;
            this.count = l2;
            this.time = timeUnit4;
            this.unit = i6;
            this.scheduler = z7;
            c obj1 = new c(obj8);
            this.queue = obj1;
            this.delayError = obj9;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        void a() {
            long time;
            boolean cancelled;
            Object poll;
            int i;
            long longValue;
            int i2 = 0;
            final int i3 = 1;
            if (!compareAndSet(i2, i3)) {
            }
            y downstream = this.downstream;
            final c queue = this.queue;
            while (this.cancelled) {
                Object poll2 = queue.poll();
                if (poll2 == null) {
                } else {
                }
                i = i2;
                if (Long.compare(longValue, i4) < 0) {
                } else {
                }
                downstream.onNext(queue.poll());
                i = i3;
                cancelled = this.error;
            }
            queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            boolean compareAndSet;
            int i;
            int i2 = 1;
            this.cancelled = i2;
            this.upstream.dispose();
            if (!this.cancelled && compareAndSet(false, i2)) {
                i2 = 1;
                this.cancelled = i2;
                this.upstream.dispose();
                if (compareAndSet(false, i2)) {
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
        public void onError(Throwable throwable) {
            this.error = throwable;
            a();
        }

        public void onNext(T t) {
            int i2;
            Long longValue;
            int i;
            Object obj14;
            final c queue = this.queue;
            final TimeUnit unit = this.unit;
            long l = this.scheduler.b(unit);
            final long count = this.count;
            final int i3 = 1;
            i2 = Long.compare(count, l2) == 0 ? i3 : 0;
            queue.l(Long.valueOf(l), t);
            while (!queue.isEmpty()) {
                if (Long.compare(longValue, i) > 0) {
                } else {
                }
                queue.poll();
                queue.poll();
                if (i2 == 0) {
                }
                if (Long.compare(longValue, count) > 0) {
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public r3(w<T> w, long l2, long l3, TimeUnit timeUnit4, z z5, int i6, boolean z7) {
        super(w);
        this.b = l2;
        this.c = timeUnit4;
        this.v = i6;
        this.w = z7;
        this.x = obj8;
        this.y = obj9;
    }

    public void subscribeActual(y<? super T> y) {
        super(y, this.b, obj4, this.c, obj6, this.v, this.w, this.x, this.y);
        this.a.subscribe(aVar2);
    }
}

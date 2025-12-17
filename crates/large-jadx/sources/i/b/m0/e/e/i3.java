package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.f.c;
import i.b.w;
import i.b.y;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class i3<T>  extends i.b.m0.e.e.a<T, T> {

    final long b;
    final TimeUnit c;
    final z v;
    final int w;
    final boolean x;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final y<? super T> downstream;
        Throwable error;
        final c<Object> queue;
        final z scheduler;
        final long time;
        final TimeUnit unit;
        b upstream;
        a(y<? super T> y, long l2, TimeUnit timeUnit3, z z4, int i5, boolean z6) {
            super();
            this.downstream = y;
            this.time = l2;
            this.unit = z4;
            this.scheduler = i5;
            c obj1 = new c(z6);
            this.queue = obj1;
            this.delayError = obj7;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andGet;
            Object error;
            Object cmp;
            int i;
            long l;
            long longValue;
            final Object obj = this;
            if (getAndIncrement() != 0) {
            }
            y downstream = obj.downstream;
            c queue2 = obj.queue;
            final int i2 = 1;
            andGet = i2;
            while (obj.cancelled) {
                cmp = queue2.m();
                if ((Long)cmp == null) {
                } else {
                }
                i = 0;
                if (i == 0 && Long.compare(longValue, l) > 0) {
                }
                queue2.poll();
                downstream.onNext(queue2.poll());
                error = obj.error;
                if (Long.compare(longValue, l) > 0) {
                }
                i = i2;
                i = i2;
            }
            obj.queue.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean andIncrement;
            this.cancelled = true;
            this.upstream.dispose();
            if (!this.cancelled && getAndIncrement() == 0) {
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
        public void onError(Throwable throwable) {
            this.error = throwable;
            this.done = true;
            a();
        }

        public void onNext(T t) {
            final TimeUnit unit = this.unit;
            this.queue.l(Long.valueOf(this.scheduler.b(unit)), t);
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }
    }
    public i3(w<T> w, long l2, TimeUnit timeUnit3, z z4, int i5, boolean z6) {
        super(w);
        this.b = l2;
        this.c = z4;
        this.v = i5;
        this.w = z6;
        this.x = obj7;
    }

    public void subscribeActual(y<? super T> y) {
        super(y, this.b, obj4, this.c, this.v, this.w, this.x);
        this.a.subscribe(aVar2);
    }
}

package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.r;
import i.b.t0.e;
import i.b.w;
import i.b.y;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class f4<T>  extends i.b.m0.e.e.a<T, r<T>> {

    final long b;
    final long c;
    final int v;

    static final class a extends AtomicInteger implements y<T>, b, Runnable {

        private static final long serialVersionUID = -7481782523886138128L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final y<? super r<T>> downstream;
        long size;
        b upstream;
        e<T> window;
        a(y<? super r<T>> y, long l2, int i3) {
            super();
            this.downstream = y;
            this.count = l2;
            this.capacityHint = obj4;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            this.cancelled = true;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            int i;
            e window = this.window;
            if (window != null) {
                this.window = 0;
                window.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            int i;
            e window = this.window;
            if (window != null) {
                this.window = 0;
                window.onError(throwable);
            }
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            e window;
            boolean downstream;
            long count;
            Object obj6;
            if (this.window == null && !this.cancelled) {
                if (!this.cancelled) {
                    window = e.f(this.capacityHint, this);
                    this.window = window;
                    this.downstream.onNext(window);
                }
            }
            window.onNext(t);
            size += i;
            this.size = downstream;
            this.size = 0;
            this.window = 0;
            window.onComplete();
            if (window != null && Long.compare(downstream, count) >= 0 && this.cancelled) {
                window.onNext(t);
                size += i;
                this.size = downstream;
                if (Long.compare(downstream, count) >= 0) {
                    this.size = 0;
                    this.window = 0;
                    window.onComplete();
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            boolean cancelled;
            if (this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    static final class b extends AtomicBoolean implements y<T>, b, Runnable {

        private static final long serialVersionUID = 3366976432059579510L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final y<? super r<T>> downstream;
        long firstEmission;
        long index;
        final long skip;
        b upstream;
        final ArrayDeque<e<T>> windows;
        final AtomicInteger wip;
        b(y<? super r<T>> y, long l2, long l3, int i4) {
            super();
            AtomicInteger atomicInteger = new AtomicInteger();
            this.wip = atomicInteger;
            this.downstream = y;
            this.count = l2;
            this.skip = i4;
            this.capacityHint = obj7;
            ArrayDeque obj2 = new ArrayDeque();
            this.windows = obj2;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void dispose() {
            this.cancelled = true;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onComplete() {
            Object poll;
            ArrayDeque windows = this.windows;
            while (!windows.isEmpty()) {
                (e)windows.poll().onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onError(Throwable throwable) {
            Object poll;
            ArrayDeque windows = this.windows;
            while (!windows.isEmpty()) {
                (e)windows.poll().onError(throwable);
            }
            this.downstream.onError(throwable);
        }

        public void onNext(T t) {
            int cancelled;
            int i;
            y downstream;
            Object next;
            boolean obj12;
            final ArrayDeque windows = this.windows;
            long index = this.index;
            final long skip = this.skip;
            if (Long.compare(i3, i4) == 0 && !this.cancelled) {
                if (!this.cancelled) {
                    this.wip.getAndIncrement();
                    cancelled = e.f(this.capacityHint, this);
                    windows.offer(cancelled);
                    this.downstream.onNext(cancelled);
                }
            }
            int i5 = 1;
            firstEmission += i5;
            Iterator iterator = windows.iterator();
            for (e next : iterator) {
                next.onNext(t);
            }
            if (Long.compare(i, count) >= 0) {
                (e)windows.poll().onComplete();
                if (windows.isEmpty() && this.cancelled) {
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
                }
                this.firstEmission = i -= skip;
            } else {
                this.firstEmission = i;
            }
            this.index = index += i5;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b b) {
            Object obj2;
            if (c.validate(this.upstream, b)) {
                this.upstream = b;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void run() {
            int decrementAndGet;
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                if (this.cancelled) {
                    this.upstream.dispose();
                }
            }
        }
    }
    public f4(w<T> w, long l2, long l3, int i4) {
        super(w);
        this.b = l2;
        this.c = i4;
        this.v = obj6;
    }

    public void subscribeActual(y<? super r<T>> y) {
        w wVar;
        Object aVar;
        long l;
        int i3;
        int i;
        long l2;
        int i2;
        i.b.m0.e.e.f4.b bVar;
        if (Long.compare(l3, l4) == 0) {
            aVar = new f4.a(y, this.b, obj3, this.v);
            this.a.subscribe(aVar);
        } else {
            super(y, this.b, obj4, this.c, obj6, this.v);
            this.a.subscribe(bVar);
        }
    }
}

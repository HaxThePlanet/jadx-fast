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

/* compiled from: ObservableWindow.java */
/* loaded from: classes3.dex */
public final class f4<T> extends a<T, r<T>> {

    final long b;
    final long c;
    final int v;

    static final class a<T> extends AtomicInteger implements y<T>, b, Runnable {

        private static final long serialVersionUID = -7481782523886138128L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final y<? super r<T>> downstream;
        long size;
        b upstream;
        e<T> window;
        a(y<? super r<T>> yVar, long j, int i) {
            super();
            this.downstream = yVar;
            this.count = j;
            this.capacityHint = i;
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
            if (this.window != null) {
                e eVar = null;
                this.window = eVar;
                this.window.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable th) {
            if (this.window != null) {
                e eVar = null;
                this.window = eVar;
                this.window.onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onNext(T t) {
            e window2;
            boolean cancelled2;
            if (this.window == null && !this.cancelled) {
                window2 = e.f(this.capacityHint, this);
                this.window = window2;
                this.downstream.onNext(window2);
            }
            if (this.capacityHint != null) {
                window2.onNext(t);
                this.size++;
                if (this.cancelled >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    window2.onComplete();
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void run() {
            if (this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    static final class b<T> extends AtomicBoolean implements y<T>, b, Runnable {

        private static final long serialVersionUID = 3366976432059579510L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final y<? super r<T>> downstream;
        long firstEmission;
        long index;
        final long skip;
        b upstream;
        final ArrayDeque<e<T>> windows = new ArrayDeque<>();
        final AtomicInteger wip = new AtomicInteger();
        b(y<? super r<T>> yVar, long j, long j2, int i) {
            super();
            final AtomicInteger atomicInteger = new AtomicInteger();
            this.downstream = yVar;
            this.count = j;
            this.skip = j2;
            this.capacityHint = i;
            final ArrayDeque arrayDeque = new ArrayDeque();
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
            while (!this.windows.isEmpty()) {
                (e)this.windows.poll().onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onError(Throwable th) {
            while (!this.windows.isEmpty()) {
                (e)this.windows.poll().onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onNext(T t) {
            boolean empty;
            long l3 = index2 % skip2;
            if (this.cancelled == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                e eVar = e.f(this.capacityHint, this);
                this.windows.offer(eVar);
                this.downstream.onNext(eVar);
            }
            long l4 = 1L;
            Iterator it = this.windows.iterator();
            while (it.hasNext()) {
                (e)it.next().onNext(t);
            }
            if (this.cancelled >= this.count) {
                (e)this.windows.poll().onComplete();
                if (this.windows.isEmpty() && this.cancelled) {
                    this.upstream.dispose();
                    return;
                }
                l = l - skip2;
                this.firstEmission = l;
            } else {
                this.firstEmission += l4;
            }
            this.index += l4;
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void onSubscribe(b bVar) {
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.upstream.dispose();
            }
        }
    }
    public f4(w<T> wVar, long j, long j2, int i) {
        super(wVar);
        this.b = j;
        this.c = j2;
        this.v = i;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super r<T>> yVar) {
        if (this.b == this.c) {
            this.a.subscribe(new f4.a(yVar, this.b, r3, this.v));
        } else {
            f4.b bVar = new f4.b(yVar, this.b, l6, this.c, obj, this.v);
            this.a.subscribe(bVar);
        }
    }
}

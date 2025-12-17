package i.b.m0.e.d;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.m0.j.j;
import i.b.p;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class d<T, R>  extends r<R> {

    final r<T> a;
    final n<? super T, ? extends p<? extends R>> b;
    final j c;
    final int v;

    static final class a extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final y<? super R> downstream;
        final j errorMode;
        final c errors;
        final i.b.m0.e.d.d.a.a<R> inner;
        R item;
        final n<? super T, ? extends p<? extends R>> mapper;
        final i<T> queue;
        volatile int state;
        b upstream;
        a(y<? super R> y, n<? super T, ? extends p<? extends R>> n2, int i3, j j4) {
            super();
            this.downstream = y;
            this.mapper = n2;
            this.errorMode = j4;
            c obj1 = new c();
            this.errors = obj1;
            obj1 = new d.a.a(this);
            this.inner = obj1;
            obj1 = new c(i3);
            this.queue = obj1;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int andGet;
            boolean cancelled;
            int inner;
            int i;
            j iMMEDIATE;
            int i2;
            if (getAndIncrement() != 0) {
            }
            y downstream = this.downstream;
            j errorMode = this.errorMode;
            final i queue = this.queue;
            final c errors = this.errors;
            final int i3 = 1;
            andGet = i3;
            inner = 0;
            while (this.cancelled) {
                queue.clear();
                this.item = inner;
                inner = 0;
                cancelled = this.state;
                this.item = inner;
                downstream.onNext(this.item);
                this.state = 0;
                inner = queue.poll();
                if (inner == null) {
                }
                if (i != 0) {
                } else {
                }
                cancelled = this.mapper.apply(inner);
                b.e(cancelled, "The mapper returned a null MaybeSource");
                this.state = i3;
                (p)cancelled.b(this.inner);
                i = i3;
            }
            queue.clear();
            this.item = inner;
            downstream.onError(errors.b());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            this.state = 0;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(Throwable throwable) {
            j eND;
            Object obj2;
            if (this.errors.a(throwable)) {
                if (this.errorMode != j.END) {
                    this.upstream.dispose();
                }
                this.state = 0;
                a();
            } else {
                a.t(throwable);
            }
        }

        void d(R r) {
            this.item = r;
            this.state = 2;
            a();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            int andIncrement;
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.a();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = 0;
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
            j iMMEDIATE;
            Object obj2;
            if (this.errors.a(throwable)) {
                if (this.errorMode == j.IMMEDIATE) {
                    this.inner.a();
                }
                this.done = true;
                a();
            } else {
                a.t(throwable);
            }
        }

        public void onNext(T t) {
            this.queue.offer(t);
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
    public d(r<T> r, n<? super T, ? extends p<? extends R>> n2, j j3, int i4) {
        super();
        this.a = r;
        this.b = n2;
        this.c = j3;
        this.v = i4;
    }

    protected void subscribeActual(y<? super R> y) {
        boolean z;
        Object aVar;
        n nVar;
        int i;
        j jVar;
        if (!i.b(this.a, this.b, y)) {
            aVar = new d.a(y, this.b, this.v, this.c);
            this.a.subscribe(aVar);
        }
    }
}

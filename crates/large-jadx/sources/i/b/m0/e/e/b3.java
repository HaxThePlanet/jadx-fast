package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.d;
import i.b.m0.a.a;
import i.b.m0.f.c;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class b3<T>  extends r<Boolean> {

    final w<? extends T> a;
    final w<? extends T> b;
    final d<? super T, ? super T> c;
    final int v;

    static final class a extends AtomicInteger implements b {

        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final d<? super T, ? super T> comparer;
        final y<? super Boolean> downstream;
        final w<? extends T> first;
        final i.b.m0.e.e.b3.b<T>[] observers;
        final a resources;
        final w<? extends T> second;
        T v1;
        T v2;
        a(y<? super Boolean> y, int i2, w<? extends T> w3, w<? extends T> w4, d<? super T, ? super T> d5) {
            super();
            this.downstream = y;
            this.first = w3;
            this.second = w4;
            this.comparer = d5;
            final int obj1 = 2;
            final i.b.m0.e.e.b3.b[] obj3 = new b3.b[obj1];
            this.observers = obj3;
            int obj5 = 0;
            b3.b obj4 = new b3.b(this, obj5, i2);
            obj3[obj5] = obj4;
            obj5 = 1;
            obj4 = new b3.b(this, obj5, i2);
            obj3[obj5] = obj4;
            a obj2 = new a(obj1);
            this.resources = obj2;
        }

        void a(c<T> c, c<T> c2) {
            this.cancelled = true;
            c.clear();
            c2.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            boolean z2;
            boolean z;
            int i2;
            Object poll2;
            Object obj;
            Object poll;
            int i;
            if (getAndIncrement() != 0) {
            }
            i.b.m0.e.e.b3.b[] observers = this.observers;
            int i3 = 0;
            final i.b.m0.e.e.b3.b bVar2 = observers[i3];
            final c cVar = bVar2.b;
            final int i4 = 1;
            i.b.m0.e.e.b3.b bVar = observers[i4];
            final c cVar2 = bVar.b;
            andGet = i4;
            while (this.cancelled) {
                z2 = bVar2.v;
                z = bVar.v;
                if (this.v1 == null) {
                }
                if (this.v1 == null) {
                } else {
                }
                i2 = i3;
                if (this.v2 == null) {
                }
                obj = this.v2;
                if (obj == null) {
                } else {
                }
                i = i3;
                z2 = 0;
                this.v1 = z2;
                this.v2 = z2;
                i = i4;
                this.v2 = cVar2.poll();
                i2 = i4;
                this.v1 = cVar.poll();
                i2 = bVar.w;
                z = bVar2.w;
            }
            cVar.clear();
            cVar2.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean c(b b, int i2) {
            return this.resources.a(i2, b);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            i.b.m0.e.e.b3.b[] observers = this.observers;
            this.first.subscribe(observers[0]);
            this.second.subscribe(observers[1]);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean cancelled;
            int andIncrement;
            c cVar;
            cancelled = 1;
            this.cancelled = cancelled;
            this.resources.dispose();
            if (!this.cancelled && getAndIncrement() == 0) {
                cancelled = 1;
                this.cancelled = cancelled;
                this.resources.dispose();
                if (getAndIncrement() == 0) {
                    andIncrement = this.observers;
                    bVar2.b.clear();
                    bVar.b.clear();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class b implements y<T> {

        final i.b.m0.e.e.b3.a<T> a;
        final c<T> b;
        final int c;
        volatile boolean v;
        Throwable w;
        b(i.b.m0.e.e.b3.a<T> b3$a, int i2, int i3) {
            super();
            this.a = a;
            this.c = i2;
            c obj1 = new c(i3);
            this.b = obj1;
        }

        @Override // i.b.y
        public void onComplete() {
            this.v = true;
            this.a.b();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.w = throwable;
            this.v = true;
            this.a.b();
        }

        public void onNext(T t) {
            this.b.offer(t);
            this.a.b();
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.a.c(b, this.c);
        }
    }
    public b3(w<? extends T> w, w<? extends T> w2, d<? super T, ? super T> d3, int i4) {
        super();
        this.a = w;
        this.b = w2;
        this.c = d3;
        this.v = i4;
    }

    public void subscribeActual(y<? super Boolean> y) {
        super(y, this.v, this.a, this.b, this.c);
        y.onSubscribe(aVar2);
        aVar2.d();
    }
}

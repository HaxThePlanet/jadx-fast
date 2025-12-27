package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.d;
import i.b.m0.f.c;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableSequenceEqual.java */
/* loaded from: classes3.dex */
public final class b3<T> extends r<Boolean> {

    final w<? extends T> a;
    final w<? extends T> b;
    final d<? super T, ? super T> c;
    final int v;

    static final class a<T> extends AtomicInteger implements b {

        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final d<? super T, ? super T> comparer;
        final y<? super Boolean> downstream;
        final w<? extends T> first;
        final b3.b<T>[] observers;
        final i.b.m0.a.a resources = new a(2);
        final w<? extends T> second;
        T v1;
        T v2;
        a(y<? super Boolean> yVar, int i, w<? extends T> wVar, w<? extends T> wVar2, d<? super T, ? super T> dVar) {
            super();
            this.downstream = yVar;
            this.first = wVar;
            this.second = wVar2;
            this.comparer = dVar;
            i = 2;
            final i.b.m0.e.e.b3.b[] arr = new b3.b[i];
            this.observers = arr;
            int i3 = 0;
            arr[i3] = new b3.b(this, i3, i);
            int i4 = 1;
            arr[i4] = new b3.b(this, i4, i);
            final i.b.m0.a.a aVar = new a(i);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a(c<T> cVar, c<T> cVar2) {
            this.cancelled = true;
            cVar.clear();
            cVar2.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int andGet;
            boolean z = false;
            boolean z2;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 0;
            final i.b.m0.e.e.b3.b bVar2 = observers2[andGet];
            andGet = 1;
            i.b.m0.e.e.b3.b bVar = observers2[andGet];
            while (this.cancelled) {
                int r9 = andGet;
                int r11 = andGet;
                try {
                } catch (Throwable th) {
                    a.b(th);
                    a(cVar, cVar3);
                    this.downstream.onError(th);
                    return;
                }
                Object obj2 = null;
                this.v1 = obj2;
                this.v2 = obj2;
                if (this.v1 != 0 || andGet != 0) {
                }
            }
            bVar2.b.clear();
            bVar.b.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        boolean c(b bVar, int i) {
            return this.resources.a(i, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            this.first.subscribe(observers2[0]);
            this.second.subscribe(observers2[1]);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (!this.cancelled) {
                boolean cancelled2 = true;
                this.cancelled = cancelled2;
                this.resources.dispose();
                if (getAndIncrement() == 0) {
                    observers2[0].b.clear();
                    observers2[cancelled2].b.clear();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class b<T> implements y<T> {

        final b3.a<T> a;
        final c<T> b = new c<>();
        final int c;
        volatile boolean v;
        Throwable w;
        b(b3.a<T> aVar, int i, int i2) {
            super();
            this.a = aVar;
            this.c = i;
            final c cVar = new c(i2);
        }

        public void onComplete() {
            this.v = true;
            this.a.b();
        }

        public void onError(Throwable th) {
            this.w = th;
            this.v = true;
            this.a.b();
        }

        public void onNext(T t) {
            this.b.offer(t);
            this.a.b();
        }

        public void onSubscribe(b bVar) {
            this.a.c(bVar, this.c);
        }
    }
    public b3(w<? extends T> wVar, w<? extends T> wVar2, d<? super T, ? super T> dVar, int i) {
        super();
        this.a = wVar;
        this.b = wVar2;
        this.c = dVar;
        this.v = i;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super Boolean> yVar) {
        b3.a aVar = new b3.a(yVar, this.v, this.a, this.b, this.c);
        yVar.onSubscribe(aVar);
        aVar.d();
    }
}

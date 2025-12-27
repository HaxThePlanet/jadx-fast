package i.b.m0.e.e;

import i.b.l0.n;
import i.b.m0.a.d;
import i.b.r;
import i.b.w;
import i.b.y;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCombineLatest.java */
/* loaded from: classes3.dex */
public final class t<T, R> extends r<R> {

    final w<? extends T>[] a;
    final Iterable<? extends w<? extends T>> b;
    final n<? super Object[], ? extends R> c;
    final int v;
    final boolean w;

    static final class a<T, R> extends AtomicReference<i.b.j0.b> implements y<T> {

        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final t.b<T, R> parent;
        a(t.b<T, R> bVar, int i) {
            super();
            this.parent = bVar;
            this.index = i;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.parent.d(this.index);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            this.parent.e(this.index, th);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(T t) {
            this.parent.f(this.index, t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.setOnce(this, bVar);
        }
    }

    static final class b<T, R> extends AtomicInteger implements i.b.j0.b {

        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final n<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final y<? super R> downstream;
        final i.b.m0.j.c errors = new c();
        Object[] latest;
        final t.a<T, R>[] observers;
        final i.b.m0.f.c<Object[]> queue = new c<>();
        b(y<? super R> yVar, n<? super Object[], ? extends R> nVar, int i, int i2, boolean z) {
            super();
            final i.b.m0.j.c cVar = new c();
            this.downstream = yVar;
            this.combiner = nVar;
            this.delayError = z;
            this.latest = new Object[i];
            i.b.m0.e.e.t.a[] arr2 = new t.a[i];
            i = 0;
            while (i < i) {
                arr2[i] = new t.a(this, i);
                i = i + 1;
            }
            this.observers = arr2;
            i.b.m0.f.c cVar2 = new c(i2);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int i = 0;
            i = 0;
            for (i.b.m0.e.e.t.a aVar : observers2) {
                aVar.a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(i.b.m0.f.c<?> cVar) {
            synchronized (this) {
                try {
                    this.latest = null;
                } catch (Throwable th) {
                }
            }
            th.clear();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c() {
            int andGet;
            if (getAndIncrement() != 0) {
                return;
            }
            andGet = 1;
            while (this.cancelled) {
                String poll = this.queue.poll();
                int r7 = poll == null ? andGet : 0;
                if (andGet != 0) {
                }
            }
            b(this.queue);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(int i) {
            Object[] latest2;
            int i3;
            int i2 = 0;
            synchronized (this) {
                try {
                    if (this.latest == null) {
                        return;
                    }
                    i2 = 0;
                    if (i2 == 0) {
                        this.complete += i2;
                        length = latest2.length;
                        if (this.complete == latest2.length) {
                            this.done = true;
                        }
                    }
                } catch (Throwable th) {
                }
            }
            if (i2 != 0) {
                a();
            }
            c();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                a();
                if (getAndIncrement() == 0) {
                    b(this.queue);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e(int i, Throwable th) {
            int i2 = 1;
            int i3;
            boolean delayError2;
            int length;
            Object[] latest2;
            if (this.errors.a(th)) {
                i2 = 1;
                if (this.delayError != null) {
                    synchronized (this) {
                        try {
                            if (this.latest == null) {
                                return;
                            }
                            i = latest2[i] == null ? i2 : 0;
                            if (i2 == 0) {
                                this.complete += i2;
                                length = latest2.length;
                                if (this.complete == latest2.length) {
                                    this.done = true;
                                }
                            }
                        } catch (Throwable th) {
                        }
                    }
                }
                if (this.errors != 0) {
                    a();
                }
                c();
            } else {
                a.t(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void f(int i, T t) {
            int active2;
            int i2 = 0;
            synchronized (this) {
                try {
                    if (this.latest == null) {
                        return;
                    }
                    if (latest2[i] == null) {
                        this.active++;
                    }
                    this.latest[i] = t;
                    if (this.active == latest2.length) {
                        this.queue.offer(this.latest.clone());
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } catch (Throwable th) {
                }
            }
            if (latest2.length != 0) {
                c();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void g(w<? extends T>[] wVarArr) {
            int i = 0;
            Object obj;
            this.downstream.onSubscribe(this);
            i = 0;
            while (this.downstream < observers2.length) {
                if (this.cancelled) {
                    break;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }
    public t(w<? extends T>[] wVarArr, Iterable<? extends w<? extends T>> iterable, n<? super Object[], ? extends R> nVar, int i, boolean z) {
        super();
        this.a = wVarArr;
        this.b = iterable;
        this.c = nVar;
        this.v = i;
        this.w = z;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super R> yVar) {
        w[] arr;
        int length;
        if (this.a == null) {
            arr = new w[8];
            Iterator it = this.b.iterator();
            length = 0;
            while (it.hasNext()) {
                length2 = arr.length;
                length = length + 1;
                arr[length] = (w)it.next();
            }
        } else {
            length = arr.length;
        }
        if (length == 0) {
            d.complete(yVar);
            return;
        }
        t.b bVar = new t.b(yVar, this.c, length, this.v, this.w);
        bVar.g(arr);
    }
}

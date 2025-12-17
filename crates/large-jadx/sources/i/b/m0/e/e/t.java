package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.f.c;
import i.b.m0.j.c;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class t<T, R>  extends r<R> {

    final w<? extends T>[] a;
    final Iterable<? extends w<? extends T>> b;
    final n<? super Object[], ? extends R> c;
    final int v;
    final boolean w;

    static final class a extends AtomicReference<b> implements y<T> {

        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final i.b.m0.e.e.t.b<T, R> parent;
        a(i.b.m0.e.e.t.b<T, R> t$b, int i2) {
            super();
            this.parent = b;
            this.index = i2;
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
        public void onError(Throwable throwable) {
            this.parent.e(this.index, throwable);
        }

        public void onNext(T t) {
            this.parent.f(this.index, t);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }
    }

    static final class b extends AtomicInteger implements b {

        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final n<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final y<? super R> downstream;
        final c errors;
        Object[] latest;
        final i.b.m0.e.e.t.a<T, R>[] observers;
        final c<Object[]> queue;
        b(y<? super R> y, n<? super Object[], ? extends R> n2, int i3, int i4, boolean z5) {
            int obj3;
            boolean obj6;
            super();
            c cVar = new c();
            this.errors = cVar;
            this.downstream = y;
            this.combiner = n2;
            this.delayError = z5;
            this.latest = new Object[i3];
            i.b.m0.e.e.t.a[] obj2 = new t.a[i3];
            obj3 = 0;
            while (obj3 < i3) {
                obj6 = new t.a(this, obj3);
                obj2[obj3] = obj6;
                obj3++;
            }
            this.observers = obj2;
            obj2 = new c(i4);
            this.queue = obj2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            int i;
            i.b.m0.e.e.t.a aVar;
            final i.b.m0.e.e.t.a[] observers = this.observers;
            i = 0;
            while (i < observers.length) {
                observers[i].a();
                i++;
            }
        }

        void b(c<?> c) {
            this.latest = 0;
            c.clear();
            return;
            synchronized (this) {
                this.latest = 0;
                c.clear();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c() {
            int andGet;
            Object apply;
            boolean cancelled;
            Object poll;
            int i;
            if (getAndIncrement() != 0) {
            }
            c queue = this.queue;
            final y downstream = this.downstream;
            final int i2 = 1;
            andGet = i2;
            while (this.cancelled) {
                poll = queue.poll();
                if ((Object[])poll == null) {
                } else {
                }
                i = 0;
                apply = this.combiner.apply((Object[])poll);
                b.e(apply, "The combiner returned a null value");
                downstream.onNext(apply);
                i = i2;
            }
            b(queue);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(int i) {
            Object[] latest;
            int i2;
            int obj4;
            latest = this.latest;
            synchronized (this) {
                try {
                    final int i3 = 1;
                    if (latest[i] == null) {
                    } else {
                    }
                    obj4 = i3;
                    obj4 = 0;
                    if (obj4 == null) {
                    } else {
                    }
                    complete += i3;
                    this.complete = i2;
                    if (i2 == latest.length) {
                    }
                    this.done = i3;
                    if (obj4 != null) {
                    }
                    a();
                    c();
                    throw i;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean andIncrement;
            this.cancelled = true;
            a();
            if (!this.cancelled && getAndIncrement() == 0) {
                this.cancelled = true;
                a();
                if (getAndIncrement() == 0) {
                    b(this.queue);
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void e(int i, Throwable throwable2) {
            int z;
            int i2;
            int obj3;
            boolean obj4;
            if (this.errors.a(throwable2)) {
                z = 1;
                obj4 = this.latest;
                if (this.delayError != null && obj4 == null) {
                    obj4 = this.latest;
                    synchronized (this) {
                    }
                }
                if (z != 0) {
                    a();
                }
                try {
                    c();
                    a.t(throwable2);
                }
            } else {
            }
        }

        void f(int i, T t2) {
            int active;
            int obj4;
            Object obj5;
            final Object[] latest = this.latest;
            synchronized (this) {
                try {
                    if (latest[i] == null) {
                    }
                    this.active = active++;
                    latest[i] = t2;
                    if (active == latest.length) {
                    } else {
                    }
                    this.queue.offer(latest.clone());
                    obj4 = 1;
                    obj4 = 0;
                    if (obj4 != null) {
                    }
                    c();
                    throw i;
                }
            }
        }

        public void g(w<? extends T>[] wArr) {
            int i;
            Object cancelled;
            i.b.m0.e.e.t.a aVar;
            final i.b.m0.e.e.t.a[] observers = this.observers;
            this.downstream.onSubscribe(this);
            i = 0;
            while (i < observers.length) {
                if (!this.done) {
                    break;
                }
                if (this.cancelled) {
                    break;
                } else {
                }
                wArr[i].subscribe(observers[i]);
                i++;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }
    public t(w<? extends T>[] wArr, Iterable<? extends w<? extends T>> iterable2, n<? super Object[], ? extends R> n3, int i4, boolean z5) {
        super();
        this.a = wArr;
        this.b = iterable2;
        this.c = n3;
        this.v = i4;
        this.w = z5;
    }

    public void subscribeActual(y<? super R> y) {
        w[] arr;
        Iterator iterator;
        int i;
        int length2;
        boolean next;
        int i2;
        int length;
        arr = this.a;
        if (arr == null) {
            arr = new w[8];
            iterator = this.b.iterator();
            i = 0;
            length2 = i;
            while (iterator.hasNext()) {
                if (length2 == arr.length) {
                }
                arr[length2] = (w)iterator.next();
                length2 = i2;
                length = new w[i6 += length2];
                System.arraycopy(arr, i, length, i, length2);
                arr = length;
            }
        } else {
            length2 = arr.length;
        }
        int i4 = length2;
        if (i4 == 0) {
            d.complete(y);
        }
        super(y, this.c, i4, this.v, this.w);
        bVar2.g(arr);
    }
}

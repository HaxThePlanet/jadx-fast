package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.j.c;
import i.b.m0.j.l;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class l4<T, R>  extends i.b.m0.e.e.a<T, R> {

    final w<?>[] b;
    final Iterable<? extends w<?>> c;
    final n<? super Object[], R> v;

    final class a implements n<T, R> {

        final i.b.m0.e.e.l4 a;
        a(i.b.m0.e.e.l4 l4) {
            this.a = l4;
            super();
        }

        public R apply(T t) {
            Object[] arr = new Object[1];
            final Object obj4 = l4Var.v.apply(arr);
            b.e(obj4, "The combiner returned a null value");
            return obj4;
        }
    }

    static final class b extends AtomicInteger implements y<T>, b {

        private static final long serialVersionUID = 1577321883966341961L;
        final n<? super Object[], R> combiner;
        volatile boolean done;
        final y<? super R> downstream;
        final c error;
        final i.b.m0.e.e.l4.c[] observers;
        final AtomicReference<b> upstream;
        final AtomicReferenceArray<Object> values;
        b(y<? super R> y, n<? super Object[], R> n2, int i3) {
            i.b.m0.e.e.l4.c cVar;
            int obj3;
            super();
            this.downstream = y;
            this.combiner = n2;
            i.b.m0.e.e.l4.c[] obj2 = new l4.c[i3];
            obj3 = 0;
            while (obj3 < i3) {
                cVar = new l4.c(this, obj3);
                obj2[obj3] = cVar;
                obj3++;
            }
            this.observers = obj2;
            obj2 = new AtomicReferenceArray(i3);
            this.values = obj2;
            obj2 = new AtomicReference();
            this.upstream = obj2;
            obj2 = new c();
            this.error = obj2;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a(int i) {
            int i2;
            int length;
            final i.b.m0.e.e.l4.c[] observers = this.observers;
            i2 = 0;
            for (Object length : obj0) {
                if (i2 != i) {
                }
                length.a();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b(int i, boolean z2) {
            int obj1;
            c obj2;
            if (z2 == null) {
                this.done = true;
                a(i);
                l.a(this.downstream, this, this.error);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void c(int i, Throwable throwable2) {
            this.done = true;
            c.dispose(this.upstream);
            a(i);
            l.c(this.downstream, throwable2, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d(int i, Object object2) {
            this.values.set(i, object2);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            int i;
            i.b.m0.e.e.l4.c cVar;
            c.dispose(this.upstream);
            i.b.m0.e.e.l4.c[] observers = this.observers;
            i = 0;
            while (i < observers.length) {
                observers[i].a();
                i++;
            }
        }

        void e(w<?>[] wArr, int i2) {
            int i;
            Object disposed;
            i.b.m0.e.e.l4.c cVar;
            i = 0;
            while (i < i2) {
                if (!c.isDisposed((b)this.upstream.get())) {
                    break;
                }
                if (this.done) {
                    break;
                } else {
                }
                wArr[i].subscribe(this.observers[i]);
                i++;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return c.isDisposed((b)this.upstream.get());
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onComplete() {
            boolean downstream;
            c error;
            if (!this.done) {
                this.done = true;
                a(-1);
                l.a(this.downstream, this, this.error);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onError(Throwable throwable) {
            if (this.done) {
                a.t(throwable);
            }
            this.done = true;
            a(-1);
            l.c(this.downstream, throwable, this, this.error);
        }

        public void onNext(T t) {
            int i;
            Object obj5;
            if (this.done) {
            }
            AtomicReferenceArray values = this.values;
            int length = values.length();
            Object[] arr = new Object[length + 1];
            arr[0] = t;
            while (i < length) {
                obj5 = values.get(i);
                arr[i++] = obj5;
            }
            obj5 = this.combiner.apply(arr);
            b.e(obj5, "combiner returned a null value");
            l.e(this.downstream, obj5, this, this.error);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void onSubscribe(b b) {
            c.setOnce(this.upstream, b);
        }
    }

    static final class c extends AtomicReference<b> implements y<Object> {

        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final i.b.m0.e.e.l4.b<?, ?> parent;
        c(i.b.m0.e.e.l4.b<?, ?> l4$b, int i2) {
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
            this.parent.b(this.index, this.hasValue);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            this.parent.c(this.index, throwable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onNext(Object object) {
            boolean hasValue;
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.d(this.index, object);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }
    }
    public l4(w<T> w, Iterable<? extends w<?>> iterable2, n<? super Object[], R> n3) {
        super(w);
        this.b = 0;
        this.c = iterable2;
        this.v = n3;
    }

    public l4(w<T> w, w<?>[] w2Arr2, n<? super Object[], R> n3) {
        super(w);
        this.b = w2Arr2;
        this.c = 0;
        this.v = n3;
    }

    protected void subscribeActual(y<? super R> y) {
        w[] copyOf;
        Iterator iterator;
        int length;
        Object next;
        int i;
        int length2;
        copyOf = this.b;
        if (copyOf == null) {
            copyOf = new w[8];
            iterator = this.c.iterator();
            length = 0;
            while (iterator.hasNext()) {
                if (length == copyOf.length) {
                }
                copyOf[length] = (w)iterator.next();
                length = i;
                copyOf = Arrays.copyOf(copyOf, i3 += length);
            }
        } else {
            length = copyOf.length;
        }
        try {
            if (length == 0) {
            }
            l4.a aVar = new l4.a(this);
            v1 v1Var = new v1(this.a, aVar);
            v1Var.subscribeActual(y);
            l4.b bVar = new l4.b(y, this.v, length);
            y.onSubscribe(bVar);
            bVar.e(copyOf, length);
            this.a.subscribe(bVar);
        }
    }
}

package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class h<T>  extends r<T> {

    final w<? extends T>[] a;
    final Iterable<? extends w<? extends T>> b;

    static final class a implements b {

        final y<? super T> a;
        final i.b.m0.e.e.h.b<T>[] b;
        final AtomicInteger c;
        a(y<? super T> y, int i2) {
            super();
            AtomicInteger atomicInteger = new AtomicInteger();
            this.c = atomicInteger;
            this.a = y;
            this.b = new h.b[i2];
        }

        public void a(w<? extends T>[] wArr) {
            int i;
            int i2;
            y yVar;
            i.b.m0.e.e.h.b bVar;
            int i3;
            y yVar2;
            final i.b.m0.e.e.h.b[] objArr = this.b;
            final int length = objArr.length;
            i = 0;
            i2 = i;
            while (i2 < length) {
                i3 = i2 + 1;
                bVar = new h.b(this, i3, this.a);
                objArr[i2] = bVar;
                i2 = i3;
            }
            this.c.lazySet(i);
            this.a.onSubscribe(this);
            while (i < length) {
                wArr[i].subscribe(objArr[i]);
                i++;
            }
        }

        @Override // i.b.j0.b
        public boolean b(int i) {
            int i3;
            int i2;
            int i4;
            int i5 = this.c.get();
            i2 = 0;
            if (i5 == 0 && this.c.compareAndSet(i2, i)) {
                if (this.c.compareAndSet(i2, i)) {
                    i.b.m0.e.e.h.b[] objArr = this.b;
                    while (i2 < objArr.length) {
                        i4 = i2 + 1;
                        if (i4 != i) {
                        }
                        i2 = i4;
                        objArr[i2].a();
                    }
                    return 1;
                }
                return i2;
            }
            if (i5 == i) {
            } else {
                i3 = i2;
            }
            return i3;
        }

        @Override // i.b.j0.b
        public void dispose() {
            int i;
            int length;
            int i2;
            i.b.m0.e.e.h.b bVar;
            length = -1;
            if (this.c.get() != length) {
                this.c.lazySet(length);
                i = this.b;
                i2 = 0;
                while (i2 < i.length) {
                    i[i2].a();
                    i2++;
                }
            }
        }

        @Override // i.b.j0.b
        public boolean isDisposed() {
            int i;
            i = this.c.get() == -1 ? 1 : 0;
            return i;
        }
    }

    static final class b extends AtomicReference<b> implements y<T> {

        private static final long serialVersionUID = -1185974347409665484L;
        final y<? super T> downstream;
        final int index;
        final i.b.m0.e.e.h.a<T> parent;
        boolean won;
        b(i.b.m0.e.e.h.a<T> h$a, int i2, y<? super T> y3) {
            super();
            this.parent = a;
            this.index = i2;
            this.downstream = y3;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void a() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            y downstream;
            int index;
            if (this.won) {
                this.downstream.onComplete();
            } else {
                if (this.parent.b(this.index)) {
                    this.won = true;
                    this.downstream.onComplete();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable throwable) {
            y downstream;
            int index;
            if (this.won) {
                this.downstream.onError(throwable);
            } else {
                if (this.parent.b(this.index)) {
                    this.won = true;
                    this.downstream.onError(throwable);
                } else {
                    a.t(throwable);
                }
            }
        }

        public void onNext(T t) {
            y downstream;
            int index;
            Object obj3;
            if (this.won) {
                this.downstream.onNext(t);
            } else {
                if (this.parent.b(this.index)) {
                    this.won = true;
                    this.downstream.onNext(t);
                } else {
                    (b)get().dispose();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.setOnce(this, b);
        }
    }
    public h(w<? extends T>[] wArr, Iterable<? extends w<? extends T>> iterable2) {
        super();
        this.a = wArr;
        this.b = iterable2;
    }

    public void subscribeActual(y<? super T> y) {
        w[] arr;
        Iterator iterator;
        int length;
        boolean next;
        int i;
        int length2;
        arr = this.a;
        int i3 = 0;
        if (arr == null) {
            arr = new w[8];
            iterator = this.b.iterator();
            length = i3;
            for (w next : iterator) {
                if (length == arr.length) {
                }
                arr[length] = next;
                length = i;
                length2 = new w[i5 += length];
                System.arraycopy(arr, i3, length2, i3, length);
                arr = length2;
            }
        } else {
            try {
                length = arr.length;
                if (length == 0) {
                }
                d.complete(y);
                if (length == 1) {
                }
                arr[i3].subscribe(y);
                h.a aVar = new h.a(y, length);
                aVar.a(arr);
            }
        }
    }
}

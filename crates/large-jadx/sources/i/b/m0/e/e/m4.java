package i.b.m0.e.e;

import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.f.c;
import i.b.r;
import i.b.w;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class m4<T, R>  extends r<R> {

    final w<? extends T>[] a;
    final Iterable<? extends w<? extends T>> b;
    final n<? super Object[], ? extends R> c;
    final int v;
    final boolean w;

    static final class a extends AtomicInteger implements b {

        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final y<? super R> downstream;
        final i.b.m0.e.e.m4.b<T, R>[] observers;
        final T[] row;
        final n<? super Object[], ? extends R> zipper;
        a(y<? super R> y, n<? super Object[], ? extends R> n2, int i3, boolean z4) {
            super();
            this.downstream = y;
            this.zipper = n2;
            this.observers = new m4.b[i3];
            this.row = new Object[i3];
            this.delayError = z4;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void a() {
            d();
            b();
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void b() {
            int i;
            i.b.m0.e.e.m4.b bVar;
            final i.b.m0.e.e.m4.b[] observers = this.observers;
            i = 0;
            while (i < observers.length) {
                observers[i].a();
                i++;
            }
        }

        boolean c(boolean z, boolean z2, y<? super R> y3, boolean z4, i.b.m0.e.e.m4.b<?, ?> m4$b5) {
            Throwable obj3;
            final int i = 1;
            if (this.cancelled) {
                a();
                return i;
            }
            if (z != null) {
                if (z4) {
                    if (z2) {
                        obj3 = b5.v;
                        this.cancelled = i;
                        a();
                        if (obj3 != null) {
                            y3.onError(obj3);
                        } else {
                            y3.onComplete();
                        }
                        return i;
                    }
                } else {
                    obj3 = b5.v;
                    if (obj3 != null) {
                        this.cancelled = i;
                        a();
                        y3.onError(obj3);
                        return i;
                    }
                    if (z2) {
                        this.cancelled = i;
                        a();
                        y3.onComplete();
                        return i;
                    }
                }
            }
            return 0;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        void d() {
            int i;
            c cVar;
            final i.b.m0.e.e.m4.b[] observers = this.observers;
            i = 0;
            while (i < observers.length) {
                bVar.b.clear();
                i++;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void dispose() {
            boolean andIncrement;
            this.cancelled = true;
            b();
            if (!this.cancelled && getAndIncrement() == 0) {
                this.cancelled = true;
                b();
                if (getAndIncrement() == 0) {
                    d();
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public void e() {
            int i7;
            String str;
            int i3;
            y yVar;
            boolean z;
            i.b.m0.e.e.m4.b bVar;
            int andGet;
            int length;
            int i;
            int i4;
            int i6;
            int i2;
            Object poll;
            int i5;
            final Object obj3 = this;
            if (getAndIncrement() != 0) {
            }
            i.b.m0.e.e.m4.b[] observers = obj3.observers;
            final y downstream = obj3.downstream;
            final Object[] row = obj3.row;
            final boolean delayError = obj3.delayError;
            final int i8 = 1;
            andGet = i8;
            while (/* condition */) {
                while (i4 < length) {
                    bVar = observers[i4];
                    i2++;
                    i4++;
                    i7 = bVar.v;
                    poll = bVar.b.poll();
                    if (poll == null) {
                    } else {
                    }
                    i5 = i;
                    if (i5 == 0) {
                    } else {
                    }
                    i6++;
                    row[i2] = poll;
                    i5 = i8;
                }
                Object apply = obj3.zipper.apply(row.clone());
                b.e(apply, "The zipper returned a null value");
                downstream.onNext(apply);
                Arrays.fill(row, 0);
                i = 0;
                i2 = i6;
                bVar = observers[i4];
                i2++;
                i4++;
                i7 = bVar.v;
                poll = bVar.b.poll();
                if (poll == null) {
                } else {
                }
                i5 = i;
                if (i5 == 0) {
                } else {
                }
                i6++;
                row[i2] = poll;
                i5 = i8;
            }
        }

        public void f(w<? extends T>[] wArr, int i2) {
            int i;
            int i3;
            i.b.m0.e.e.m4.b bVar;
            y obj7;
            final i.b.m0.e.e.m4.b[] observers = this.observers;
            final int length = observers.length;
            i = 0;
            i3 = i;
            while (i3 < length) {
                bVar = new m4.b(this, i2);
                observers[i3] = bVar;
                i3++;
            }
            lazySet(i);
            this.downstream.onSubscribe(this);
            while (i < length) {
                wArr[i].subscribe(observers[i]);
                i++;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    static final class b implements y<T> {

        final i.b.m0.e.e.m4.a<T, R> a;
        final c<T> b;
        volatile boolean c;
        Throwable v;
        final AtomicReference<b> w;
        b(i.b.m0.e.e.m4.a<T, R> m4$a, int i2) {
            super();
            AtomicReference atomicReference = new AtomicReference();
            this.w = atomicReference;
            this.a = a;
            c obj2 = new c(i2);
            this.b = obj2;
        }

        @Override // i.b.y
        public void a() {
            c.dispose(this.w);
        }

        @Override // i.b.y
        public void onComplete() {
            this.c = true;
            this.a.e();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.v = throwable;
            this.c = true;
            this.a.e();
        }

        public void onNext(T t) {
            this.b.offer(t);
            this.a.e();
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            c.setOnce(this.w, b);
        }
    }
    public m4(w<? extends T>[] wArr, Iterable<? extends w<? extends T>> iterable2, n<? super Object[], ? extends R> n3, int i4, boolean z5) {
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
        int length;
        boolean next;
        int i2;
        int length2;
        arr = this.a;
        if (arr == null) {
            arr = new w[8];
            iterator = this.b.iterator();
            i = 0;
            length = i;
            while (iterator.hasNext()) {
                if (length == arr.length) {
                }
                arr[length] = (w)iterator.next();
                length = i2;
                length2 = new w[i4 += length];
                System.arraycopy(arr, i, length2, i, length);
                arr = length2;
            }
        } else {
            length = arr.length;
        }
        if (length == 0) {
            d.complete(y);
        }
        m4.a aVar = new m4.a(y, this.c, length, this.w);
        aVar.f(arr, this.v);
    }
}

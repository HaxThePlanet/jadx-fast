package i.b.m0.e.e;

import i.b.m0.b.b;
import i.b.m0.d.c;
import i.b.r;
import i.b.y;

/* loaded from: classes3.dex */
public final class b1<T>  extends r<T> {

    final T[] a;

    static final class a extends c<T> {

        final y<? super T> a;
        final T[] b;
        int c;
        boolean v;
        volatile boolean w;
        a(y<? super T> y, T[] t2Arr2) {
            super();
            this.a = y;
            this.b = t2Arr2;
        }

        @Override // i.b.m0.d.c
        void a() {
            boolean disposed;
            int i;
            Object disposed2;
            y yVar;
            Object[] objArr = this.b;
            i = 0;
            while (i < objArr.length) {
                disposed2 = objArr[i];
                this.a.onNext(disposed2);
                i++;
            }
            if (!isDisposed()) {
                this.a.onComplete();
            }
        }

        @Override // i.b.m0.d.c
        public void clear() {
            this.c = objArr.length;
        }

        @Override // i.b.m0.d.c
        public void dispose() {
            this.w = true;
        }

        @Override // i.b.m0.d.c
        public boolean isDisposed() {
            return this.w;
        }

        @Override // i.b.m0.d.c
        public boolean isEmpty() {
            int i;
            i = this.c == objArr.length ? 1 : 0;
            return i;
        }

        public T poll() {
            int i = this.c;
            Object[] objArr = this.b;
            if (i != objArr.length) {
                this.c = i + 1;
                Object obj = objArr[i];
                b.e(obj, "The array element is null");
                return obj;
            }
            return 0;
        }

        @Override // i.b.m0.d.c
        public int requestFusion(int i) {
            final int i2 = 1;
            if (i &= i2 != 0) {
                this.v = i2;
                return i2;
            }
            return 0;
        }
    }
    public b1(T[] tArr) {
        super();
        this.a = tArr;
    }

    public void subscribeActual(y<? super T> y) {
        b1.a aVar = new b1.a(y, this.a);
        y.onSubscribe(aVar);
        if (aVar.v) {
        }
        aVar.a();
    }
}

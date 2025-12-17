package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.a;
import i.b.j0.b;
import i.b.m0.b.b;
import i.b.p0.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class v<T>  extends a0<Boolean> {

    final g0<? extends T> a;
    final g0<? extends T> b;

    static class a implements d0<T> {

        final int a;
        final a b;
        final Object[] c;
        final d0<? super Boolean> v;
        final AtomicInteger w;
        a(int i, a a2, Object[] object3Arr3, d0<? super Boolean> d04, AtomicInteger atomicInteger5) {
            super();
            this.a = i;
            this.b = a2;
            this.c = object3Arr3;
            this.v = d04;
            this.w = atomicInteger5;
        }

        @Override // i.b.d0
        public void onError(Throwable throwable) {
            int i = this.w.get();
            final int i2 = 2;
            while (i >= i2) {
                i = this.w.get();
                i2 = 2;
            }
            a.t(throwable);
        }

        @Override // i.b.d0
        public void onSubscribe(b b) {
            this.b.b(b);
        }

        public void onSuccess(T t) {
            int valueOf;
            int i;
            int i2;
            int obj4;
            this.c[this.a] = t;
            if (this.w.incrementAndGet() == 2) {
                Object[] objArr2 = this.c;
                this.v.onSuccess(Boolean.valueOf(b.c(objArr2[0], objArr2[1])));
            }
        }
    }
    public v(g0<? extends T> g0, g0<? extends T> g02) {
        super();
        this.a = g0;
        this.b = g02;
    }

    protected void subscribeActual(d0<? super Boolean> d0) {
        AtomicInteger atomicInteger = new AtomicInteger();
        final Object[] arr = new Object[2];
        int i4 = 0;
        a aVar4 = new a();
        d0.onSubscribe(aVar4);
        final a aVar3 = aVar4;
        final Object[] objArr = arr;
        final d0 d0Var = d0;
        final AtomicInteger num = atomicInteger;
        super(0, aVar3, objArr, d0Var, num);
        this.a.subscribe(aVar5);
        super(1, aVar3, objArr, d0Var, num);
        this.b.subscribe(aVar6);
    }
}

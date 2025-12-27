package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SingleEquals.java */
/* loaded from: classes3.dex */
public final class v<T> extends a0<Boolean> {

    final g0<? extends T> a;
    final g0<? extends T> b;

    static class a<T> implements d0<T> {

        final int a;
        final i.b.j0.a b;
        final Object[] c;
        final d0<? super Boolean> v;
        final AtomicInteger w;
        a(int i, i.b.j0.a aVar, Object[] objectArr, d0<? super Boolean> d0Var, AtomicInteger atomicInteger) {
            super();
            this.a = i;
            this.b = aVar;
            this.c = objectArr;
            this.v = d0Var;
            this.w = atomicInteger;
        }

        public void onError(Throwable th) {
            int i = this.w.get();
            final int i2 = 2;
            while (i >= i2) {
                if (this.w.compareAndSet(i, i2)) {
                    this.b.dispose();
                    this.v.onError(th);
                    return;
                }
                i = this.w.get();
                i2 = 2;
            }
            a.t(th);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            this.b.b(bVar);
        }

        public void onSuccess(T t) {
            this.c[this.a] = t;
            int i = 2;
            if (this.w.incrementAndGet() == 2) {
                int i3 = 1;
                this.v.onSuccess(Boolean.valueOf(b.c(objArr2[0], objArr2[i3])));
            }
        }
    }
    public v(g0<? extends T> g0Var, g0<? extends T> g0Var2) {
        super();
        this.a = g0Var;
        this.b = g0Var2;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super Boolean> d0Var) {
        final Object[] arr = new Object[2];
        Object obj = null;
        final i.b.j0.a aVar3 = new a();
        d0Var.onSubscribe(aVar3);
        final d0 d0Var2 = d0Var;
        v.a aVar = new v.a(0, aVar3, arr, d0Var2, atomicInteger);
        this.a.subscribe(aVar);
        v.a aVar2 = new v.a(1, aVar3, arr, d0Var2, atomicInteger);
        this.b.subscribe(aVar2);
    }
}

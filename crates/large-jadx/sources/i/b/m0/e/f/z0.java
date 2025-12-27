package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.l0.n;
import i.b.m0.a.d;
import i.b.m0.b.b;
import io.reactivex.exceptions.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: SingleZipIterable.java */
/* loaded from: classes3.dex */
public final class z0<T, R> extends a0<R> {

    final Iterable<? extends g0<? extends T>> a;
    final n<? super Object[], ? extends R> b;

    final class a implements n<T, R> {

        final /* synthetic */ z0 a;
        a() {
            this.a = z0Var;
            super();
        }

        public R apply(T t) {
            Object[] arr = new Object[1];
            final Object apply = this.a.b.apply(new Object[] { t });
            b.e(apply, "The zipper returned a null value");
            return apply;
        }
    }
    public z0(Iterable<? extends g0<? extends T>> iterable, n<? super Object[], ? extends R> nVar) {
        super();
        this.a = iterable;
        this.b = nVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super R> d0Var) {
        g0[] arr;
        int i = 0;
        arr = new g0[8];
        try {
            Iterator it = this.a.iterator();
            i = 0;
            Object item = it.next();
            d.error(new NullPointerException("One of the sources is null"), d0Var);
            return;
        } catch (Throwable th) {
            a.b(th);
            d.error(th, d0Var);
            return;
        }
        if (i == 0) {
            d.error(new NoSuchElementException(), d0Var);
            return;
        }
        if (i == 1) {
            arr[i].subscribe(new k0.a(d0Var, new z0.a(this)));
            return;
        }
        i.b.m0.e.f.y0.b bVar = new y0.b(d0Var, i, this.b);
        d0Var.onSubscribe(bVar);
        while (i < i) {
            if (bVar.isDisposed()) {
                return;
            }
        }
    }
}

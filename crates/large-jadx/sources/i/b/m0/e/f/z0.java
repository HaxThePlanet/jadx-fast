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

/* loaded from: classes3.dex */
public final class z0<T, R>  extends a0<R> {

    final Iterable<? extends g0<? extends T>> a;
    final n<? super Object[], ? extends R> b;

    final class a implements n<T, R> {

        final i.b.m0.e.f.z0 a;
        a(i.b.m0.e.f.z0 z0) {
            this.a = z0;
            super();
        }

        public R apply(T t) {
            Object[] arr = new Object[1];
            final Object obj4 = z0Var.b.apply(arr);
            b.e(obj4, "The zipper returned a null value");
            return obj4;
        }
    }
    public z0(Iterable<? extends g0<? extends T>> iterable, n<? super Object[], ? extends R> n2) {
        super();
        this.a = iterable;
        this.b = n2;
    }

    protected void subscribeActual(d0<? super R> d0) {
        g0[] copyOf;
        int i;
        int i3;
        Object next;
        n nVar;
        int i2;
        int length;
        d0 obj7;
        copyOf = new g0[8];
        Iterator iterator = this.a.iterator();
        i = 0;
        i3 = i;
        for (g0 next : iterator) {
            if (i3 == copyOf.length) {
            }
            copyOf[i3] = next;
            i3 = i2;
            copyOf = Arrays.copyOf(copyOf, i6 += i3);
        }
        if (i3 == 0) {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            d.error(noSuchElementException, d0);
        }
        if (i3 == 1) {
            z0.a aVar2 = new z0.a(this);
            k0.a aVar = new k0.a(d0, aVar2);
            copyOf[i].subscribe(aVar);
        }
        y0.b bVar = new y0.b(d0, i3, this.b);
        d0.onSubscribe(bVar);
        while (i < i3) {
            copyOf[i].subscribe(bVar.observers[i]);
            i++;
        }
    }
}

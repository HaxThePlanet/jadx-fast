package f.d.a;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import d.e.b;
import java.util.Collection;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.d0.d.g0;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
public final class a<T>  extends v<T> {

    private final b<f.d.a.a.a<? super T>> b;

    private static final class a implements y<T> {

        private boolean a;
        private final y<T> b;
        public a(y<T> y) {
            n.g(y, "observer");
            super();
            this.b = y;
        }

        public final y<T> a() {
            return this.b;
        }

        @Override // androidx.lifecycle.y
        public final void b() {
            this.a = true;
        }

        public void onChanged(T t) {
            boolean z;
            if (this.a) {
                this.a = false;
                this.b.onChanged(t);
            }
        }
    }
    public a() {
        super();
        b bVar = new b();
        this.b = bVar;
    }

    public void observe(q q, y<? super T> y2) {
        n.g(q, "owner");
        n.g(y2, "observer");
        a.a aVar = new a.a(y2);
        this.b.add(aVar);
        super.observe(q, aVar);
    }

    public void observeForever(y<? super T> y) {
        n.g(y, "observer");
        a.a aVar = new a.a(y);
        this.b.add(aVar);
        super.observeForever(aVar);
    }

    public void removeObserver(y<? super T> y) {
        String next;
        boolean z;
        n.g(y, "observer");
        b bVar = this.b;
        if (bVar == null) {
        } else {
            if (g0.a(bVar).remove(y)) {
                super.removeObserver(y);
            }
            Iterator iterator = this.b.iterator();
            n.c(iterator, "observers.iterator()");
            while (iterator.hasNext()) {
                next = iterator.next();
                if (n.b((a.a)next.a(), y)) {
                    break;
                } else {
                }
            }
        }
        TypeCastException obj4 = new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        throw obj4;
    }

    public void setValue(T t) {
        Object next;
        Iterator iterator = this.b.iterator();
        for (a.a next : iterator) {
            next.b();
        }
        super.setValue(t);
    }
}

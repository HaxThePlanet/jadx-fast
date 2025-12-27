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

/* compiled from: LiveEvent.kt */
/* loaded from: classes2.dex */
public final class a<T> extends v<T> {

    private final b<a.a<? super T>> b = new b<>();

    private static final class a<T> implements y<T> {

        private boolean a;
        private final y<T> b;
        public a(y<T> yVar) {
            n.g(yVar, "observer");
            super();
            this.b = yVar;
        }

        public final y<T> a() {
            return this.b;
        }

        public final void b() {
            this.a = true;
        }

        public void onChanged(T t) {
            if (this.a) {
                this.a = false;
                this.b.onChanged(t);
            }
        }
    }
    public a() {
        super();
        final b bVar = new b();
    }

    @Override // androidx.lifecycle.v
    public void observe(q qVar, y<? super T> yVar) {
        n.g(qVar, "owner");
        n.g(yVar, "observer");
        f.d.a.a.a aVar = new a.a(yVar);
        this.b.add(aVar);
        super.observe(qVar, aVar);
    }

    @Override // androidx.lifecycle.v
    public void observeForever(y<? super T> yVar) {
        n.g(yVar, "observer");
        f.d.a.a.a aVar = new a.a(yVar);
        this.b.add(aVar);
        super.observeForever(aVar);
    }

    @Override // androidx.lifecycle.v
    public void removeObserver(y<? super T> yVar) throws TypeCastException {
        boolean z;
        n.g(yVar, "observer");
        if (this.b == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        } else {
            if (g0.a(this.b).remove(yVar)) {
                super.removeObserver(yVar);
                return;
            }
            Iterator it = this.b.iterator();
            item = "observers.iterator()";
            n.c(it, item);
            while (it.hasNext()) {
                String item = it.next();
                if (n.b(item.a(), yVar)) {
                    it.remove();
                    super.removeObserver(item);
                }
            }
            return;
        }
    }

    @Override // androidx.lifecycle.v
    public void setValue(T t) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            (a.a)it.next().b();
        }
        super.setValue(t);
    }
}

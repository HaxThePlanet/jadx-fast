package net.time4j.engine;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import net.time4j.tz.k;

/* compiled from: ChronoEntity.java */
/* loaded from: classes3.dex */
public abstract class q<T extends q<T>> implements o {
    public Set<p<?>> A() {
        return y().u();
    }

    <V> y<T, V> B(p<V> pVar) {
        return y().v(pVar);
    }

    public boolean C(p<Long> pVar, long j) {
        return D(pVar, Long.valueOf(j));
    }

    public <V> boolean D(p<V> pVar, V v) {
        boolean z;
        boolean z2 = false;
        Objects.requireNonNull(pVar, "Missing chronological element.");
        if (v(pVar)) {
            pVar = B(pVar).isValid(z(), v) ? 1 : 0;
        }
        return (B(pVar).isValid(z(), v) ? 1 : 0);
    }

    public T E(p<Integer> pVar, int i) {
        net.time4j.engine.b0 b0Var = y().r(pVar);
        if (b0Var != null) {
            return (q)b0Var.a(z(), i, pVar.isLenient());
        }
        return G(pVar, Integer.valueOf(i));
    }

    public T F(p<Long> pVar, long j) {
        return G(pVar, Long.valueOf(j));
    }

    public <V> T G(p<V> pVar, V v) {
        return (q)B(pVar).withValue(z(), v, pVar.isLenient());
    }

    public T H(u<T> uVar) {
        return (q)uVar.apply(z());
    }

    public int e(p<Integer> pVar) {
        net.time4j.engine.b0 b0Var = y().r(pVar);
        if (b0Var == null) {
            try {
                return (Integer)p(pVar).intValue();
            } catch (net.time4j.engine.ChronoException unused) {
                pVar = -2147483648;
                return pVar;
            }
            return i;
        }
    }

    public <V> V p(p<V> pVar) {
        return B(pVar).getValue(z());
    }

    public <V> V r(p<V> pVar) {
        return B(pVar).getMaximum(z());
    }

    public k t() throws ChronoException {
        StringBuilder stringBuilder = new StringBuilder();
        final String str = "Timezone not available: ";
        r1 = str + this;
        throw new ChronoException(r1);
    }

    public boolean v(p<?> pVar) {
        return y().x(pVar);
    }

    public <V> V w(p<V> pVar) {
        return B(pVar).getMinimum(z());
    }

    protected T z() {
        net.time4j.engine.w wVar = y();
        Class cls = wVar.l();
        if (cls.isInstance(this)) {
            return (q)cls.cast(this);
        }
        Iterator it = wVar.u().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (cls == item.getType()) {
                return (q)cls.cast(p(item));
            }
        }
        throw new IllegalStateException("Implementation error: Cannot find entity context.");
    }

    public boolean j() {
        return false;
    }

    protected abstract w<T> y();
}

package net.time4j.engine;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import net.time4j.tz.k;

/* loaded from: classes3.dex */
public abstract class q<T extends net.time4j.engine.q<T>>  implements net.time4j.engine.o {
    public Set<net.time4j.engine.p<?>> A() {
        return y().u();
    }

    <V> net.time4j.engine.y<T, V> B(net.time4j.engine.p<V> p) {
        return y().v(p);
    }

    public boolean C(net.time4j.engine.p<Long> p, long l2) {
        return D(p, Long.valueOf(l2));
    }

    public <V> boolean D(net.time4j.engine.p<V> p, V v2) {
        boolean z;
        Object obj2;
        Objects.requireNonNull(p, "Missing chronological element.");
        if (v(p) && B(p).isValid(z(), v2)) {
            obj2 = B(p).isValid(z(), v2) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public T E(net.time4j.engine.p<Integer> p, int i2) {
        net.time4j.engine.b0 b0Var = y().r(p);
        if (b0Var != null) {
            return (q)b0Var.a(z(), i2, p.isLenient());
        }
        return G(p, Integer.valueOf(i2));
    }

    public T F(net.time4j.engine.p<Long> p, long l2) {
        return G(p, Long.valueOf(l2));
    }

    public <V> T G(net.time4j.engine.p<V> p, V v2) {
        return (q)B(p).withValue(z(), v2, p.isLenient());
    }

    public T H(net.time4j.engine.u<T> u) {
        return (q)u.apply(z());
    }

    public int e(net.time4j.engine.p<Integer> p) {
        net.time4j.engine.b0 b0Var = y().r(p);
        if (b0Var == null) {
            return (Integer)p(p).intValue();
        }
        return b0Var.c(z());
    }

    @Override // net.time4j.engine.o
    public boolean j() {
        return 0;
    }

    public <V> V p(net.time4j.engine.p<V> p) {
        return B(p).getValue(z());
    }

    public <V> V r(net.time4j.engine.p<V> p) {
        return B(p).getMaximum(z());
    }

    @Override // net.time4j.engine.o
    public k t() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timezone not available: ");
        stringBuilder.append(this);
        ChronoException chronoException = new ChronoException(stringBuilder.toString());
        throw chronoException;
    }

    public boolean v(net.time4j.engine.p<?> p) {
        return y().x(p);
    }

    public <V> V w(net.time4j.engine.p<V> p) {
        return B(p).getMinimum(z());
    }

    protected abstract net.time4j.engine.w<T> y();

    protected T z() {
        boolean instance;
        Class type;
        net.time4j.engine.w wVar = y();
        Class cls = wVar.l();
        if (cls.isInstance(this)) {
            return (q)cls.cast(this);
        }
        Iterator iterator = wVar.u().iterator();
        for (p instance : iterator) {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Implementation error: Cannot find entity context.");
        throw illegalStateException;
    }
}

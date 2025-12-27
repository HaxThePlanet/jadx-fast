package net.time4j.g1.z;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.tz.k;

/* compiled from: ParsedEntity.java */
/* loaded from: classes3.dex */
abstract class t<T extends t<T>> extends q<T> {
    t() {
        super();
    }

    @Override // net.time4j.engine.q
    public <V> boolean D(p<V> pVar, V v) {
        Objects.requireNonNull(pVar, "Missing chronological element.");
        return true;
    }

    @Override // net.time4j.engine.q
    public T M(p<Integer> pVar, int i) {
        J(pVar, i);
        return this;
    }

    @Override // net.time4j.engine.q
    public <V> T N(p<V> pVar, V v) {
        K(pVar, v);
        return this;
    }

    @Override // net.time4j.engine.q
    public final boolean equals(Object object) {
        boolean z = true;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof t) {
            Set set = A();
            final Set set2 = object.A();
            if (set.size() != set2.size()) {
                return false;
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                if (!set2.contains(item)) {
                    return false;
                }
            }
            Object obj = I();
            Object obj4 = object.I();
            if (obj == null && obj4 == null) {
                return z;
            }
            return obj.equals(obj4);
        }
        return false;
    }

    @Override // net.time4j.engine.q
    public final int hashCode() {
        int i;
        Object obj = I();
        if (obj != null) {
            i = A().hashCode() + (obj.hashCode() * 31);
        }
        return i;
    }

    @Override // net.time4j.engine.q
    public final boolean j() {
        boolean z2 = false;
        if (!v(b0.TIMEZONE_ID)) {
            if (v(b0.TIMEZONE_OFFSET)) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z2;
    }

    @Override // net.time4j.engine.q
    public <V> V r(p<V> pVar) {
        return pVar.getDefaultMaximum();
    }

    @Override // net.time4j.engine.q
    public final k t() {
        Object obj;
        net.time4j.g1.z.b0 tIMEZONE_ID2 = b0.TIMEZONE_ID;
        final int i = 0;
        if (v(tIMEZONE_ID2)) {
            obj = p(b0.TIMEZONE_ID);
        } else {
            net.time4j.g1.z.b0 tIMEZONE_OFFSET2 = b0.TIMEZONE_OFFSET;
            if (v(tIMEZONE_OFFSET2)) {
                obj = p(b0.TIMEZONE_OFFSET);
            } else {
            }
        }
        if (!(obj instanceof k)) {
            super.t();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            return (k)k.class.cast(obj);
        }
    }

    @Override // net.time4j.engine.q
    public String toString() {
        int i = 1;
        char c = 61;
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append('{');
        Iterator it = A().iterator();
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            stringBuilder.append(item.name());
            c = '=';
            stringBuilder.append(c);
            stringBuilder.append(p(item));
        }
        stringBuilder.append('}');
        Object obj2 = I();
        if (obj2 != null) {
            stringBuilder.append(">>>result=");
            stringBuilder.append(obj2);
        }
        return stringBuilder.toString();
    }

    @Override // net.time4j.engine.q
    public <V> V w(p<V> pVar) {
        return pVar.getDefaultMinimum();
    }

    @Override // net.time4j.engine.q
    protected final w<T> y() {
        throw new UnsupportedOperationException("Parsed values do not have any chronology.");
    }

    @Override // net.time4j.engine.q
    abstract <E> E I();

    @Override // net.time4j.engine.q
    abstract void J(p<?> pVar, int i);

    @Override // net.time4j.engine.q
    abstract void K(p<?> pVar, Object object);

    @Override // net.time4j.engine.q
    abstract void L(Object object);
}

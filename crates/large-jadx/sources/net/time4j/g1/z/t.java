package net.time4j.g1.z;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.tz.k;

/* loaded from: classes3.dex */
abstract class t<T extends net.time4j.g1.z.t<T>>  extends q<T> {
    public <V> boolean D(p<V> p, V v2) {
        Objects.requireNonNull(p, "Missing chronological element.");
        return 1;
    }

    @Override // net.time4j.engine.q
    public q E(p p, int i2) {
        M(p, i2);
        return this;
    }

    @Override // net.time4j.engine.q
    public q G(p p, Object object2) {
        N(p, object2);
        return this;
    }

    abstract <E> E I();

    abstract void J(p<?> p, int i2);

    abstract void K(p<?> p, Object object2);

    @Override // net.time4j.engine.q
    abstract void L(Object object);

    public T M(p<Integer> p, int i2) {
        J(p, i2);
        return this;
    }

    public <V> T N(p<V> p, V v2) {
        K(p, v2);
        return this;
    }

    @Override // net.time4j.engine.q
    public final boolean equals(Object object) {
        int i;
        int equals;
        int contains;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        Set set = A();
        final Set set2 = (t)object.A();
        if (object instanceof t && set.size() != set2.size()) {
            set = A();
            set2 = (t)object.A();
            if (set.size() != set2.size()) {
                return i2;
            }
            Iterator iterator = set.iterator();
            for (p equals : iterator) {
            }
            Object obj = I();
            Object obj7 = object.I();
            if (obj == null) {
                if (obj7 == null) {
                } else {
                    i = i2;
                }
                return i;
            }
            return obj.equals(obj7);
        }
        return i2;
    }

    @Override // net.time4j.engine.q
    public final int hashCode() {
        int i;
        Object obj;
        obj = I();
        if (obj != null) {
            i += obj;
        }
        return i;
    }

    @Override // net.time4j.engine.q
    public final boolean j() {
        int i;
        boolean z;
        if (!v(b0.TIMEZONE_ID)) {
            if (v(b0.TIMEZONE_OFFSET)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public <V> V r(p<V> p) {
        return p.getDefaultMaximum();
    }

    @Override // net.time4j.engine.q
    public final k t() {
        Object obj;
        boolean z;
        net.time4j.g1.z.b0 tIMEZONE_ID = b0.TIMEZONE_ID;
        final int i = 0;
        if (v(tIMEZONE_ID)) {
            obj = p(tIMEZONE_ID);
        } else {
            net.time4j.g1.z.b0 tIMEZONE_OFFSET = b0.TIMEZONE_OFFSET;
            if (v(tIMEZONE_OFFSET)) {
                obj = p(tIMEZONE_OFFSET);
            } else {
                obj = i;
            }
        }
        if (!obj instanceof k) {
        } else {
            return (k)k.class.cast(obj);
        }
        super.t();
        throw i;
    }

    @Override // net.time4j.engine.q
    public String toString() {
        int str2;
        Object obj;
        int str;
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append('{');
        Iterator iterator = A().iterator();
        str2 = 1;
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (str2 != null) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append((p)next2.name());
            stringBuilder.append('=');
            stringBuilder.append(p(next2));
            str2 = 0;
        }
        stringBuilder.append('}');
        Object obj2 = I();
        if (obj2 != null) {
            stringBuilder.append(">>>result=");
            stringBuilder.append(obj2);
        }
        return stringBuilder.toString();
    }

    public <V> V w(p<V> p) {
        return p.getDefaultMinimum();
    }

    protected final w<T> y() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Parsed values do not have any chronology.");
        throw unsupportedOperationException;
    }
}

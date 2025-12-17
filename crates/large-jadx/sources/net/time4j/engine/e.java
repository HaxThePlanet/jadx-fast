package net.time4j.engine;

import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class e<V extends Comparable<V>>  implements net.time4j.engine.p<V>, Serializable {

    private final int hash;
    private final int identity = -1;
    private final String name;
    protected e(String string) {
        super();
        if (string.trim().isEmpty()) {
        } else {
            this.name = string;
            int obj3 = string.hashCode();
            this.hash = obj3;
            final int i = -1;
            if (j()) {
                obj3 = ~obj3;
            }
            obj3 = i;
        }
        obj3 = new IllegalArgumentException("Element name is empty or contains only white space.");
        throw obj3;
    }

    @Override // net.time4j.engine.p
    public int b(net.time4j.engine.o o, net.time4j.engine.o o2) {
        return (Comparable)o.p(this).compareTo(o2.p(this));
    }

    @Override // net.time4j.engine.p
    public int compare(Object object, Object object2) {
        return b((o)object, (o)object2);
    }

    protected <T extends net.time4j.engine.q<T>> net.time4j.engine.y<T, V> d(net.time4j.engine.w<T> w) {
        return 0;
    }

    protected boolean e(net.time4j.engine.e<?> e) {
        return 1;
    }

    @Override // net.time4j.engine.p
    public final boolean equals(Object object) {
        int i;
        int identity;
        int identity2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object == null) {
            return i2;
        }
        if (getClass() == object.getClass()) {
            identity = this.identity;
            if (identity == object.identity) {
                if (identity == -1) {
                    if (name().equals((e)object.name()) && e(object)) {
                        if (e(object)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    protected net.time4j.engine.p<?> f() {
        return 0;
    }

    protected String g(net.time4j.engine.w<?> w) {
        boolean z;
        boolean obj2;
        if (h() && f.class.isAssignableFrom(w.l())) {
            if (f.class.isAssignableFrom(w.l())) {
                obj2 = new StringBuilder();
                obj2.append("Accessing the local element [");
                obj2.append(this.name);
                obj2.append("] from a global type requires a timezone.\n");
                obj2.append("- Try to apply a zonal query like \"");
                obj2.append(this.name);
                obj2.append(".atUTC()\".\n");
                obj2.append("- Or try to first convert the global type to ");
                obj2.append("a zonal timestamp: ");
                obj2.append("\"moment.toZonalTimestamp(...)\".\n");
                obj2.append("- If used in formatting then consider ");
                obj2.append("\"ChronoFormatter.withTimezone(TZID)\".");
                return obj2.toString();
            }
        }
        return null;
    }

    @Override // net.time4j.engine.p
    public char getSymbol() {
        return 0;
    }

    @Override // net.time4j.engine.p
    public boolean h() {
        return 1;
    }

    @Override // net.time4j.engine.p
    public final int hashCode() {
        return this.hash;
    }

    @Override // net.time4j.engine.p
    public boolean isLenient() {
        return 0;
    }

    @Override // net.time4j.engine.p
    protected boolean j() {
        return 0;
    }

    @Override // net.time4j.engine.p
    public final String name() {
        return this.name;
    }

    @Override // net.time4j.engine.p
    public String toString() {
        String name = getClass().getName();
        StringBuilder stringBuilder = new StringBuilder(length += 32);
        stringBuilder.append(name);
        stringBuilder.append('@');
        stringBuilder.append(this.name);
        return stringBuilder.toString();
    }
}

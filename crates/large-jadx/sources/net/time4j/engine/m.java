package net.time4j.engine;

import net.time4j.f1.c;

/* loaded from: classes3.dex */
public abstract class m<U, D extends net.time4j.engine.m<U, D>>  extends net.time4j.engine.i0<U, D> implements net.time4j.engine.g {
    private net.time4j.engine.k<D> Q() {
        return J().j();
    }

    private <T> T U(net.time4j.engine.k<T> k, String string2) {
        int cmp;
        long l = c();
        if (Long.compare(l2, l) > 0) {
        } else {
            if (Long.compare(l3, l) < 0) {
            } else {
                return k.a(l);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot transform <");
        stringBuilder.append(l);
        stringBuilder.append("> to: ");
        stringBuilder.append(string2);
        ArithmeticException obj5 = new ArithmeticException(stringBuilder.toString());
        throw obj5;
    }

    @Override // net.time4j.engine.i0
    public int I(net.time4j.engine.i0 i0) {
        return P((m)i0);
    }

    @Override // net.time4j.engine.i0
    protected int O(net.time4j.engine.g g) {
        int obj5;
        obj5 = Long.compare(l, l2);
        obj5 = obj5 < 0 ? -1 : obj5 == null ? 0 : 1;
        return obj5;
    }

    public int P(D d) {
        if (J().l() != d.J().l()) {
        } else {
            return O(d);
        }
        ClassCastException obj3 = new ClassCastException("Cannot compare different types of dates, use instance of EpochDays as comparator instead.");
        throw obj3;
    }

    @Override // net.time4j.engine.i0
    public boolean R(net.time4j.engine.g g) {
        int obj1;
        obj1 = O(g) > 0 ? 1 : 0;
        return obj1;
    }

    @Override // net.time4j.engine.i0
    public boolean S(net.time4j.engine.g g) {
        int obj1;
        obj1 = O(g) < 0 ? 1 : 0;
        return obj1;
    }

    public D T(net.time4j.engine.h h) {
        return (m)Q().a(c.f(c(), obj1));
    }

    public <T extends net.time4j.engine.l<T>> T V(Class<T> class, String string2) {
        final String name = class.getName();
        net.time4j.engine.w obj3 = w.y(class);
        if (obj3 == null) {
        } else {
            return (l)U(obj3.k(string2), name);
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Cannot find any chronology for given target type: ");
        obj4.append(name);
        obj3 = new IllegalArgumentException(obj4.toString());
        throw obj3;
    }

    public <T extends net.time4j.engine.m<?, T>> T W(Class<T> class) {
        String name = class.getName();
        net.time4j.engine.w obj4 = w.y(class);
        if (obj4 == null) {
        } else {
            return (m)U(obj4.j(), name);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find any chronology for given target type: ");
        stringBuilder.append(name);
        obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    @Override // net.time4j.engine.i0
    public long c() {
        return Q().b(z());
    }

    @Override // net.time4j.engine.i0
    public int compareTo(Object object) {
        return P((m)object);
    }

    @Override // net.time4j.engine.i0
    public boolean equals(Object object) {
        int i;
        long cls;
        long l;
        int obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object == null) {
            return i2;
        }
        if (object instanceof m) {
            if (J().l() == (m)object.J().l() && Long.compare(cls, l) == 0) {
                if (Long.compare(cls, l) == 0) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.engine.i0
    public int hashCode() {
        long l = c();
        return (int)i;
    }
}

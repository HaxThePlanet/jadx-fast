package net.time4j.engine;

import net.time4j.f1.c;

/* compiled from: Calendrical.java */
/* loaded from: classes3.dex */
public abstract class m<U, D extends m<U, D>> extends i0<U, D> implements g {
    private k<D> Q() {
        return J().j();
    }

    private <T> T U(k<T> kVar, String str) {
        long l = c();
        long l2 = kVar.d();
        if (l2 > l) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str3 = "Cannot transform <";
            str = "> to: ";
            str = str3 + l + str + str;
            throw new ArithmeticException(str);
        } else {
            long l3 = kVar.c();
            if (l3 >= l) {
                return kVar.a(l);
            }
        }
    }

    @Override // net.time4j.engine.i0
    protected int O(g gVar) {
        int i = -1;
        final long l = c();
        final long l2 = gVar.c();
        if (l < l2) {
            i = -1;
        } else {
            gVar = l == l2 ? 0 : 1;
        }
        return (l == l2 ? 0 : 1);
    }

    @Override // net.time4j.engine.i0
    public int P(D d) {
        if (J().l() != d.J().l()) {
            throw new ClassCastException("Cannot compare different types of dates, use instance of EpochDays as comparator instead.");
        } else {
            return O(d);
        }
    }

    @Override // net.time4j.engine.i0
    public boolean R(g gVar) {
        boolean z = true;
        gVar = O(gVar) > 0 ? 1 : 0;
        return (O(gVar) > 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    public boolean S(g gVar) {
        boolean z = true;
        gVar = O(gVar) < 0 ? 1 : 0;
        return (O(gVar) < 0 ? 1 : 0);
    }

    @Override // net.time4j.engine.i0
    public D T(h hVar) {
        try {
        } catch (java.lang.IllegalArgumentException iae) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Out of range: ");
            stringBuilder.append(str);
            long str = stringBuilder.toString();
            java.lang.ArithmeticException arithmeticException = new ArithmeticException(str);
            arithmeticException.initCause(iae);
            throw arithmeticException;
        }
        return (m)Q().a(c.f(c(), hVar.c()));
    }

    @Override // net.time4j.engine.i0
    public <T extends l<T>> T V(Class<T> cls, String str) {
        final String name = cls.getName();
        net.time4j.engine.w wVar = w.y(cls);
        if (wVar == null) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "Cannot find any chronology for given target type: ";
            str = str + name;
            throw new IllegalArgumentException(str);
        } else {
            return (l)U(wVar.k(str), name);
        }
    }

    @Override // net.time4j.engine.i0
    public <T extends m<?, T>> T W(Class<T> cls) {
        String name = cls.getName();
        net.time4j.engine.w wVar = w.y(cls);
        if (wVar == null) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cannot find any chronology for given target type: ";
            r0 = str + name;
            throw new IllegalArgumentException(r0);
        } else {
            return (m)U(wVar.j(), name);
        }
    }

    @Override // net.time4j.engine.i0
    public long c() {
        return Q().b(z());
    }

    @Override // net.time4j.engine.i0
    public boolean equals(Object object) {
        boolean z = true;
        Class cls;
        long l2;
        int cmp;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object == null) {
            return false;
        }
        if (object instanceof m) {
            if (J().l() == object.J().l()) {
                long l = c();
                l2 = object.c();
                if (l != l2) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.engine.i0
    public int hashCode() {
        long l = c();
        return (int)(l ^ (l >>> 32L));
    }
}

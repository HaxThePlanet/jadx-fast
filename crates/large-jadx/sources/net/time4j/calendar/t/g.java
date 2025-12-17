package net.time4j.calendar.t;

import net.time4j.engine.o;
import net.time4j.x0;
import net.time4j.z0;

/* loaded from: classes3.dex */
public class g<T extends net.time4j.engine.q<T>>  extends net.time4j.calendar.t.e<x0, T> {

    private static final long serialVersionUID = -84764920511581480L;
    private final transient z0 w;
    public g(Class<T> class, z0 z02) {
        super("DAY_OF_WEEK", class, x0.class, 69);
        this.w = z02;
    }

    @Override // net.time4j.calendar.t.e
    public int A(Enum enum) {
        return F((x0)enum);
    }

    @Override // net.time4j.calendar.t.e
    public x0 D() {
        return this.w.f().roll(6);
    }

    @Override // net.time4j.calendar.t.e
    public x0 E() {
        return this.w.f();
    }

    @Override // net.time4j.calendar.t.e
    public int F(x0 x0) {
        return x0.getValue(this.w);
    }

    @Override // net.time4j.calendar.t.e
    public int b(o o, o o2) {
        int obj2;
        obj2 = (x0)o.p(this).getValue(this.w);
        int obj3 = (x0)o2.p(this).getValue(this.w);
        obj2 = obj2 < obj3 ? -1 : obj2 == obj3 ? 0 : 1;
        return obj2;
    }

    @Override // net.time4j.calendar.t.e
    public Object getDefaultMaximum() {
        return D();
    }

    @Override // net.time4j.calendar.t.e
    public Object getDefaultMinimum() {
        return E();
    }

    @Override // net.time4j.calendar.t.e
    public Enum r() {
        return D();
    }

    @Override // net.time4j.calendar.t.e
    public Enum u() {
        return E();
    }
}

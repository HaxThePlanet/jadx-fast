package net.time4j.calendar.t;

import net.time4j.engine.o;
import net.time4j.engine.q;
import net.time4j.x0;
import net.time4j.z0;

/* compiled from: StdWeekdayElement.java */
/* loaded from: classes3.dex */
public class g<T extends q<T>> extends e<x0, T> {

    private static final long serialVersionUID = -84764920511581480L;
    private final transient z0 w;
    public g(Class<T> cls, z0 z0Var) {
        super("DAY_OF_WEEK", cls, x0.class, 'E');
        this.w = z0Var;
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
    public int F(x0 x0Var) {
        return x0Var.getValue(this.w);
    }

    @Override // net.time4j.calendar.t.e
    public int b(o oVar, o oVar2) {
        int i = -1;
        int value = (x0)oVar.p(this).getValue(this.w);
        int value2 = (x0)oVar2.p(this).getValue(this.w);
        if (value < value2) {
            i = -1;
        } else {
            oVar = value == value2 ? 0 : 1;
        }
        return (value == value2 ? 0 : 1);
    }
}

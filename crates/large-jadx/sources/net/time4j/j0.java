package net.time4j;

import java.util.concurrent.TimeUnit;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
class j0<U extends Comparable<U>>  implements p<U> {

    static final p<net.time4j.h> v;
    static final p<TimeUnit> w;
    private final Class<U> a;
    private final transient U b;
    private final transient U c;
    static {
        j0 j0Var = new j0(h.class, h.HOURS, h.NANOS);
        j0.v = j0Var;
        j0 j0Var2 = new j0(TimeUnit.class, TimeUnit.DAYS, TimeUnit.NANOSECONDS);
        j0.w = j0Var2;
    }

    private j0(Class<U> class, U u2, U u3) {
        super();
        this.a = class;
        this.b = u2;
        this.c = u3;
    }

    @Override // net.time4j.engine.p
    public int a(o o, o o2) {
        Object obj3 = o.p(this);
        final Object obj4 = o2.p(this);
        if (this.a == h.class) {
            return (Comparable)obj3.compareTo((Comparable)obj4);
        }
        return obj4.compareTo(obj3);
    }

    public U b() {
        return this.c;
    }

    public U c() {
        return this.b;
    }

    @Override // net.time4j.engine.p
    public int compare(Object object, Object object2) {
        return a((o)object, (o)object2);
    }

    @Override // net.time4j.engine.p
    public Object getDefaultMaximum() {
        return b();
    }

    @Override // net.time4j.engine.p
    public Object getDefaultMinimum() {
        return c();
    }

    @Override // net.time4j.engine.p
    public char getSymbol() {
        return 0;
    }

    public Class<U> getType() {
        return this.a;
    }

    @Override // net.time4j.engine.p
    public boolean isDateElement() {
        return 0;
    }

    @Override // net.time4j.engine.p
    public boolean isLenient() {
        return 0;
    }

    @Override // net.time4j.engine.p
    public boolean isTimeElement() {
        return 1;
    }

    @Override // net.time4j.engine.p
    public String name() {
        return "PRECISION";
    }
}

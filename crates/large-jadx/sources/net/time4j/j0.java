package net.time4j;

import java.util.concurrent.TimeUnit;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* compiled from: PrecisionElement.java */
/* loaded from: classes3.dex */
class j0<U extends Comparable<U>> implements p<U> {

    static final p<h> v = new j0<>();
    static final p<TimeUnit> w = new j0<>();
    private final Class<U> a;
    private final transient U b;
    private final transient U c;
    static {
    }

    private j0(Class<U> cls, U u, U u2) {
        super();
        this.a = cls;
        this.b = u;
        this.c = u2;
    }

    public int a(o oVar, o oVar2) {
        Object obj2 = oVar.p(this);
        final Object obj3 = oVar2.p(this);
        if (this.a == h.class) {
            return obj2.compareTo(obj3);
        }
        return obj3.compareTo(obj2);
    }

    public U b() {
        return this.c;
    }

    public U c() {
        return this.b;
    }

    public Class<U> getType() {
        return this.a;
    }

    public char getSymbol() {
        return 0;
    }

    public boolean isDateElement() {
        return false;
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isTimeElement() {
        return true;
    }

    public String name() {
        return "PRECISION";
    }
}

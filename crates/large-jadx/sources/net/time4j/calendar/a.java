package net.time4j.calendar;

import java.util.Locale;
import net.time4j.calendar.t.a;
import net.time4j.engine.d;
import net.time4j.engine.d0;
import net.time4j.engine.o;
import net.time4j.engine.t;
import net.time4j.engine.w;
import net.time4j.engine.x;

/* loaded from: classes3.dex */
abstract class a<C extends net.time4j.calendar.f<?, C>>  implements t<C> {
    a(Class<C> class) {
        super();
    }

    @Override // net.time4j.engine.t
    public d0 a() {
        return d0.a;
    }

    public w<?> b() {
        return 0;
    }

    @Override // net.time4j.engine.t
    public int d() {
        return 100;
    }

    @Override // net.time4j.engine.t
    public o e(Object object, d d2) {
        g((f)object, d2);
        return object;
    }

    @Override // net.time4j.engine.t
    public String f(x x, Locale locale2) {
        return a.a("chinese", x, locale2);
    }

    public o g(C c, d d2) {
        return c;
    }
}

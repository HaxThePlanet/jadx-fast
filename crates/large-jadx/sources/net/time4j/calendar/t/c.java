package net.time4j.calendar.t;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import net.time4j.calendar.KoreanCalendar;
import net.time4j.engine.d;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.r;
import net.time4j.g0;

/* loaded from: classes3.dex */
public class c implements r {
    public boolean a(p<?> p) {
        int obj2;
        obj2 = p == KoreanCalendar.B ? 1 : 0;
        return obj2;
    }

    public q<?> b(q<?> q, Locale locale2, d d3) {
        q obj1;
        p obj2;
        boolean obj3;
        obj2 = KoreanCalendar.B;
        if (q.v(obj2)) {
            obj1 = q.E(g0.H, obj2 += -2333);
        }
        return obj1;
    }

    public Set<p<?>> c(Locale locale, d d2) {
        return Collections.emptySet();
    }

    public boolean d(Class<?> class) {
        int obj2;
        obj2 = class == g0.class ? 1 : 0;
        return obj2;
    }
}

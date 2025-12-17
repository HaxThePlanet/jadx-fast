package net.time4j;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.r;

/* loaded from: classes3.dex */
class v0 implements r {
    public boolean a(p<?> p) {
        return 0;
    }

    public q<?> b(q<?> q, Locale locale2, d d3) {
        return q;
    }

    public Set<p<?>> c(Locale locale, d d2) {
        if (locale.getCountry().isEmpty()) {
            return Collections.emptySet();
        }
        return z0.j(locale).d();
    }

    public boolean d(Class<?> class) {
        return 0;
    }
}

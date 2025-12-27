package net.time4j;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.r;

/* compiled from: WeekExtension.java */
/* loaded from: classes3.dex */
class v0 implements r {
    v0() {
        super();
    }

    public Set<p<?>> c(Locale locale, d dVar) {
        if (locale.getCountry().isEmpty()) {
            return Collections.emptySet();
        }
        return z0.j(locale).d();
    }

    public boolean a(p<?> pVar) {
        return false;
    }

    public q<?> b(q<?> qVar, Locale locale, d dVar) {
        return qVar;
    }

    public boolean d(Class<?> cls) {
        return false;
    }
}

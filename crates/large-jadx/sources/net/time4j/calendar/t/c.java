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

/* compiled from: KoreanExtension.java */
/* loaded from: classes3.dex */
public class c implements r {
    public boolean a(p<?> pVar) {
        boolean z = true;
        pVar = pVar == KoreanCalendar.B ? 1 : 0;
        return (pVar == KoreanCalendar.B ? 1 : 0);
    }

    public q<?> b(q<?> qVar, Locale locale, d dVar) {
        q qVar2;
        pVar = KoreanCalendar.B;
        if (qVar.v(pVar)) {
            qVar2 = qVar.E(g0.H, qVar.e(KoreanCalendar.B) - 2333);
        }
        return qVar2;
    }

    public Set<p<?>> c(Locale locale, d dVar) {
        return Collections.emptySet();
    }

    public boolean d(Class<?> cls) {
        boolean z = true;
        cls = cls == g0.class ? 1 : 0;
        return (cls == g0.class ? 1 : 0);
    }
}

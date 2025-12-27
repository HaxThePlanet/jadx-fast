package net.time4j.calendar;

import java.util.Locale;
import net.time4j.calendar.t.a;
import net.time4j.engine.d;
import net.time4j.engine.d0;
import net.time4j.engine.o;
import net.time4j.engine.t;
import net.time4j.engine.w;
import net.time4j.engine.x;

/* compiled from: AbstractMergerEA.java */
/* loaded from: classes3.dex */
abstract class a<C extends f<?, C>> implements t<C> {
    a(Class<C> cls) {
        super();
    }

    public d0 a() {
        return d0.a;
    }

    public String f(x xVar, Locale locale) {
        return a.a("chinese", xVar, locale);
    }

    public w<?> b() {
        return null;
    }

    public int d() {
        return 100;
    }

    public o g(C c, d dVar) {
        return c;
    }
}

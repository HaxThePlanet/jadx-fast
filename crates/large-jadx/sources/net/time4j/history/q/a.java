package net.time4j.history.q;

import net.time4j.engine.c;
import net.time4j.g1.a;
import net.time4j.history.d;

/* loaded from: classes3.dex */
public final class a {

    public static final c<d> a;
    public static final c<Boolean> b;
    public static final c<Boolean> c;
    static {
        Class<Boolean> obj = Boolean.class;
        a.a = a.e("CALENDAR_HISTORY", d.class);
        a.b = a.e("COMMON_ERA", obj);
        a.c = a.e("LATIN_ERA", obj);
    }
}

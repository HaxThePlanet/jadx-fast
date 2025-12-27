package net.time4j;

import java.util.Comparator;
import net.time4j.engine.c0;
import net.time4j.engine.j0.a;
import net.time4j.engine.v;

/* compiled from: StdNormalizer.java */
/* loaded from: classes3.dex */
class o0<U extends x> implements c0<U>, Comparator<j0.a<? extends v>> {
    private o0(boolean z) {
        super();
    }

    static Comparator<j0.a<? extends v>> a() {
        return new o0(false);
    }

    static int b(v vVar, v vVar2) {
        int compare = Double.compare(vVar2.getLength(), vVar.getLength());
        return compare;
    }

    static o0<f> d() {
        return new o0(false);
    }

    static o0<h> e() {
        return new o0(false);
    }

    static o0<x> f() {
        return new o0(true);
    }

    public int c(j0.a<? extends v> aVar, j0.a<? extends v> aVar2) {
        return o0.b((v)aVar.b(), (v)aVar2.b());
    }
}

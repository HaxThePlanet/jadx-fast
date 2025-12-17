package kotlin.d0.d;

import kotlin.i0.d;
import kotlin.i0.f;
import kotlin.i0.g;
import kotlin.i0.i;
import kotlin.i0.j;
import kotlin.i0.n;

/* loaded from: classes3.dex */
public class d0 {
    public g a(kotlin.d0.d.j j) {
        return j;
    }

    public d b(Class class) {
        e eVar = new e(class);
        return eVar;
    }

    public f c(Class class, String string2) {
        v vVar = new v(class, string2);
        return vVar;
    }

    public i d(kotlin.d0.d.q q) {
        return q;
    }

    public j e(kotlin.d0.d.s s) {
        return s;
    }

    public n f(kotlin.d0.d.w w) {
        return w;
    }

    public String g(kotlin.d0.d.i i) {
        boolean startsWith;
        String obj2;
        obj2 = i.getClass().getGenericInterfaces()[0].toString();
        if (obj2.startsWith("kotlin.jvm.functions.")) {
            obj2 = obj2.substring(21);
        }
        return obj2;
    }

    public String h(kotlin.d0.d.p p) {
        return g(p);
    }
}

package kotlin.i0.z.e.m0.d.a.i0;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class p {
    private static final boolean a(kotlin.i0.z.e.m0.d.a.i0.r r) {
        int i;
        kotlin.i0.z.e.m0.d.a.i0.i iVar;
        boolean str;
        kotlin.i0.z.e.m0.d.a.i0.x obj2;
        obj2 = p.B0(r.h());
        if ((a0)obj2 == null) {
            obj2 = i;
        } else {
            obj2 = (a0)obj2.getType();
        }
        if (obj2 instanceof j) {
            i = obj2;
        }
        if (i == 0) {
            return 0;
        }
        iVar = i.c();
        iVar = (g)iVar.d();
        if (iVar instanceof g && iVar != null && n.b(iVar.b(), "java.lang.Object")) {
            iVar = (g)iVar.d();
            if (iVar != null) {
                if (n.b(iVar.b(), "java.lang.Object")) {
                    obj2 = 1;
                }
            }
        }
        return obj2;
    }

    private static final boolean b(kotlin.i0.z.e.m0.d.a.i0.r r) {
        boolean equals;
        String str;
        int i;
        boolean obj3;
        equals = r.getName().c();
        str = equals.hashCode();
        if (str != -1776922004) {
            if (str != -1295482945) {
                if (str != 147696667) {
                    obj3 = 0;
                } else {
                    if (!equals.equals("hashCode")) {
                    } else {
                        obj3 = r.h().isEmpty();
                    }
                }
            } else {
                if (!equals.equals("equals")) {
                } else {
                    obj3 = p.a(r);
                }
            }
        } else {
            if (!equals.equals("toString")) {
            } else {
            }
        }
        return obj3;
    }

    public static final boolean c(kotlin.i0.z.e.m0.d.a.i0.q q) {
        boolean z;
        int obj1;
        n.f(q, "<this>");
        if (q.P().H() && q instanceof r && p.b((r)q)) {
            if (q instanceof r) {
                obj1 = p.b((r)q) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }
}

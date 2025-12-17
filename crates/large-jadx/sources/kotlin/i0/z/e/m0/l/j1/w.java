package kotlin.i0.z.e.m0.l.j1;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.h.c;
import kotlin.i0.z.e.m0.i.p.a.d;
import kotlin.i0.z.e.m0.l.a1;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.i0.z.e.m0.l.n1.a;
import kotlin.i0.z.e.m0.l.n1.b;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.u0;
import kotlin.i0.z.e.m0.l.u0.a;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.i0.z.e.m0.l.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* loaded from: classes3.dex */
public final class w {
    private static final b0 a(b0 b0) {
        return (b0)b.a(b0).d();
    }

    private static final String b(t0 t0) {
        String str;
        String str2;
        kotlin.reflect.jvm.internal.impl.descriptors.h obj4;
        StringBuilder stringBuilder = new StringBuilder();
        w.c(n.o("type: ", t0), stringBuilder);
        w.c(n.o("hashCode: ", Integer.valueOf(t0.hashCode())), stringBuilder);
        String str10 = "javaClass: ";
        w.c(n.o(str10, t0.getClass().getCanonicalName()), stringBuilder);
        obj4 = t0.c();
        while (obj4 != null) {
            w.c(n.o("fqName: ", c.b.r(obj4)), stringBuilder);
            w.c(n.o(str10, obj4.getClass().getCanonicalName()), stringBuilder);
            obj4 = obj4.b();
        }
        obj4 = stringBuilder.toString();
        n.e(obj4, "StringBuilder().apply(builderAction).toString()");
        return obj4;
    }

    private static final StringBuilder c(String string, StringBuilder stringBuilder2) {
        n.f(string, "<this>");
        n.f(stringBuilder2, "$this_anonymous");
        stringBuilder2.append(string);
        n.e(stringBuilder2, "append(value)");
        stringBuilder2.append('\n');
        n.e(stringBuilder2, "append('\\n')");
        return stringBuilder2;
    }

    public static final b0 d(b0 b0, b0 b02, kotlin.i0.z.e.m0.l.j1.u u3) {
        boolean z;
        kotlin.i0.z.e.m0.l.j1.r rVar2;
        b0 b0Var;
        boolean next2;
        t0 next;
        boolean rVar;
        int i2;
        java.util.List iterator;
        String iNVARIANT2;
        boolean empty;
        int i3;
        int i;
        h1 iNVARIANT;
        Object obj10;
        n.f(b0, "subtype");
        n.f(b02, "supertype");
        n.f(u3, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        int i4 = 0;
        rVar2 = new r(b0, i4);
        arrayDeque.add(rVar2);
        t0 obj9 = b02.L0();
        while (!arrayDeque.isEmpty()) {
            obj10 = arrayDeque.poll();
            b0Var = (r)obj10.b();
            next = b0Var.L0();
            if (u3.a(next, obj9)) {
                break;
            } else {
            }
            rVar2 = next.a().iterator();
            for (b0 next : rVar2) {
                n.e(next, "immediateSupertype");
                rVar = new r(next, obj10);
                arrayDeque.add(rVar);
            }
            next = rVar2.next();
            n.e((b0)next, "immediateSupertype");
            rVar = new r(next, obj10);
            arrayDeque.add(rVar);
        }
        return i4;
    }
}

package io.grpc.k1;

import com.google.common.base.n;
import io.grpc.j0;
import io.grpc.j1.m2;
import io.grpc.j1.r0;
import io.grpc.k1.r.j.d;
import io.grpc.t0;
import io.grpc.t0.f;
import java.util.ArrayList;
import java.util.List;
import l.i;

/* compiled from: Headers.java */
/* loaded from: classes3.dex */
class c {

    public static final d a = new d();
    public static final d b = new d();
    public static final d c = new d();
    public static final d d = new d();
    public static final d e = new d();
    public static final d f = new d("te", "trailers");
    static {
    }

    public static List<d> a(t0 t0Var, String str, String str2, String str3, boolean z, boolean z2) {
        int i = 0;
        i iVar;
        n.p(t0Var, "headers");
        n.p(str, "defaultPath");
        n.p(str2, "authority");
        t0Var.d(r0.g);
        t0Var.d(r0.h);
        t0.f fVar3 = r0.i;
        t0Var.d(fVar3);
        final ArrayList arrayList = new ArrayList(j0.a(t0Var) + 7);
        if (z2) {
            arrayList.add(c.b);
        } else {
            arrayList.add(c.a);
        }
        if (z) {
            arrayList.add(c.d);
        } else {
            arrayList.add(c.c);
        }
        arrayList.add(new d(d.h, str2));
        arrayList.add(new d(d.f, str));
        arrayList.add(new d(r0.i.d(), str3));
        arrayList.add(c.e);
        arrayList.add(c.f);
        final byte[][] arr = m2.d(t0Var);
        i = 0;
        while (c.e < arr.length) {
            Object obj = i.f(arr[i]);
            i = i + 2;
        }
        return arrayList;
    }

    private static boolean b(String str) {
        boolean equalsIgnoreCase;
        boolean z = true;
        if (!str.startsWith(":")) {
            if (!r0.g.d().equalsIgnoreCase(str)) {
                str = !r0.i.d().equalsIgnoreCase(str) ? 1 : 0;
            }
        }
        return (!r0.i.d().equalsIgnoreCase(str) ? 1 : 0);
    }
}

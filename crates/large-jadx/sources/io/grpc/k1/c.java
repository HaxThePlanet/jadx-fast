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

/* loaded from: classes3.dex */
class c {

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    static {
        i iVar = d.g;
        d dVar = new d(iVar, "https");
        c.a = dVar;
        d dVar2 = new d(iVar, "http");
        c.b = dVar2;
        i iVar2 = d.e;
        d dVar3 = new d(iVar2, "POST");
        c.c = dVar3;
        d dVar4 = new d(iVar2, "GET");
        c.d = dVar4;
        d dVar5 = new d(r0.g.d(), "application/grpc");
        c.e = dVar5;
        d dVar6 = new d("te", "trailers");
        c.f = dVar6;
    }

    public static List<d> a(t0 t0, String string2, String string3, String string4, boolean z5, boolean z6) {
        int obj4;
        String obj5;
        String obj6;
        d obj7;
        d obj8;
        n.p(t0, "headers");
        n.p(string2, "defaultPath");
        n.p(string3, "authority");
        t0.d(r0.g);
        t0.d(r0.h);
        t0.f fVar3 = r0.i;
        t0.d(fVar3);
        ArrayList arrayList = new ArrayList(i += 7);
        if (z6) {
            arrayList.add(c.b);
        } else {
            arrayList.add(c.a);
        }
        if (z5) {
            arrayList.add(c.d);
        } else {
            arrayList.add(c.c);
        }
        obj7 = new d(d.h, string3);
        arrayList.add(obj7);
        obj5 = new d(d.f, string2);
        arrayList.add(obj5);
        obj4 = new d(fVar3.d(), string4);
        arrayList.add(obj4);
        arrayList.add(c.e);
        arrayList.add(c.f);
        final byte[][] obj3 = m2.d(t0);
        obj4 = 0;
        while (obj4 < obj3.length) {
            obj5 = i.t(obj3[obj4]);
            if (c.b(obj5.E())) {
            }
            obj4 += 2;
            obj7 = new d(obj5, i.t(obj3[obj4 + 1]));
            arrayList.add(obj7);
        }
        return arrayList;
    }

    private static boolean b(String string) {
        String equalsIgnoreCase;
        int obj1;
        if (!string.startsWith(":") && !r0.g.d().equalsIgnoreCase(string) && !r0.i.d().equalsIgnoreCase(string)) {
            if (!r0.g.d().equalsIgnoreCase(string)) {
                obj1 = !r0.i.d().equalsIgnoreCase(string) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }
}

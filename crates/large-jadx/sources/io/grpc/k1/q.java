package io.grpc.k1;

import io.grpc.j0;
import io.grpc.j1.m2;
import io.grpc.k1.r.j.d;
import io.grpc.t0;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import l.i;

/* compiled from: Utils.java */
/* loaded from: classes3.dex */
class q {
    static {
        Logger.getLogger(q.class.getName());
    }

    private q() {
        super();
    }

    public static t0 a(List<d> list) {
        return j0.c(q.b(list));
    }

    private static byte[][] b(List<d> list) {
        int i = 0;
        byte[][] bArr3 = new byte[list.size() * 2];
        Iterator it = list.iterator();
        i = 0;
        while (it.hasNext()) {
            Object item = it.next();
            i2 = i + 1;
            bArr3[i] = item.a.D();
            i = i2 + 1;
            bArr3[i2] = item.b.D();
        }
        return m2.e(bArr3);
    }

    public static t0 c(List<d> list) {
        return j0.c(q.b(list));
    }
}

package io.grpc.k1;

import io.grpc.j0;
import io.grpc.j1.m2;
import io.grpc.k1.r.j.d;
import io.grpc.t0;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import l.i;

/* loaded from: classes3.dex */
class q {
    static {
        Logger.getLogger(q.class.getName());
    }

    public static t0 a(List<d> list) {
        return j0.c(q.b(list));
    }

    private static byte[][] b(List<d> list) {
        int i2;
        byte[] bArr2;
        int i;
        byte[] bArr;
        byte[][] bArr3 = new byte[size *= 2];
        Iterator obj5 = list.iterator();
        i2 = 0;
        for (d next2 : obj5) {
            i = i2 + 1;
            bArr3[i2] = next2.a.D();
            i2 = i + 1;
            bArr3[i] = next2.b.D();
        }
        return m2.e(bArr3);
    }

    public static t0 c(List<d> list) {
        return j0.c(q.b(list));
    }
}

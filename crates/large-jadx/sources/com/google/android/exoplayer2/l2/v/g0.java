package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.c;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.util.List;

/* loaded from: classes2.dex */
final class g0 {

    private final List<i1> a;
    private final s[] b;
    public g0(List<i1> list) {
        super();
        this.a = list;
        this.b = new s[list.size()];
    }

    public void a(long l, d0 d02) {
        int i;
        if (obj7.a() < 9) {
        }
        if (obj7.n() == 434 && obj7.n() == 1195456820 && obj7.x() == 3) {
            if (obj7.n() == 1195456820) {
                if (obj7.x() == 3) {
                    c.b(l, d02, obj7);
                }
            }
        }
    }

    public void b(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        int i3;
        s sVar;
        s[] objArr;
        int i;
        i1.b bVar;
        int i2;
        boolean equals;
        String str;
        String concat;
        String valueOf;
        int length;
        final int i4 = 0;
        i3 = i4;
        while (i3 < objArr2.length) {
            d2.a();
            sVar = k.t(d2.c(), 3);
            Object obj = this.a.get(i3);
            String str2 = obj.D;
            if (!"application/cea-608".equals(str2)) {
            } else {
            }
            i2 = 1;
            String str6 = "Invalid closed caption mime type provided: ";
            valueOf = String.valueOf(str2);
            if (valueOf.length() != 0) {
            } else {
            }
            valueOf = new String(str6);
            concat = valueOf;
            g.b(i2, concat);
            bVar = new i1.b();
            bVar.S(d2.b());
            bVar.e0(str2);
            bVar.g0(obj.v);
            bVar.V(obj.c);
            bVar.F(obj.V);
            bVar.T(obj.F);
            sVar.e(bVar.E());
            this.b[i3] = sVar;
            i3++;
            concat = str6.concat(valueOf);
            if ("application/cea-708".equals(str2)) {
            } else {
            }
            i2 = i4;
        }
    }
}

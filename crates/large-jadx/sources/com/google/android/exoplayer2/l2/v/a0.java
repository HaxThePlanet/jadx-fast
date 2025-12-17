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
public final class a0 {

    private final List<i1> a;
    private final s[] b;
    public a0(List<i1> list) {
        super();
        this.a = list;
        this.b = new s[list.size()];
    }

    public void a(long l, d0 d02) {
        c.a(l, d02, obj4);
    }

    public void b(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        int i;
        s sVar;
        s[] objArr;
        int i2;
        String str;
        boolean equals;
        int i3;
        i1.b bVar;
        String concat;
        String valueOf;
        int length;
        final int i4 = 0;
        i = i4;
        while (i < objArr2.length) {
            d2.a();
            sVar = k.t(d2.c(), 3);
            Object obj = this.a.get(i);
            String str2 = obj.D;
            if (!"application/cea-608".equals(str2)) {
            } else {
            }
            i3 = 1;
            String str6 = "Invalid closed caption mime type provided: ";
            valueOf = String.valueOf(str2);
            if (valueOf.length() != 0) {
            } else {
            }
            valueOf = new String(str6);
            concat = valueOf;
            g.b(i3, concat);
            if (obj.a != null) {
            } else {
            }
            str = d2.b();
            bVar = new i1.b();
            bVar.S(str);
            bVar.e0(str2);
            bVar.g0(obj.v);
            bVar.V(obj.c);
            bVar.F(obj.V);
            bVar.T(obj.F);
            sVar.e(bVar.E());
            this.b[i] = sVar;
            i++;
            concat = str6.concat(valueOf);
            if ("application/cea-708".equals(str2)) {
            } else {
            }
            i3 = i4;
        }
    }
}

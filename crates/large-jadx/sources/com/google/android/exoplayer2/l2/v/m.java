package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.d0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class m implements com.google.android.exoplayer2.l2.v.n {

    private final List<com.google.android.exoplayer2.l2.v.e0.a> a;
    private final s[] b;
    private boolean c;
    private int d;
    private int e;
    private long f = -9223372036854775807L;
    public m(List<com.google.android.exoplayer2.l2.v.e0.a> list) {
        super();
        this.a = list;
        this.b = new s[list.size()];
        final long l = -9223372036854775807L;
    }

    private boolean a(d0 d0, int i2) {
        final int i3 = 0;
        if (d0.a() == 0) {
            return i3;
        }
        if (d0.x() != i2) {
            this.c = i3;
        }
        this.d = obj3--;
        return this.c;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        boolean z;
        int i2;
        int i4;
        int i;
        int i3;
        s[] objArr;
        int length;
        s sVar;
        d0 obj7;
        if (this.c && this.d == 2 && !a(d0, 32)) {
            if (this.d == 2) {
                if (!a(d0, 32)) {
                }
            }
            if (this.d == 1 && !a(d0, 0)) {
                if (!a(d0, i)) {
                }
            }
            i3 = d0.a();
            objArr = this.b;
            while (i < objArr.length) {
                d0.I(d0.e());
                objArr[i].c(d0, i3);
                i++;
            }
            this.e = obj7 += i3;
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        this.c = false;
        this.f = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
        int cmp;
        int i4;
        long length;
        int i2;
        s sVar;
        long l;
        int i3;
        int i5;
        int i6;
        int i;
        i4 = 0;
        if (this.c && Long.compare(l2, length) != 0) {
            i4 = 0;
            if (Long.compare(l2, length) != 0) {
                cmp = this.b;
                i2 = i4;
                while (i2 < cmp.length) {
                    cmp[i2].d(this.f, obj6, 1, this.e, 0);
                    i2++;
                }
            }
            this.c = i4;
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        int i;
        s[] objArr;
        s sVar;
        i1.b bVar;
        List singletonList;
        i = 0;
        while (i < objArr2.length) {
            Object obj = this.a.get(i);
            d2.a();
            sVar = k.t(d2.c(), 3);
            bVar = new i1.b();
            bVar.S(d2.b());
            bVar.e0("application/dvbsubs");
            bVar.T(Collections.singletonList(obj.b));
            bVar.V(obj.a);
            sVar.e(bVar.E());
            this.b[i] = sVar;
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        if (obj5 &= 4 == 0) {
        }
        this.c = true;
        if (Long.compare(l, l2) != 0) {
            this.f = l;
        }
        this.e = 0;
        this.d = 2;
    }
}

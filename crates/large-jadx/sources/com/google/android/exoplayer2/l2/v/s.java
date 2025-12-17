package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.s;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
public final class s implements com.google.android.exoplayer2.l2.v.n {

    private final d0 a;
    private s b;
    private boolean c;
    private long d = -9223372036854775807L;
    private int e;
    private int f;
    public s() {
        super();
        d0 d0Var = new d0(10);
        this.a = d0Var;
        long l = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void b(d0 d0) {
        int i2;
        int i;
        int i5;
        int i3;
        byte[] bArr;
        int i4;
        g.h(this.b);
        if (!this.c) {
        }
        int i6 = d0.a();
        i = this.f;
        int i12 = 10;
        i = Math.min(i6, i - 10);
        System.arraycopy(d0.d(), d0.e(), this.a.d(), this.f, i);
        int i15 = 0;
        this.a.I(i15);
        if (i < i12 && i14 += i == i12 && 73 == this.a.x() && 68 == this.a.x() && 51 != this.a.x()) {
            i = Math.min(i6, i - 10);
            System.arraycopy(d0.d(), d0.e(), this.a.d(), this.f, i);
            if (i14 += i == i12) {
                i15 = 0;
                this.a.I(i15);
                if (73 == this.a.x()) {
                    if (68 == this.a.x()) {
                        if (51 != this.a.x()) {
                        }
                        this.a.J(3);
                        this.e = i9 += i12;
                    }
                }
                v.h("Id3Reader", "Discarding invalid ID3 tag");
                this.c = i15;
            }
        }
        int i7 = Math.min(i6, i10 -= i13);
        this.b.c(d0, i7);
        this.f = obj8 += i7;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void c() {
        this.c = false;
        this.d = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void d() {
        boolean z;
        s sVar;
        long l;
        int i4;
        int i;
        int i3;
        int i2;
        g.h(this.b);
        i = this.e;
        if (this.c && i != 0) {
            i = this.e;
            if (i != 0) {
                if (this.f != i) {
                } else {
                    l = this.d;
                    if (Long.compare(l, l2) != 0) {
                        this.b.d(l, obj3, 1, i, 0);
                    }
                    this.c = false;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void e(k k, com.google.android.exoplayer2.l2.v.e0.d e0$d2) {
        d2.a();
        final s obj3 = k.t(d2.c(), 5);
        this.b = obj3;
        i1.b bVar = new i1.b();
        bVar.S(d2.b());
        bVar.e0("application/id3");
        obj3.e(bVar.E());
    }

    @Override // com.google.android.exoplayer2.l2.v.n
    public void f(long l, int i2) {
        if (obj5 &= 4 == 0) {
        }
        this.c = true;
        if (Long.compare(l, l2) != 0) {
            this.d = l;
        }
        final int obj3 = 0;
        this.e = obj3;
        this.f = obj3;
    }
}

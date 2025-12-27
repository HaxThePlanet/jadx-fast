package l;

import java.util.Arrays;
import kotlin.d0.d.n;
import kotlin.y.i;

/* compiled from: Segment.kt */
/* loaded from: classes3.dex */
public final class y {

    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public y f;
    public y g;
    public y() {
        super();
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final void a() {
        int i = 0;
        i = 0;
        int r2 = this.g != this ? 1 : 0;
        if (i == 0) {
            throw new IllegalStateException("cannot compact".toString());
        } else {
            n.d(this.g);
            if (!yVar.e) {
                return;
            }
            int i3 = this.c - this.b;
            n.d(this.g);
            n.d(this.g);
            if (!(yVar5.d)) {
                n.d(this.g);
            }
            if (yVar.e > (yVar4.c - 8192) + i) {
                return;
            }
            n.d(this.g);
            g(this.g, i3);
            b();
            z.b(this);
            return;
        }
    }

    public final y b() {
        l.y yVar;
        final l.y yVar2 = null;
        if (this.f == this) {
            int i = yVar2;
        }
        n.d(this.g);
        this.g.f = this.f;
        n.d(this.f);
        this.f.g = this.g;
        this.f = yVar2;
        this.g = yVar2;
        return yVar;
    }

    public final y c(y yVar) {
        n.f(yVar, "segment");
        yVar.g = this;
        yVar.f = this.f;
        n.d(this.f);
        this.f.g = yVar;
        this.f = yVar;
        return yVar;
    }

    public final y d() {
        this.d = true;
        y yVar = new y(this.a, this.b, this.c, true, false);
        return yVar;
    }

    public final y e(int i) {
        int i3 = 0;
        l.y yVar;
        int i4;
        if (i > 0) {
            i2 = this.c - this.b;
            int r0 = i <= this.c - this.b ? 1 : 0;
        }
        if (this.c - this.b == 0) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        } else {
            if (i >= 1024) {
                yVar = d();
            } else {
                int i5 = 0;
                i7 = i6 + i;
                int i8 = 2;
                Object obj = null;
                l.g(this.a, z.c().a, i5, this.b, i7, i8, obj);
            }
            yVar.c = yVar.b + i;
            this.b += i;
            n.d(this.g);
            this.g.c(yVar);
            return yVar;
        }
    }

    public final y f() {
        byte[] copy = Arrays.copyOf(this.a, bArr.length);
        n.e(copy, "java.util.Arrays.copyOf(this, size)");
        y yVar = new y(copy, this.b, this.c, false, true);
        return yVar;
    }

    public final void g(y yVar, int i) {
        n.f(yVar, "sink");
        if (!yVar.e) {
            throw new IllegalStateException("only owner can write".toString());
        } else {
            i = i16 + i;
            int i3 = 8192;
            if (i16 + i > i3 && !yVar.d) {
                if ((i16 + i) - i5 > i3) {
                    throw new IllegalArgumentException();
                } else {
                    int i4 = 0;
                    int i6 = 2;
                    Object obj = null;
                    l.g(bArr, yVar.a, i4, yVar.b, yVar.c, i6, obj);
                    yVar.c -= i3;
                    i = 0;
                    yVar.b = i;
                }
            }
            l.e(this.a, yVar.a, yVar.c, this.b, i14 + i);
            yVar.c += i;
            this.b += i;
            return;
        }
    }

    public y(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        n.f(bArr, "data");
        super();
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

}

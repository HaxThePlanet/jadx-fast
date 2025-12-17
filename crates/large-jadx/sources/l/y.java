package l;

import java.util.Arrays;
import kotlin.d0.d.n;
import kotlin.y.i;

/* loaded from: classes3.dex */
public final class y {

    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public l.y f;
    public l.y g;
    static {
    }

    public y() {
        super();
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public y(byte[] bArr, int i2, int i3, boolean z4, boolean z5) {
        n.f(bArr, "data");
        super();
        this.a = bArr;
        this.b = i2;
        this.c = i3;
        this.d = z4;
        this.e = z5;
    }

    public final void a() {
        int i2;
        int i;
        l.y yVar = this.g;
        i = yVar != this ? 1 : i2;
        if (i == 0) {
        } else {
            n.d(yVar);
            if (!yVar.e) {
            }
            i3 -= i5;
            l.y yVar4 = this.g;
            n.d(yVar4);
            l.y yVar5 = this.g;
            n.d(yVar5);
            if (yVar5.d) {
            } else {
                l.y yVar3 = this.g;
                n.d(yVar3);
                i2 = yVar3.b;
            }
            if (i4 > i7 += i2) {
            }
            l.y yVar2 = this.g;
            n.d(yVar2);
            g(yVar2, i4);
            b();
            z.b(this);
        }
        IllegalStateException illegalStateException = new IllegalStateException("cannot compact".toString());
        throw illegalStateException;
    }

    public final l.y b() {
        l.y yVar;
        final int i = 0;
        if (this.f != this) {
        } else {
            yVar = i;
        }
        l.y yVar2 = this.g;
        n.d(yVar2);
        yVar2.f = this.f;
        l.y yVar3 = this.f;
        n.d(yVar3);
        yVar3.g = this.g;
        this.f = i;
        this.g = i;
        return yVar;
    }

    public final l.y c(l.y y) {
        n.f(y, "segment");
        y.g = this;
        y.f = this.f;
        l.y yVar2 = this.f;
        n.d(yVar2);
        yVar2.g = y;
        this.f = y;
        return y;
    }

    public final l.y d() {
        this.d = true;
        super(this.a, this.b, this.c, 1, 0);
        return yVar;
    }

    public final l.y e(int i) {
        int i5;
        int i3;
        l.y yVar;
        int i9;
        byte[] bArr;
        int i2;
        int i8;
        int i6;
        int i7;
        int i4;
        if (i > 0 && i <= i10 -= i9) {
            i3 = i <= i10 -= i9 ? 1 : 0;
        } else {
        }
        if (i3 == 0) {
        } else {
            if (i >= 1024) {
                yVar = d();
            } else {
                i8 = this.b;
                i.g(this.a, yVar.a, 0, i8, i8 + i, 2, 0);
            }
            yVar.c = i12 += i;
            this.b = i14 += i;
            l.y obj9 = this.g;
            n.d(obj9);
            obj9.c(yVar);
            return yVar;
        }
        obj9 = new IllegalArgumentException("byteCount out of range".toString());
        throw obj9;
    }

    public final l.y f() {
        byte[] bArr = this.a;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        n.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        super(copyOf, this.b, this.c, 0, 1);
        return yVar2;
    }

    public final void g(l.y y, int i2) {
        int i;
        int i6;
        byte[] bArr;
        int i7;
        int i3;
        int i4;
        int i5;
        n.f(y, "sink");
        if (!y.e) {
        } else {
            final int i17 = y.c;
            i6 = 8192;
            if (i17 + i2 > i6) {
                if (y.d) {
                } else {
                    i3 = y.b;
                    if (i10 -= i3 > i6) {
                    } else {
                        bArr = y.a;
                        i.g(bArr, bArr, 0, i3, i17, 2, 0);
                        y.c = i12 -= i6;
                        y.b = 0;
                    }
                    IllegalArgumentException obj9 = new IllegalArgumentException();
                    throw obj9;
                }
                obj9 = new IllegalArgumentException();
                throw obj9;
            }
            int i15 = this.b;
            i.e(this.a, y.a, y.c, i15, i15 + i2);
            y.c = i8 += i2;
            this.b = obj9 += i2;
        }
        obj9 = new IllegalStateException("only owner can write".toString());
        throw obj9;
    }
}

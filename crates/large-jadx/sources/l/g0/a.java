package l.g0;

import kotlin.d0.d.n;
import l.b;
import l.f;
import l.f.a;
import l.t;
import l.y;

/* loaded from: classes3.dex */
public final class a {

    private static final byte[] a;
    static {
        a.a = b.a("0123456789abcdef");
    }

    public static final f.a a(f f, f.a f$a2) {
        int i;
        n.f(f, "$this$commonReadAndWriteUnsafe");
        n.f(a2, "unsafeCursor");
        final int i2 = 1;
        i = a2.a == null ? i2 : 0;
        if (i == 0) {
        } else {
            a2.a = f;
            a2.b = i2;
            return a2;
        }
        IllegalStateException obj2 = new IllegalStateException("already attached to a buffer".toString());
        throw obj2;
    }

    public static final byte[] b() {
        return a.a;
    }

    public static final boolean c(y y, int i2, byte[] b3Arr3, int i4, int i5) {
        int i;
        byte[] bArr;
        byte b;
        byte b2;
        int i3;
        Object obj5;
        int obj6;
        int obj8;
        n.f(y, "segment");
        n.f(b3Arr3, "bytes");
        i = y.c;
        bArr = y.a;
        while (obj8 < i5) {
            if (obj6 == i) {
            }
            obj6++;
            obj8++;
            obj5 = obj5.f;
            n.d(obj5);
            bArr = obj6;
            obj6 = i6;
            i = i3;
        }
        return 1;
    }

    public static final String d(f f, long l2) {
        int cmp;
        int i;
        byte b;
        String obj7;
        n.f(f, "$this$readUtf8Line");
        final int i3 = 1;
        i = l2 - i3;
        if (Long.compare(l2, i2) > 0 && f.n(i) == (byte)i4) {
            i = l2 - i3;
            if (f.n(i) == (byte)i4) {
                obj7 = f.L(i);
                f.skip(2);
            } else {
                obj7 = f.L(l2);
                f.skip(i3);
            }
        } else {
        }
        return obj7;
    }

    public static final int e(f f, t t2, boolean z3) {
        int i2;
        byte[] bArr;
        int i9;
        int i6;
        int i4;
        int i7;
        int i;
        y yVar;
        int i3;
        int i8;
        int i10;
        int i11;
        int i5;
        int i12;
        y yVar2;
        Object obj = f;
        n.f(obj, "$this$selectPrefix");
        n.f(t2, "options");
        y yVar3 = obj.a;
        final int i13 = -1;
        if (yVar3 != null) {
            bArr = yVar3.a;
            i9 = yVar3.b;
            i4 = yVar3.c;
            int[] iArr = t2.l();
            final int i17 = 0;
            yVar = yVar3;
            i3 = i13;
            i7 = i17;
            int i19 = i7 + 1;
            i = iArr[i7];
            i10 = i19 + 1;
            i8 = iArr[i19];
            while (i8 != i13) {
                i3 = i8;
                i8 = 0;
                if (i < 0) {
                } else {
                }
                while (i10 == i10 + i) {
                    i10++;
                }
                i10++;
                i6 = iArr[i10 += i];
                yVar = yVar.f;
                n.d(yVar);
                i11 = i14;
                bArr = bArr2;
                i4 = i;
                if (i9 + 1 == i4 && yVar == yVar3) {
                }
                i7 = -i6;
                i9 = i11;
                i19 = i7 + 1;
                i = iArr[i7];
                i10 = i19 + 1;
                i8 = iArr[i19];
                yVar = yVar.f;
                n.d(yVar);
                i11 = i14;
                bArr = bArr2;
                i4 = i;
                if (yVar == yVar3) {
                }
                yVar = i8;
                int i18 = i9 + 1;
                i5 = i10 + 1;
                while (b2 &= 255 != iArr[i10]) {
                    if (i5 == i10 + i) {
                    } else {
                    }
                    i9 = i17;
                    yVar = i4;
                    i4 = i18;
                    i = yVar2;
                    i9 = i4;
                    i4 = yVar;
                    i10 = i5;
                    yVar = i;
                    i18 = i9 + 1;
                    i5 = i10 + 1;
                    n.d(yVar);
                    bArr = yVar.f;
                    n.d(bArr);
                    i4 = bArr.b;
                    i = bArr.a;
                    yVar = bArr.c;
                    i = bArr;
                    bArr = yVar2;
                    bArr = i;
                    i = i8;
                    i9 = 1;
                }
                if (i5 == i10 + i) {
                } else {
                }
                i9 = i17;
                yVar = i4;
                i4 = i18;
                i = yVar2;
                i9 = i4;
                i4 = yVar;
                i10 = i5;
                yVar = i;
                i6 = iArr[i5];
                i11 = i4;
                i4 = yVar;
                yVar = i;
                n.d(yVar);
                bArr = yVar.f;
                n.d(bArr);
                i4 = bArr.b;
                i = bArr.a;
                yVar = bArr.c;
                i = bArr;
                bArr = yVar2;
                bArr = i;
                i = i8;
                i9 = 1;
            }
            if (z3) {
                return -2;
            }
            return i3;
        }
        if (z3) {
        } else {
            i2 = i13;
        }
        return i2;
    }

    public static int f(f f, t t2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return a.e(f, t2, obj2);
    }
}

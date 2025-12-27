package l.g0;

import kotlin.d0.d.n;
import l.b;
import l.f;
import l.f.a;
import l.t;
import l.y;

/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public final class a {

    private static final byte[] a;
    static {
        a.a = b.a("0123456789abcdef");
    }

    public static final f.a a(f fVar, f.a aVar) {
        int i = 0;
        n.f(fVar, "$this$commonReadAndWriteUnsafe");
        n.f(aVar, "unsafeCursor");
        final boolean z = true;
        boolean r0 = aVar.a == null ? z : 0;
        if (aVar.a == 0) {
            throw new IllegalStateException("already attached to a buffer".toString());
        } else {
            aVar.a = fVar;
            aVar.b = z;
            return aVar;
        }
    }

    public static final byte[] b() {
        return a.a;
    }

    public static final boolean c(y yVar, int i, byte[] bArr, int i2, int i3) {
        byte[] i22;
        Object obj;
        int i6;
        n.f(yVar, "segment");
        n.f(bArr, "bytes");
        while (i6 < i3) {
            if (i22[i3] != bArr[i6]) {
                return false;
            }
        }
        return true;
    }

    public static final String d(f fVar, long j) {
        int cmp;
        long l;
        byte b;
        String str;
        n.f(fVar, "$this$readUtf8Line");
        final long l3 = 1L;
        if (j > 0) {
            l = j - 1L;
            b = (byte)13;
            if (fVar.n(l) == (byte)13) {
                str = fVar.L(l);
                fVar.skip(2L);
            } else {
                str = fVar.L(j);
                fVar.skip(l3);
            }
        }
        return str;
    }

    public static final int e(f fVar, t tVar, boolean z) {
        int i = -2;
        byte[] bArr;
        int i2;
        y yVar;
        int i3;
        int i4;
        Object fVar2 = fVar;
        n.f(fVar2, "$this$selectPrefix");
        n.f(tVar, "options");
        i = -2;
        i = -1;
        if (fVar2.a != null) {
            int[] iArr = tVar.l();
            i = 0;
            int i7 = i + 1;
            i = iArr[i];
            i3 = i7 + 1;
            i = iArr[i7];
            while (i != i) {
                i = 0;
                i = i + 1;
                i3 = i3 + i;
                while (i3 == i3) {
                    if ((bArr[i] & 255) == iArr[i3]) {
                        i3 = i3 + i;
                        i2 = iArr[i3];
                    }
                }
                if ((bArr[i] & 255) == iArr[i3]) {
                    i3 = i3 + i;
                    i2 = iArr[i3];
                }
            }
            return z ? -2 : i;
        }
        if (!(z)) {
        }
        return i;
    }

    public static /* synthetic */ int f(f fVar, t tVar, boolean z, int i, Object object) {
        if (i & 2 != 0) {
            int i2 = 0;
        }
        return a.e(fVar, tVar, z);
    }
}

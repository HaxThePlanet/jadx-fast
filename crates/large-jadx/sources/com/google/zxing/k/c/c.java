package com.google.zxing.k.c;

import android.accounts.Account;
import com.google.zxing.WriterException;
import com.google.zxing.c;
import com.google.zxing.common.reedsolomon.a;
import com.google.zxing.common.reedsolomon.c;
import com.google.zxing.g.a;
import com.google.zxing.g.c;
import com.google.zxing.k.b.a;
import com.google.zxing.k.b.b;
import com.google.zxing.k.b.c;
import com.google.zxing.k.b.c.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {

    private static final int[] a;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            c.a.a = iArr;
            iArr[b.NUMERIC.ordinal()] = 1;
            c.a.a[b.ALPHANUMERIC.ordinal()] = 2;
            c.a.a[b.BYTE.ordinal()] = 3;
            c.a.a[b.KANJI.ordinal()] = 4;
        }
    }
    static {
        int[] iArr = new int[96];
        iArr = new int[]{
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, 36, -1, -1, -1, 37, 38, -1, -1,
            -1, -1, 39, 40, -1, 41, 42, 43, 0, 1,
            2, 3, 4, 5, 6, 7, 8, 9, 44, -1,
            -1, -1, -1, -1, -1, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
            25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
            35, -1, -1, -1, -1, -1
        };
        c.a = iArr;
    }

    static void a(String string, a a2, String string3) {
        int i;
        byte b;
        int i2;
        try {
            final byte[] obj3 = string.getBytes(string3);
            i = 0;
            while (i < obj3.length) {
                a2.c(obj3[i], 8);
                i++;
            }
            a2.c(obj3[i], 8);
            i++;
        }
    }

    static void b(java.lang.CharSequence charSequence, a a2) {
        int i4;
        int i2;
        int i;
        int i3;
        final int length = charSequence.length();
        i4 = 0;
        while (i4 < length) {
            i2 = c.p(charSequence.charAt(i4));
            i = -1;
            i3 = i4 + 1;
            a2.c(i2, 6);
            i4 = i3;
            i3 = c.p(charSequence.charAt(i3));
            a2.c(i6 += i3, 11);
            i4 += 2;
        }
    }

    static void c(String string, b b2, a a3, String string4) {
        int i = c.a.a[b2.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                    } else {
                        c.e(string, a3);
                    }
                    WriterException obj2 = new WriterException("Invalid mode: ".concat(String.valueOf(b2)));
                    throw obj2;
                }
                c.a(string, a3, string4);
            }
            c.b(string, a3);
        }
        c.h(string, a3);
    }

    private static void d(c c, a a2) {
        a2.c(b.ECI.getBits(), 4);
        a2.c(c.getValue(), 8);
    }

    static void e(String string, a a2) {
        int i3;
        int i;
        int i6;
        int i2;
        int i4;
        int i5;
        int i7;
        try {
            byte[] obj6 = string.getBytes("Shift_JIS");
            i3 = 0;
            i9 |= i13;
            i5 = -1;
            i10 -= i4;
        }
    }

    static void f(int i, c c2, b b3, a a4) {
        int obj2 = b3.getCharacterCountBits(c2);
        final int obj3 = 1;
        int i2 = obj3 << obj2;
        if (i >= i2) {
        } else {
            a4.c(i, obj2);
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append(i);
        obj4.append(" is bigger than ");
        obj4.append(i2 -= obj3);
        obj2 = new WriterException(obj4.toString());
        throw obj2;
    }

    static void g(b b, a a2) {
        a2.c(b.getBits(), 4);
    }

    static void h(java.lang.CharSequence charSequence, a a2) {
        int i5;
        int i2;
        int i;
        int i4;
        int i3;
        final int length = charSequence.length();
        i5 = 0;
        while (i5 < length) {
            charAt2 += -48;
            i = i5 + 2;
            if (i < length) {
            } else {
            }
            i5++;
            if (i5 < length) {
            } else {
            }
            a2.c(i2, 4);
            a2.c(i10 += i6, 7);
            i5 = i;
            i3 = 10;
            a2.c(i9 += i, i3);
            i5 += 3;
        }
    }

    private static int i(b b, a a2, a a3, c c4) {
        return obj1 += obj0;
    }

    private static int j(com.google.zxing.k.c.b b) {
        return i3 += obj2;
    }

    private static int k(a a, a a2, c c3, com.google.zxing.k.c.b b4) {
        int i4;
        int i;
        int i2;
        int i3;
        i4 = Integer.MAX_VALUE;
        i = -1;
        i2 = 0;
        while (i2 < 8) {
            e.a(a, a2, c3, i2, b4);
            i3 = c.j(b4);
            if (i3 < i4) {
            }
            i2++;
            i = i2;
            i4 = i3;
        }
        return i;
    }

    private static b l(String string, String string2) {
        int i4;
        int i3;
        char charAt;
        int i;
        int i2;
        boolean obj6;
        if ("Shift_JIS".equals(string2) && c.s(string)) {
            if (c.s(string)) {
                return b.KANJI;
            }
        }
        i3 = i4;
        while (obj6 < string.length()) {
            charAt = string.charAt(obj6);
            i2 = 1;
            i4 = i2;
            obj6++;
            i3 = i2;
        }
        if (i4 != 0) {
            return b.ALPHANUMERIC;
        }
        if (i3 != 0) {
            return b.NUMERIC;
        }
        return b.BYTE;
    }

    private static c m(int i, a a2) {
        int i2;
        c cVar;
        boolean z;
        i2 = 1;
        while (i2 <= 40) {
            cVar = c.e(i2);
            i2++;
        }
        WriterException obj3 = new WriterException("Data too big");
        throw obj3;
    }

    public static com.google.zxing.k.c.f n(String string, a a2, Map<c, ?> map3) {
        int fNC1_FIRST_POSITION;
        int qR_VERSION;
        boolean key;
        int characterSetECIByName;
        String string2;
        int obj7;
        c obj9;
        qR_VERSION = 0;
        if (map3 != null && map3.containsKey(c.CHARACTER_SET)) {
            characterSetECIByName = map3.containsKey(c.CHARACTER_SET) ? fNC1_FIRST_POSITION : qR_VERSION;
        } else {
        }
        if (characterSetECIByName != 0) {
            string2 = map3.get(c.CHARACTER_SET).toString();
        } else {
            string2 = "ISO-8859-1";
        }
        final b bVar2 = c.l(string, string2);
        a aVar3 = new a();
        final b bYTE = b.BYTE;
        characterSetECIByName = c.getCharacterSetECIByName(string2);
        if (bVar2 == bYTE && characterSetECIByName != 0 && characterSetECIByName != null) {
            if (characterSetECIByName != 0) {
                characterSetECIByName = c.getCharacterSetECIByName(string2);
                if (characterSetECIByName != null) {
                    c.d(characterSetECIByName, aVar3);
                }
            }
        }
        if (map3 != null && map3.containsKey(c.GS1_FORMAT)) {
            if (map3.containsKey(c.GS1_FORMAT)) {
            } else {
                fNC1_FIRST_POSITION = qR_VERSION;
            }
        } else {
        }
        if (fNC1_FIRST_POSITION != 0 && Boolean.valueOf(map3.get(c.GS1_FORMAT).toString()).booleanValue()) {
            if (Boolean.valueOf(map3.get(c.GS1_FORMAT).toString()).booleanValue()) {
                c.g(b.FNC1_FIRST_POSITION, aVar3);
            }
        }
        c.g(bVar2, aVar3);
        a aVar = new a();
        c.c(string, bVar2, aVar, string2);
        qR_VERSION = c.QR_VERSION;
        if (map3 != null && map3.containsKey(qR_VERSION)) {
            qR_VERSION = c.QR_VERSION;
            if (map3.containsKey(qR_VERSION)) {
                obj9 = c.e(Integer.parseInt(map3.get(qR_VERSION).toString()));
                if (!c.v(c.i(bVar2, aVar3, aVar, obj9), obj9, a2)) {
                } else {
                    a aVar2 = new a();
                    aVar2.b(aVar3);
                    if (bVar2 == bYTE) {
                        obj7 = aVar.h();
                    } else {
                        obj7 = string.length();
                    }
                    c.f(obj7, obj9, bVar2, aVar2);
                    aVar2.b(aVar);
                    obj7 = obj9.c(a2);
                    i -= i6;
                    c.u(i2, aVar2);
                    obj7 = c.r(aVar2, obj9.d(), i2, obj7.c());
                    f fVar = new f();
                    fVar.c(a2);
                    fVar.f(bVar2);
                    fVar.g(obj9);
                    int i3 = obj9.b();
                    b bVar = new b(i3, i3);
                    int i4 = c.k(obj7, a2, obj9, bVar);
                    fVar.d(i4);
                    e.a(obj7, a2, obj9, i4, bVar);
                    fVar.e(bVar);
                    return fVar;
                }
                obj7 = new WriterException("Data too big for requested version");
                throw obj7;
            }
        }
        obj9 = c.t(a2, bVar2, aVar3, aVar);
    }

    static byte[] o(byte[] bArr, int i2) {
        int i;
        int i3;
        a aVar;
        int i4;
        final int length = bArr.length;
        int[] iArr = new int[length + i2];
        i3 = i;
        while (i3 < length) {
            iArr[i3] = b &= 255;
            i3++;
        }
        c obj5 = new c(a.k);
        obj5.b(iArr, i2);
        obj5 = new byte[i2];
        while (i < i2) {
            obj5[i] = (byte)i7;
            i++;
        }
        return obj5;
    }

    static int p(int i) {
        final int[] iArr = c.a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    static void q(int i, int i2, int i3, int i4, int[] i5Arr5, int[] i6Arr6) {
        if (i4 >= i3) {
        } else {
            final int i5 = i % i3;
            final int i6 = i3 - i5;
            int i7 = i / i3;
            i2 /= i3;
            final int i11 = obj7 + 1;
            i7 -= obj7;
            i9 -= i11;
            if (i8 != i10) {
            } else {
                if (i3 != i6 + i5) {
                } else {
                    if (i != obj8 += i14) {
                    } else {
                        int obj6 = 0;
                        if (i4 < i6) {
                            i5Arr5[obj6] = obj7;
                            i6Arr6[obj6] = i8;
                        }
                        i5Arr5[obj6] = i11;
                        i6Arr6[obj6] = i10;
                    }
                    obj6 = new WriterException("Total bytes mismatch");
                    throw obj6;
                }
                obj6 = new WriterException("RS blocks mismatch");
                throw obj6;
            }
            obj6 = new WriterException("EC bytes mismatch");
            throw obj6;
        }
        obj6 = new WriterException("Block ID too large");
        throw obj6;
    }

    static a r(a a, int i2, int i3, int i4) {
        int i8;
        byte[] bArr2;
        int iterator2;
        byte[] bArr;
        Iterator iterator;
        com.google.zxing.k.c.a aVar;
        int[] iArr;
        int i;
        int i9;
        int i7;
        int i6;
        int i5;
        int[] iArr2;
        int[] iArr3;
        final int i20 = i2;
        final int i21 = i3;
        final int i22 = i4;
        if (a.h() != i21) {
        } else {
            ArrayList arrayList = new ArrayList(i22);
            i = 0;
            i5 = i6;
            while (i9 < i22) {
                int i10 = 1;
                iArr2 = new int[i10];
                iArr = new int[i10];
                c.q(i2, i3, i4, i9, iArr2, iArr);
                int i12 = iArr2[i];
                bArr2 = new byte[i12];
                a.k(i7 << 3, bArr2, i, i12);
                bArr = c.o(bArr2, iArr[i]);
                aVar = new a(bArr2, bArr);
                arrayList.add(aVar);
                i6 = Math.max(i6, i12);
                i5 = Math.max(i5, bArr.length);
                i7 += i8;
                i9++;
            }
            if (i21 != i7) {
            } else {
                a aVar2 = new a();
                iterator2 = i;
                bArr = 8;
                while (iterator2 < i6) {
                    iterator = arrayList.iterator();
                    while (iterator.hasNext()) {
                        aVar = (a)iterator.next().a();
                        if (iterator2 < aVar.length) {
                        }
                        aVar2.c(aVar[iterator2], bArr);
                    }
                    iterator2++;
                    bArr = 8;
                    aVar = (a)iterator.next().a();
                    if (iterator2 < aVar.length) {
                    }
                    aVar2.c(aVar[iterator2], bArr);
                }
                while (i < i5) {
                    iterator2 = arrayList.iterator();
                    while (iterator2.hasNext()) {
                        iterator = (a)iterator2.next().b();
                        if (i < iterator.length) {
                        }
                        aVar2.c(iterator[i], bArr);
                    }
                    i++;
                    iterator = (a)iterator2.next().b();
                    if (i < iterator.length) {
                    }
                    aVar2.c(iterator[i], bArr);
                }
                if (i20 != aVar2.h()) {
                } else {
                    return aVar2;
                }
                StringBuilder stringBuilder = new StringBuilder("Interleaving error: ");
                stringBuilder.append(i20);
                stringBuilder.append(" and ");
                stringBuilder.append(aVar2.h());
                stringBuilder.append(" differ.");
                WriterException writerException3 = new WriterException(stringBuilder.toString());
                throw writerException3;
            }
            WriterException writerException2 = new WriterException("Data bytes does not match offset");
            throw writerException2;
        }
        WriterException writerException = new WriterException("Number of bits and data bytes does not match");
        throw writerException;
    }

    private static boolean s(String string) {
        int i3;
        int i;
        int i2;
        final int i4 = 0;
        byte[] obj5 = string.getBytes("Shift_JIS");
        int length = obj5.length;
        if (length % 2 != 0) {
            try {
                return i4;
                i3 = i4;
                b &= 255;
            }
            return 1;
        }
    }

    private static c t(a a, b b2, a a3, a a4) {
        return c.m(c.i(b2, a3, a4, c.m(c.i(b2, a3, a4, c.e(1)), a)), a);
    }

    static void u(int i, a a2) {
        int i4;
        int i3;
        int i2;
        int i5;
        int i6;
        final int i7 = i << 3;
        if (a2.g() > i7) {
        } else {
            i4 = 0;
            i3 = i4;
            while (i3 < 4) {
                if (a2.g() < i7) {
                }
                a2.a(i4);
                i3++;
            }
            int i11 = 8;
            if (i9 &= 7 > 0) {
            }
            while (i4 < i -= i5) {
                if (i4 & 1 == 0) {
                } else {
                }
                i5 = 17;
                a2.c(i5, i11);
                i4++;
                i5 = 236;
            }
            if (a2.g() != i7) {
            } else {
            }
            WriterException obj4 = new WriterException("Bits size does not equal capacity");
            throw obj4;
        }
        StringBuilder stringBuilder = new StringBuilder("data bits cannot fit in the QR Code");
        stringBuilder.append(a2.g());
        stringBuilder.append(" > ");
        stringBuilder.append(i7);
        obj4 = new WriterException(stringBuilder.toString());
        throw obj4;
    }

    private static boolean v(int i, c c2, a a3) {
        if (i2 -= obj2 >= obj1 /= 8) {
            return 1;
        }
        return 0;
    }
}

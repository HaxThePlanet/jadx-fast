package com.google.android.exoplayer2.util;

import android.util.Pair;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class j {

    private static final byte[] a;
    private static final String[] b;
    static {
        byte[] bArr = new byte[4];
        bArr = new byte[]{0, 0, 0, 1};
        j.a = bArr;
        j.b = /* result */;
    }

    public static String a(int i, int i2, int i3) {
        Object[] arr = new Object[3];
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static List<byte[]> b(boolean z) {
        byte[] obj2;
        final int i = 0;
        final int i2 = 1;
        if (z) {
            new byte[i2][i] = i2;
        } else {
            new byte[i2][i] = i;
        }
        return Collections.singletonList(obj2);
    }

    public static String c(com.google.android.exoplayer2.util.e0 e0) {
        int format;
        int i;
        Character valueOf;
        int i7;
        int i3;
        int i5;
        boolean z;
        int i4;
        int i2;
        int i6;
        String obj12;
        e0.l(24);
        int i9 = 2;
        int i13 = 5;
        final int i15 = 0;
        i5 = i7;
        i4 = 1;
        while (i7 < 32) {
            if (e0.d()) {
            }
            i7++;
            i4 = 1;
            i5 |= z;
        }
        i3 = 6;
        int[] iArr = new int[i3];
        i2 = i15;
        int i17 = 8;
        while (i2 < i3) {
            iArr[i2] = e0.e(i17);
            i2++;
            i17 = 8;
        }
        Object[] arr2 = new Object[i13];
        arr2[i15] = j.b[e0.e(i9)];
        arr2[i4] = Integer.valueOf(e0.e(i13));
        arr2[i9] = Integer.valueOf(i5);
        i = e0.d() ? 72 : 76;
        arr2[3] = Character.valueOf(i);
        arr2[4] = Integer.valueOf(e0.e(i17));
        StringBuilder stringBuilder = new StringBuilder(p0.z("hvc1.%s%d.%X.%c%d", arr2));
        while (i3 > 0) {
            if (iArr[i3 + -1] == null) {
            }
            i3--;
        }
        obj12 = i15;
        while (obj12 < i3) {
            Object[] arr = new Object[i4];
            arr[i15] = Integer.valueOf(iArr[obj12]);
            stringBuilder.append(String.format(".%02X", arr));
            obj12++;
        }
        return stringBuilder.toString();
    }

    public static byte[] d(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = j.a;
        byte[] bArr3 = new byte[length2 += i3];
        final int i4 = 0;
        System.arraycopy(bArr2, i4, bArr3, i4, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    public static Pair<Integer, Integer> e(byte[] bArr) {
        d0 d0Var = new d0(bArr);
        d0Var.I(9);
        d0Var.I(20);
        return Pair.create(Integer.valueOf(d0Var.B()), Integer.valueOf(d0Var.x()));
    }

    public static boolean f(List<byte[]> list) {
        int length;
        int i;
        byte obj3;
        i = 0;
        final int i2 = 1;
        if (list.size() == i2 && obj.length == i2 && (byte[])list.get(i)[i] == i2) {
            if (obj.length == i2) {
                if ((byte[])list.get(i)[i] == i2) {
                    i = i2;
                }
            }
        }
        return i;
    }
}

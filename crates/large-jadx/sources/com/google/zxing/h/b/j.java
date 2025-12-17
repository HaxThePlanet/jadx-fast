package com.google.zxing.h.b;

import com.google.zxing.b;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class j {
    public static int a(java.lang.CharSequence charSequence, int i2) {
        int i;
        char charAt;
        boolean z;
        int obj5;
        final int length = charSequence.length();
        i = 0;
        if (i2 < length) {
            charAt = charSequence.charAt(i2);
            while (j.f(charAt)) {
                if (obj5 < length) {
                }
                i++;
                obj5++;
                if (obj5 < length) {
                }
                charAt = charSequence.charAt(obj5);
            }
        }
        return i;
    }

    public static String b(String string, com.google.zxing.h.b.l l2, b b3, b b4) {
        int i;
        String obj7;
        boolean obj8;
        int obj9;
        com.google.zxing.h.b.g[] arr = new g[6];
        a aVar = new a();
        c cVar = new c();
        final int i3 = 1;
        arr[i3] = cVar;
        m mVar = new m();
        final int i4 = 2;
        arr[i4] = mVar;
        n nVar = new n();
        arr[3] = nVar;
        f fVar = new f();
        int i6 = 4;
        arr[i6] = fVar;
        b bVar = new b();
        final int i7 = 5;
        arr[i7] = bVar;
        h hVar = new h(string);
        hVar.n(l2);
        hVar.l(b3, b4);
        obj9 = "\u001e\u0004";
        if (string.startsWith("[)>\u001e05\u001d") && string.endsWith(obj9)) {
            if (string.endsWith(obj9)) {
                hVar.r('\u00ec');
                hVar.m(i4);
                hVar.f = obj7 += 7;
            } else {
                if (string.startsWith("[)>\u001e06\u001d") && string.endsWith(obj9)) {
                    if (string.endsWith(obj9)) {
                        hVar.r('\u00ed');
                        hVar.m(i4);
                        hVar.f = obj7 += 7;
                    }
                }
            }
        } else {
        }
        while (hVar.i()) {
            arr[i].a(hVar);
            if (hVar.e() >= 0) {
            }
            i = hVar.e();
            hVar.j();
        }
        hVar.p();
        obj8 = hVar.g().a();
        if (hVar.a() < obj8 && i != 0 && i != i7 && i != i6) {
            if (i != 0) {
                if (i != i7) {
                    if (i != i6) {
                        hVar.r('\u00fe');
                    }
                }
            }
        }
        obj7 = hVar.b();
        final int obj10 = 129;
        if (obj7.length() < obj8) {
            obj7.append(obj10);
        }
        while (obj7.length() < obj8) {
            obj7.append(j.o(obj10, obj9 += i3));
        }
        return hVar.b().toString();
    }

    private static int c(float[] fArr, int[] i2Arr2, int i3, byte[] b4Arr4) {
        int i2;
        int i;
        int obj6;
        final int i4 = 0;
        Arrays.fill(b4Arr4, i4);
        i2 = i4;
        while (i2 < 6) {
            i2Arr2[i2] = (int)ceil;
            i = i2Arr2[i2];
            if (obj6 > i) {
            }
            if (obj6 == i) {
            }
            i2++;
            b4Arr4[i2] = (byte)i8;
            Arrays.fill(b4Arr4, i4);
            obj6 = i;
        }
        return obj6;
    }

    private static int d(byte[] bArr) {
        int i;
        int i2;
        byte b;
        i2 = i;
        while (i < 6) {
            i2 += b;
            i++;
        }
        return i2;
    }

    static void e(char c) {
        String hexString = Integer.toHexString(c);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0000".substring(0, length - 4));
        stringBuilder.append(hexString);
        StringBuilder stringBuilder2 = new StringBuilder("Illegal character: ");
        stringBuilder2.append(c);
        stringBuilder2.append(" (0x");
        stringBuilder2.append(stringBuilder.toString());
        stringBuilder2.append(')');
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
        throw illegalArgumentException;
    }

    static boolean f(char c) {
        int i;
        if (c >= 48 && c <= 57) {
            if (c <= 57) {
                return 1;
            }
        }
        return 0;
    }

    static boolean g(char c) {
        int i;
        if (c >= 128 && c <= 255) {
            if (c <= 255) {
                return 1;
            }
        }
        return 0;
    }

    private static boolean h(char c) {
        int i;
        if (c != 32) {
            if (c >= 48) {
                if (c > 57 && c >= 65 && c <= 90) {
                    if (c >= 65) {
                        if (c <= 90) {
                        }
                    }
                }
            } else {
            }
            return 0;
        }
        return 1;
    }

    private static boolean i(char c) {
        int i;
        if (c >= 32 && c <= 94) {
            if (c <= 94) {
                return 1;
            }
        }
        return 0;
    }

    private static boolean j(char c) {
        int i;
        if (c != 32) {
            if (c >= 48) {
                if (c > 57 && c >= 97 && c <= 122) {
                    if (c >= 97) {
                        if (c <= 122) {
                        }
                    }
                }
            } else {
            }
            return 0;
        }
        return 1;
    }

    private static boolean k(char c) {
        int z;
        if (!j.m(c) && c != 32) {
            if (c != 32) {
                if (c >= 48) {
                    if (c > 57 && c >= 65 && c <= 90) {
                        if (c >= 65) {
                            if (c <= 90) {
                            }
                        }
                    }
                } else {
                }
                return 0;
            }
        }
        return 1;
    }

    private static boolean l(char c) {
        return 0;
    }

    private static boolean m(char c) {
        int i;
        if (c != 13 && c != 42 && c == 62) {
            if (c != 42) {
                if (c == 62) {
                }
                return 0;
            }
        }
        return 1;
    }

    static int n(java.lang.CharSequence charSequence, int i2, int i3) {
        byte[] bArr;
        int i8;
        int i4;
        int length;
        float[] fArr;
        int i5;
        int i11;
        int i22;
        int i6;
        int i16;
        int iArr;
        int i9;
        int i23;
        int i19;
        int i7;
        int i24;
        int i10;
        int i12;
        int i25;
        int i18;
        int i26;
        int i20;
        int i15;
        int i13;
        int i;
        int i14;
        int i17;
        int i21;
        int obj = charSequence;
        int i29 = i2;
        if (i29 >= charSequence.length()) {
            return i3;
        }
        length = 6;
        if (i3 == 0) {
            fArr = new int[]{0, 1065353216, 1065353216, 1065353216, 1065353216, 1067450368};
        } else {
            fArr = new float[length];
            fArr = new int[]{1065353216, 1073741824, 1073741824, 1073741824, 1073741824, 1074790400};
            fArr[i3] = 0;
        }
        int i33 = 0;
        i11 = i33;
        int i34 = i29 + i11;
        i12 = Integer.MAX_VALUE;
        int i44 = 5;
        i26 = 2;
        i20 = 4;
        i15 = 3;
        i13 = 1;
        while (i34 == charSequence.length()) {
            char charAt2 = obj.charAt(i34);
            i11++;
            i = 1065353216;
            if (j.f(charAt2)) {
            } else {
            }
            if (j.g(charAt2)) {
            } else {
            }
            fArr[i33] = (float)ceil2;
            fArr[i33] = f6 += i;
            i25 = 1076538027;
            i18 = 1068149419;
            i21 = 1059760811;
            if (j.h(charAt2)) {
            } else {
            }
            if (j.g(charAt2)) {
            } else {
            }
            fArr[i13] = f8 += i18;
            if (j.j(charAt2)) {
            } else {
            }
            if (j.g(charAt2)) {
            } else {
            }
            fArr[i26] = f19 += i18;
            if (j.k(charAt2)) {
            } else {
            }
            if (j.g(charAt2)) {
            } else {
            }
            fArr[i15] = f16 += i25;
            if (j.i(charAt2)) {
            } else {
            }
            if (j.g(charAt2)) {
            } else {
            }
            fArr[i20] = f11 += i10;
            if (j.l(charAt2)) {
            } else {
            }
            i22 = 5;
            fArr[i22] = f14 += i;
            i34 = i29 + i11;
            i12 = Integer.MAX_VALUE;
            i44 = 5;
            i26 = 2;
            i20 = 4;
            i15 = 3;
            i13 = 1;
            iArr = new int[length];
            byte[] bArr2 = new byte[length];
            j.c(fArr, iArr, Integer.MAX_VALUE, bArr2);
            i18 = j.d(bArr2);
            i22 = 5;
            fArr[i22] = f15 += i10;
            fArr[i20] = f12 += i10;
            fArr[i20] = f13 += i10;
            fArr[i15] = f17 += i25;
            fArr[i15] = f18 += i21;
            fArr[i26] = f20 += i25;
            fArr[i26] = f21 += i21;
            fArr[i13] = f9 += i25;
            fArr[i13] = f10 += i21;
            fArr[i33] = (float)ceil;
            fArr[i33] = f3 += i12;
            fArr[i33] = f7 += i17;
        }
        bArr = new byte[length];
        int[] iArr2 = new int[length];
        int i32 = j.d(bArr);
        if (iArr2[i33] == j.c(fArr, iArr2, i12, bArr)) {
            return i33;
        }
        if (i32 == i13 && bArr[i44] > 0) {
            if (bArr[i44] > 0) {
                return i44;
            }
        }
        if (i32 == i13 && bArr[i20] > 0) {
            if (bArr[i20] > 0) {
                return i20;
            }
        }
        if (i32 == i13 && bArr[i26] > 0) {
            if (bArr[i26] > 0) {
                return i26;
            }
        }
        if (i32 == i13 && bArr[i15] > 0) {
            if (bArr[i15] > 0) {
                return i15;
            }
        }
        return i13;
    }

    private static char o(char c, int i2) {
        int obj0;
        c += obj1;
        if (obj0 <= 254) {
        } else {
            obj0 += -254;
        }
        return (char)obj0;
    }
}

package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class o0 {
    private static int[] a(String string) {
        int length;
        int indexOf3;
        int indexOf2;
        int charAt;
        int i;
        int indexOf;
        char charAt2;
        int obj10;
        int[] iArr = new int[4];
        final int i3 = 0;
        final int i4 = -1;
        if (TextUtils.isEmpty(string)) {
            iArr[i3] = i4;
            return iArr;
        }
        length = string.length();
        int indexOf4 = string.indexOf(35);
        if (indexOf4 == i4) {
        } else {
            length = indexOf4;
        }
        indexOf3 = string.indexOf(63);
        if (indexOf3 != i4) {
            if (indexOf3 > length) {
                indexOf3 = length;
            }
        } else {
        }
        final int i7 = 47;
        indexOf2 = string.indexOf(i7);
        if (indexOf2 != i4) {
            if (indexOf2 > indexOf3) {
                indexOf2 = indexOf3;
            }
        } else {
        }
        if (string.indexOf(58) > indexOf2) {
            indexOf = i4;
        }
        charAt = indexOf + 2;
        final int i9 = 1;
        if (charAt < indexOf3 && string.charAt(indexOf + 1) == i7 && string.charAt(charAt) == i7) {
            if (string.charAt(indexOf + 1) == i7) {
                i = string.charAt(charAt) == i7 ? i9 : i3;
            } else {
            }
        } else {
        }
        if (i != 0) {
            obj10 = string.indexOf(i7, indexOf + 3);
            if (obj10 != i4) {
                if (obj10 > indexOf3) {
                    obj10 = indexOf3;
                }
            } else {
            }
        } else {
            obj10 = indexOf + 1;
        }
        iArr[i3] = indexOf;
        iArr[i9] = obj10;
        iArr[2] = indexOf3;
        iArr[3] = length;
        return iArr;
    }

    private static String b(StringBuilder stringBuilder, int i2, int i3) {
        int i4;
        int i;
        int charAt;
        int charAt2;
        int i5;
        char charAt3;
        int obj8;
        int obj9;
        if (i2 >= i3) {
            return stringBuilder.toString();
        }
        final int i6 = 47;
        if (stringBuilder.charAt(i2) == i6) {
            i2++;
        }
        i = i4;
        while (i4 <= obj9) {
            if (i4 == obj9) {
            } else {
            }
            if (stringBuilder.charAt(i4) == i6) {
            } else {
            }
            i4++;
            charAt = i4 + 1;
            charAt2 = i + 1;
            i5 = 46;
            if (i4 == charAt2 && stringBuilder.charAt(i) == i5) {
            } else {
            }
            if (i4 == i + 2 && stringBuilder.charAt(i) == i5 && stringBuilder.charAt(charAt2) == i5) {
            } else {
            }
            i4++;
            i = i4;
            i4 = i;
            if (stringBuilder.charAt(i) == i5) {
            } else {
            }
            if (stringBuilder.charAt(charAt2) == i5) {
            } else {
            }
            lastIndexOf++;
            if (i4 > obj8) {
            } else {
            }
            i = obj8;
            stringBuilder.delete(i, charAt);
            obj9 -= charAt;
            i = i4;
            if (stringBuilder.charAt(i) == i5) {
            } else {
            }
            stringBuilder.delete(i, charAt);
            obj9 -= charAt;
            charAt = i4;
        }
        return stringBuilder.toString();
    }

    public static String c(String string, String string2) {
        int i2;
        int i3;
        int i;
        String obj10;
        String obj11;
        StringBuilder stringBuilder = new StringBuilder();
        String str = "";
        if (string == null) {
            obj10 = str;
        }
        if (string2 == null) {
            obj11 = str;
        }
        int[] iArr = o0.a(obj11);
        final int i8 = 0;
        int i13 = -1;
        final int i17 = 2;
        final int i18 = 1;
        if (iArr[i8] != i13) {
            stringBuilder.append(obj11);
            o0.b(stringBuilder, iArr[i18], iArr[i17]);
            return stringBuilder.toString();
        }
        int[] iArr2 = o0.a(obj10);
        int i19 = 3;
        if (iArr[i19] == 0) {
            stringBuilder.append(obj10, i8, iArr2[i19]);
            stringBuilder.append(obj11);
            return stringBuilder.toString();
        }
        if (iArr[i17] == 0) {
            stringBuilder.append(obj10, i8, iArr2[i17]);
            stringBuilder.append(obj11);
            return stringBuilder.toString();
        }
        if (iArr[i18] != 0) {
            i10 += i18;
            stringBuilder.append(obj10, i8, i11);
            stringBuilder.append(obj11);
            return o0.b(stringBuilder, obj10 += i11, i11 += obj11);
        }
        int i27 = 47;
        if (obj11.charAt(iArr[i18]) == i27) {
            stringBuilder.append(obj10, i8, iArr2[i18]);
            stringBuilder.append(obj11);
            return o0.b(stringBuilder, iArr2[i18], obj11 += i7);
        }
        if (i23 += i17 < iArr2[i18] && iArr2[i18] == iArr2[i17]) {
            if (iArr2[i18] == iArr2[i17]) {
                stringBuilder.append(obj10, i8, iArr2[i18]);
                stringBuilder.append(i27);
                stringBuilder.append(obj11);
                return o0.b(stringBuilder, iArr2[i18], obj11 += i18);
            }
        }
        int lastIndexOf = obj10.lastIndexOf(i27, i24 -= i18);
        i2 = lastIndexOf == i13 ? iArr2[i18] : lastIndexOf + 1;
        stringBuilder.append(obj10, i8, i2);
        stringBuilder.append(obj11);
        return o0.b(stringBuilder, iArr2[i18], i2 += obj11);
    }

    public static Uri d(String string, String string2) {
        return Uri.parse(o0.c(string, string2));
    }
}

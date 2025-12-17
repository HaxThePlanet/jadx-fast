package com.google.zxing.i;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.g.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d extends com.google.zxing.i.n {

    private static enum a {

        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1;
    }
    private static int f(java.lang.CharSequence charSequence, int i2, int i3) {
        int length;
        com.google.zxing.i.d.a aVar;
        com.google.zxing.i.d.a tWO_DIGITS;
        java.lang.CharSequence obj5;
        int obj6;
        com.google.zxing.i.d.a obj7;
        aVar = d.g(charSequence, i2);
        final com.google.zxing.i.d.a oNE_DIGIT = d.a.ONE_DIGIT;
        final int i4 = 100;
        if (aVar == oNE_DIGIT) {
            return i4;
        }
        final com.google.zxing.i.d.a uNCODABLE = d.a.UNCODABLE;
        obj5 = charSequence.charAt(i2);
        length = 101;
        if (aVar == uNCODABLE && i2 < charSequence.length() && obj5 >= 32 && i3 == length && obj5 < 96) {
            if (i2 < charSequence.length()) {
                obj5 = charSequence.charAt(i2);
                length = 101;
                if (obj5 >= 32) {
                    if (i3 == length) {
                        if (obj5 < 96) {
                        }
                    }
                }
                return length;
            }
            return i4;
        }
        final int i5 = 99;
        if (i3 == i5) {
            return i5;
        }
        obj7 = d.a.FNC_1;
        if (i3 == i4 && aVar == obj7) {
            obj7 = d.a.FNC_1;
            if (aVar == obj7) {
                return i4;
            }
            tWO_DIGITS = d.g(charSequence, i2 + 2);
            if (tWO_DIGITS != uNCODABLE) {
                if (tWO_DIGITS == oNE_DIGIT) {
                } else {
                    if (tWO_DIGITS == obj7 && d.g(charSequence, i2 += 3) == d.a.TWO_DIGITS) {
                        if (d.g(charSequence, i2 += 3) == d.a.TWO_DIGITS) {
                            return i5;
                        }
                        return i4;
                    }
                    i2 += 4;
                    obj7 = d.g(charSequence, obj6);
                    while (obj7 == d.a.TWO_DIGITS) {
                        obj6 += 2;
                        obj7 = d.g(charSequence, obj6);
                    }
                    if (obj7 == d.a.ONE_DIGIT) {
                        return i4;
                    }
                }
                return i5;
            }
            return i4;
        }
        if (aVar == d.a.FNC_1) {
            aVar = d.g(charSequence, i2++);
        }
        if (aVar == d.a.TWO_DIGITS) {
            return i5;
        }
        return i4;
    }

    private static com.google.zxing.i.d.a g(java.lang.CharSequence charSequence, int i2) {
        int i;
        final int length = charSequence.length();
        if (i2 >= length) {
            return d.a.UNCODABLE;
        }
        final char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            return d.a.FNC_1;
        }
        int i4 = 48;
        if (charAt >= i4) {
            i = 57;
            if (charAt > i) {
            } else {
                i2++;
                if (obj5 >= length) {
                    return d.a.ONE_DIGIT;
                }
                char obj4 = charSequence.charAt(obj5);
                if (obj4 >= i4 && obj4 > i) {
                    if (obj4 > i) {
                    }
                    return d.a.TWO_DIGITS;
                }
            }
            return d.a.ONE_DIGIT;
        }
        return d.a.UNCODABLE;
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        if (a2 != a.CODE_128) {
        } else {
            return super.a(string, a2, i3, i4, map5);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(a2)));
        throw obj2;
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String string) {
        int i4;
        int i3;
        int i5;
        int i10;
        ArrayList arrayList;
        char charAt2;
        int i2;
        int next;
        int i7;
        int length;
        int i11;
        int i9;
        int[] iArr;
        int charAt;
        int i6;
        int i;
        int int;
        int i8;
        int length2 = string.length();
        if (length2 <= 0) {
        } else {
            if (length2 > 80) {
            } else {
                i5 = 0;
                i10 = i5;
                while (i10 < length2) {
                    charAt2 = string.charAt(i10);
                    i10++;
                }
                arrayList = new ArrayList();
                int i13 = 1;
                i11 = i7;
                i9 = i13;
                while (next < length2) {
                    i6 = d.f(string, next, i11);
                    int = 100;
                    i8 = 101;
                    if (i6 == i11) {
                    } else {
                    }
                    if (i11 == 0) {
                    } else {
                    }
                    charAt = i6;
                    int = charAt;
                    i11 = i6;
                    arrayList.add(c.a[int]);
                    i7 += i;
                    if (next != 0) {
                    }
                    i9++;
                    if (i6 != int) {
                    } else {
                    }
                    charAt = 104;
                    if (i6 != i8) {
                    }
                    charAt = 105;
                    if (i11 != int) {
                    } else {
                    }
                    int = charAt + -32;
                    next += i13;
                    if (i11 != i8) {
                    } else {
                    }
                    int = charAt + -32;
                    if (int < 0) {
                    }
                    int += 96;
                    int = Integer.parseInt(string.substring(next, next + 2));
                    next++;
                    if (i11 == i8) {
                    }
                    int = i8;
                    int = 96;
                    int = 97;
                    int = 102;
                }
                int[][] obj13 = c.a;
                arrayList.add(obj13[i7 %= charAt]);
                arrayList.add(obj13[106]);
                obj13 = arrayList.iterator();
                i4 = i5;
                for (int[] next : obj13) {
                    i11 = i5;
                    while (i11 < next.length) {
                        i4 += i9;
                        i11++;
                    }
                    i4 += i9;
                    i11++;
                }
                obj13 = new boolean[i4];
                Iterator iterator = arrayList.iterator();
                for (int[] next3 : iterator) {
                    i5 += arrayList;
                }
                return obj13;
            }
        }
        obj13 = new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length2)));
        throw obj13;
    }
}

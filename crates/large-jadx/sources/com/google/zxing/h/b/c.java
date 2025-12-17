package com.google.zxing.h.b;

/* loaded from: classes2.dex */
class c implements com.google.zxing.h.b.g {
    private int b(com.google.zxing.h.b.h h, StringBuilder stringBuilder2, StringBuilder stringBuilder3, int i4) {
        final int length = stringBuilder2.length();
        stringBuilder2.delete(length - i4, length);
        h.f = obj3--;
        h.k();
        return c(h.c(), stringBuilder3);
    }

    private static String d(java.lang.CharSequence charSequence, int i2) {
        int i9 = 2;
        int obj4 = 1;
        i4 += obj4;
        char[] cArr = new char[i9];
        cArr[0] = (char)obj5;
        cArr[obj4] = (char)i6;
        String string = new String(cArr);
        return string;
    }

    static void g(com.google.zxing.h.b.h h, StringBuilder stringBuilder2) {
        final int i = 0;
        h.s(c.d(stringBuilder2, i));
        stringBuilder2.delete(i, 3);
    }

    @Override // com.google.zxing.h.b.g
    public void a(com.google.zxing.h.b.h h) {
        int i2;
        boolean z;
        int i4;
        int i6;
        int i3;
        boolean stringBuilder;
        int i;
        int i5;
        StringBuilder stringBuilder2 = new StringBuilder();
        while (h.i()) {
            i6 = 1;
            h.f = i7 += i6;
            i3 = 3;
            i13 += i10;
            h.q(i14);
            i11 -= i14;
        }
        f(h, stringBuilder2);
    }

    @Override // com.google.zxing.h.b.g
    int c(char c, StringBuilder stringBuilder2) {
        int i;
        int i2;
        int i3 = 32;
        i = 1;
        if (c == i3) {
            stringBuilder2.append('\u0003');
            return i;
        }
        int i9 = 48;
        if (c >= i9 && c <= 57) {
            if (c <= 57) {
                stringBuilder2.append((char)obj5);
                return i;
            }
        }
        int i10 = 65;
        if (c >= i10 && c <= 90) {
            if (c <= 90) {
                stringBuilder2.append((char)obj5);
                return i;
            }
        }
        int i11 = 2;
        if (c < i3) {
            stringBuilder2.append('\0');
            stringBuilder2.append(c);
            return i11;
        }
        int i5 = 33;
        if (c >= i5 && c <= 47) {
            if (c <= 47) {
                stringBuilder2.append(i);
                stringBuilder2.append((char)obj5);
                return i11;
            }
        }
        int i6 = 58;
        if (c >= i6 && c <= 64) {
            if (c <= 64) {
                stringBuilder2.append(i);
                stringBuilder2.append((char)obj5);
                return i11;
            }
        }
        int i7 = 91;
        if (c >= i7 && c <= 95) {
            if (c <= 95) {
                stringBuilder2.append(i);
                stringBuilder2.append((char)obj5);
                return i11;
            }
        }
        int i8 = 96;
        if (c >= i8 && c <= 127) {
            if (c <= 127) {
                stringBuilder2.append(i11);
                stringBuilder2.append((char)obj5);
                return i11;
            }
        }
        stringBuilder2.append("\u0001\u001e");
        return obj5 += i11;
    }

    @Override // com.google.zxing.h.b.g
    public int e() {
        return 1;
    }

    @Override // com.google.zxing.h.b.g
    void f(com.google.zxing.h.b.h h, StringBuilder stringBuilder2) {
        int length;
        int length2;
        StringBuilder obj9;
        final int i4 = 3;
        length2 = 1;
        length4 %= i4;
        i6 += i2;
        h.q(i7);
        i3 -= i7;
        int i8 = 0;
        final int i9 = 254;
        if (i5 == 2) {
            stringBuilder2.append(i8);
            while (stringBuilder2.length() >= i4) {
                c.g(h, stringBuilder2);
            }
            if (h.i()) {
                h.r(i9);
            }
            h.o(i8);
        } else {
            if (length == length2 && i5 == length2) {
                if (i5 == length2) {
                } else {
                    if (i5 != 0) {
                    }
                }
            } else {
            }
        }
        IllegalStateException obj8 = new IllegalStateException("Unexpected case. Please report!");
        throw obj8;
    }
}

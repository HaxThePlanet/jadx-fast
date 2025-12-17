package com.google.zxing.h.b;

/* loaded from: classes2.dex */
final class f implements com.google.zxing.h.b.g {
    private static void b(char c, StringBuilder stringBuilder2) {
        int i;
        int i2;
        if (c >= 32 && c <= 63) {
            if (c <= 63) {
                stringBuilder2.append(c);
            }
        }
        int i3 = 64;
        if (c < i3) {
        } else {
            if (c > 94) {
            } else {
                stringBuilder2.append((char)obj2);
            }
        }
        j.e(c);
        throw 0;
    }

    private static String c(java.lang.CharSequence charSequence, int i2) {
        int charAt3;
        int charAt;
        int charAt2;
        int obj9;
        length -= i2;
        if (i == 0) {
        } else {
            charAt3 = 0;
            final int i5 = 2;
            if (i >= i5) {
                charAt = charSequence.charAt(i2 + 1);
            } else {
                charAt = charAt3;
            }
            final int i7 = 3;
            if (i >= i7) {
                charAt2 = charSequence.charAt(i2 + 2);
            } else {
                charAt2 = charAt3;
            }
            if (i >= 4) {
                charAt3 = charSequence.charAt(i2 += i7);
            }
            obj8 += charAt3;
            StringBuilder stringBuilder = new StringBuilder(i7);
            stringBuilder.append((char)obj9);
            if (i >= i5) {
                stringBuilder.append((char)i4);
            }
            if (i >= i7) {
                stringBuilder.append((char)obj8);
            }
            return stringBuilder.toString();
        }
        IllegalStateException obj8 = new IllegalStateException("StringBuilder must not be empty");
        throw obj8;
    }

    private static void e(com.google.zxing.h.b.h h, java.lang.CharSequence charSequence2) {
        int i3;
        int i;
        int i4;
        int i6;
        int i2;
        int i5;
        int obj8;
        final int i7 = 0;
        int length = charSequence2.length();
        if (length == 0) {
            try {
                h.o(i7);
                i3 = 2;
                i = 1;
                h.p();
                i2 = h.f();
                if (i2 > i13 -= i19) {
                }
                h.q(i14 += i);
                i16 -= i5;
            }
            if (length > 4) {
            } else {
                length -= i;
                obj8 = f.c(charSequence2, i7);
                if (z ^= i != 0 && i8 <= i3) {
                    if (i8 <= i3) {
                    } else {
                        i = i7;
                    }
                } else {
                }
                h.q(i9 += i8);
                if (i8 <= i3 && i11 -= i18 >= 3) {
                    h.q(i9 += i8);
                    if (i11 -= i18 >= 3) {
                        try {
                            h.q(i12 += length2);
                            i = i7;
                            if (i != 0) {
                            } else {
                            }
                            h.k();
                            h.f = obj8 -= i8;
                            h.s(obj8);
                            h.o(i7);
                            obj8 = new IllegalStateException("Count must not exceed 4");
                            throw obj8;
                            h.o(obj0);
                            throw charSequence2;
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.zxing.h.b.g
    public void a(com.google.zxing.h.b.h h) {
        int length;
        int i;
        int i2;
        int i3;
        StringBuilder stringBuilder = new StringBuilder();
        while (h.i()) {
            f.b(h.c(), stringBuilder);
            h.f = i5++;
            i = 4;
            if (stringBuilder.length() >= i) {
                break;
            } else {
            }
            length = 0;
            h.s(f.c(stringBuilder, length));
            stringBuilder.delete(length, i);
            if (j.n(h.d(), h.f, d()) != d()) {
                break;
            } else {
            }
        }
        stringBuilder.append('\u001f');
        f.e(h, stringBuilder);
    }

    @Override // com.google.zxing.h.b.g
    public int d() {
        return 4;
    }
}

package com.google.zxing.h.b;

/* loaded from: classes2.dex */
final class b implements com.google.zxing.h.b.g {
    private static char c(char c, int i2) {
        final int i = 255;
        c += obj2;
        if (obj1 <= i) {
            return (char)obj1;
        }
        return (char)obj1;
    }

    @Override // com.google.zxing.h.b.g
    public void a(com.google.zxing.h.b.h h) {
        int i2;
        int i;
        char i3;
        int i4;
        int i7;
        int i6;
        int i5;
        int z;
        StringBuilder stringBuilder = new StringBuilder();
        i2 = 0;
        stringBuilder.append(i2);
        i4 = 1;
        while (h.i()) {
            stringBuilder.append(h.c());
            h.f = i9 += i4;
            if (j.n(h.d(), h.f, b()) != b()) {
                break;
            } else {
            }
            i4 = 1;
        }
        length -= i4;
        i12 += i4;
        h.q(i13);
        i6 = i15 -= i13 > 0 ? i4 : i2;
        if (!h.i()) {
            if (i6 != 0) {
                i6 = 249;
                if (i3 <= i6) {
                    stringBuilder.setCharAt(i2, (char)i3);
                    while (i2 < stringBuilder.length()) {
                        h.r(b.c(stringBuilder.charAt(i2), i19 += i4));
                        i2++;
                    }
                } else {
                    if (i3 > 1555) {
                    } else {
                        stringBuilder.setCharAt(i2, (char)z);
                        stringBuilder.insert(i4, (char)i8);
                    }
                }
            } else {
            }
        } else {
        }
        IllegalStateException obj7 = new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(i3)));
        throw obj7;
    }

    @Override // com.google.zxing.h.b.g
    public int b() {
        return 5;
    }
}

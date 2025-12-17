package com.google.zxing.h.b;

/* loaded from: classes2.dex */
final class m extends com.google.zxing.h.b.c {
    @Override // com.google.zxing.h.b.c
    int c(char c, StringBuilder stringBuilder2) {
        int i2;
        int i;
        int i3 = 32;
        i2 = 1;
        if (c == i3) {
            stringBuilder2.append('\u0003');
            return i2;
        }
        int i11 = 48;
        if (c >= i11 && c <= 57) {
            if (c <= 57) {
                stringBuilder2.append((char)obj5);
                return i2;
            }
        }
        int i12 = 97;
        if (c >= i12 && c <= 122) {
            if (c <= 122) {
                stringBuilder2.append((char)obj5);
                return i2;
            }
        }
        int i13 = 2;
        if (c < i3) {
            stringBuilder2.append('\0');
            stringBuilder2.append(c);
            return i13;
        }
        int i5 = 33;
        if (c >= i5 && c <= 47) {
            if (c <= 47) {
                stringBuilder2.append(i2);
                stringBuilder2.append((char)obj5);
                return i13;
            }
        }
        int i6 = 58;
        if (c >= i6 && c <= 64) {
            if (c <= 64) {
                stringBuilder2.append(i2);
                stringBuilder2.append((char)obj5);
                return i13;
            }
        }
        int i7 = 91;
        if (c >= i7 && c <= 95) {
            if (c <= 95) {
                stringBuilder2.append(i2);
                stringBuilder2.append((char)obj5);
                return i13;
            }
        }
        int i8 = 96;
        if (c == i8) {
            stringBuilder2.append(i13);
            stringBuilder2.append((char)obj5);
            return i13;
        }
        int i9 = 65;
        if (c >= i9 && c <= 90) {
            if (c <= 90) {
                stringBuilder2.append(i13);
                stringBuilder2.append((char)obj5);
                return i13;
            }
        }
        int i10 = 123;
        if (c >= i10 && c <= 127) {
            if (c <= 127) {
                stringBuilder2.append(i13);
                stringBuilder2.append((char)obj5);
                return i13;
            }
        }
        stringBuilder2.append("\u0001\u001e");
        return obj5 += i13;
    }

    @Override // com.google.zxing.h.b.c
    public int e() {
        return 2;
    }
}

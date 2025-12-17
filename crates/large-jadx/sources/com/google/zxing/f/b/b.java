package com.google.zxing.f.b;

import com.google.zxing.g.a;

/* loaded from: classes2.dex */
final class b extends com.google.zxing.f.b.g {

    private final short c;
    private final short d;
    b(com.google.zxing.f.b.g g, int i2, int i3) {
        super(g);
        this.c = (short)i2;
        this.d = (short)i3;
    }

    @Override // com.google.zxing.f.b.g
    public void c(a a, byte[] b2Arr2) {
        int i;
        byte b;
        short s;
        int i3;
        int i5;
        int i2;
        int i4;
        i = 0;
        s = this.d;
        while (i < s) {
            i5 = 62;
            i2 = 31;
            if (i != 0) {
            } else {
            }
            s = 5;
            a.c(i2, s);
            i4 = this.d;
            if (i4 > i5) {
            } else {
            }
            if (i == 0) {
            } else {
            }
            a.c(i4 += -31, s);
            a.c(b2Arr2[s2 += i], 8);
            i++;
            s = this.d;
            a.c(Math.min(i4, i2), s);
            a.c(i4 += -31, 16);
            if (i == i2 && s <= i5) {
            }
            if (s <= i5) {
            }
        }
    }

    @Override // com.google.zxing.f.b.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(this.c);
        stringBuilder.append("::");
        stringBuilder.append(i--);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}

package com.google.zxing.f.b;

import com.google.zxing.g.a;

/* loaded from: classes2.dex */
final class e extends com.google.zxing.f.b.g {

    private final short c;
    private final short d;
    e(com.google.zxing.f.b.g g, int i2, int i3) {
        super(g);
        this.c = (short)i2;
        this.d = (short)i3;
    }

    @Override // com.google.zxing.f.b.g
    void c(a a, byte[] b2Arr2) {
        a.c(this.c, this.d);
    }

    @Override // com.google.zxing.f.b.g
    public String toString() {
        short s2 = this.d;
        final int i6 = 1;
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(Integer.toBinaryString(i2 |= i9).substring(i6));
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}

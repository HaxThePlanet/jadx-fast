package com.google.zxing.k.b;

/* loaded from: classes2.dex */
public enum a {

    L(true),
    M(false),
    Q(3),
    H(2);

    private final int bits;
    public static com.google.zxing.k.b.a forBits(int i) {
        com.google.zxing.k.b.a[] fOR_BITS;
        int length;
        if (i < 0) {
        } else {
            fOR_BITS = a.FOR_BITS;
            if (i >= fOR_BITS.length) {
            } else {
                return fOR_BITS[i];
            }
        }
        IllegalArgumentException obj2 = new IllegalArgumentException();
        throw obj2;
    }

    @Override // java.lang.Enum
    public int getBits() {
        return this.bits;
    }
}

package com.google.zxing.f.b;

import com.google.zxing.g.a;

/* loaded from: classes2.dex */
abstract class g {

    static final com.google.zxing.f.b.g b;
    private final com.google.zxing.f.b.g a;
    static {
        final int i2 = 0;
        e eVar = new e(0, i2, i2);
        g.b = eVar;
    }

    g(com.google.zxing.f.b.g g) {
        super();
        this.a = g;
    }

    final com.google.zxing.f.b.g a(int i, int i2) {
        e eVar = new e(this, i, i2);
        return eVar;
    }

    final com.google.zxing.f.b.g b(int i, int i2) {
        b bVar = new b(this, i, i2);
        return bVar;
    }

    abstract void c(a a, byte[] b2Arr2);

    final com.google.zxing.f.b.g d() {
        return this.a;
    }
}

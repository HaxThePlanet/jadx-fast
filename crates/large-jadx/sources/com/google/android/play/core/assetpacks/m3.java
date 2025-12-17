package com.google.android.play.core.assetpacks;

/* loaded from: classes2.dex */
abstract class m3 {
    abstract int a();

    abstract long b();

    abstract String c();

    abstract boolean d();

    abstract boolean e();

    abstract byte[] f();

    final boolean g() {
        if (c() == null) {
            return 0;
        }
        return c().endsWith("/");
    }

    final boolean h() {
        if (a() == 0) {
            return 1;
        }
        return 0;
    }
}

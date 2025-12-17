package com.google.android.play.core.assetpacks;

/* loaded from: classes2.dex */
public final class f2 implements Runnable {

    public final com.google.android.play.core.assetpacks.h2 a;
    public final int b;
    public final String c;
    public f2(com.google.android.play.core.assetpacks.h2 h2, int i2, String string3) {
        super();
        this.a = h2;
        this.b = i2;
        this.c = string3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.j(this.b, this.c);
    }
}

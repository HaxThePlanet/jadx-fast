package com.google.android.play.core.assetpacks;

/* loaded from: classes2.dex */
public final class r2 implements Runnable {

    public final com.google.android.play.core.assetpacks.s2 a;
    public final com.google.android.play.core.assetpacks.p2 b;
    public r2(com.google.android.play.core.assetpacks.s2 s2, com.google.android.play.core.assetpacks.p2 p22) {
        super();
        this.a = s2;
        this.b = p22;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}

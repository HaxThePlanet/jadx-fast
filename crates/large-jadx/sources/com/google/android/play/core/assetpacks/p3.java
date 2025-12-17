package com.google.android.play.core.assetpacks;

/* loaded from: classes2.dex */
public final class p3 implements Runnable {

    public final com.google.android.play.core.assetpacks.q3 a;
    public p3(com.google.android.play.core.assetpacks.q3 q3) {
        super();
        this.a = q3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}

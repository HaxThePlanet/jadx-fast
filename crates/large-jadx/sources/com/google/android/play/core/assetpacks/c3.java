package com.google.android.play.core.assetpacks;

/* loaded from: classes2.dex */
public final class c3 implements Runnable {

    public final com.google.android.play.core.assetpacks.d3 a;
    public final com.google.android.play.core.assetpacks.b3 b;
    public c3(com.google.android.play.core.assetpacks.d3 d3, com.google.android.play.core.assetpacks.b3 b32) {
        super();
        this.a = d3;
        this.b = b32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}

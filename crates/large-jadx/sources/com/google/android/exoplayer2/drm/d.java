package com.google.android.exoplayer2.drm;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    public final com.google.android.exoplayer2.drm.DefaultDrmSessionManager.e a;
    public d(com.google.android.exoplayer2.drm.DefaultDrmSessionManager.e defaultDrmSessionManager$e) {
        super();
        this.a = e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.g();
    }
}

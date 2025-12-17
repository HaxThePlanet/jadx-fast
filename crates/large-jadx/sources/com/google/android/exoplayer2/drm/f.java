package com.google.android.exoplayer2.drm;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    public final com.google.android.exoplayer2.drm.DefaultDrmSession a;
    public f(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession) {
        super();
        this.a = defaultDrmSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultDrmSessionManager.g.c(this.a);
    }
}

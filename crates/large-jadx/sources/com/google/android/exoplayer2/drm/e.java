package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.i1;

/* loaded from: classes2.dex */
public final class e implements Runnable {

    public final com.google.android.exoplayer2.drm.DefaultDrmSessionManager.e a;
    public final i1 b;
    public e(com.google.android.exoplayer2.drm.DefaultDrmSessionManager.e defaultDrmSessionManager$e, i1 i12) {
        super();
        this.a = e;
        this.b = i12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e(this.b);
    }
}

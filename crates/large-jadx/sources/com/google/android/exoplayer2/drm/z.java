package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.w0;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class z implements com.google.android.exoplayer2.drm.DrmSession {

    private final com.google.android.exoplayer2.drm.DrmSession.DrmSessionException a;
    public z(com.google.android.exoplayer2.drm.DrmSession.DrmSessionException drmSession$DrmSessionException) {
        super();
        g.e(drmSessionException);
        this.a = (DrmSession.DrmSessionException)drmSessionException;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(com.google.android.exoplayer2.drm.u.a u$a) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void b(com.google.android.exoplayer2.drm.u.a u$a) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID d() {
        return w0.a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean e() {
        return 0;
    }

    public Map<String, String> f() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public com.google.android.exoplayer2.drm.a0 g() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public com.google.android.exoplayer2.drm.DrmSession.DrmSessionException getError() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }
}

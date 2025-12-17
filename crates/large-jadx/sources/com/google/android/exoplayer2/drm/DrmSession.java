package com.google.android.exoplayer2.drm;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public interface DrmSession {

    public static class DrmSessionException extends IOException {

        public final int errorCode;
        public DrmSessionException(Throwable throwable, int i2) {
            super(throwable);
            this.errorCode = i2;
        }
    }
    public static void c(com.google.android.exoplayer2.drm.DrmSession drmSession, com.google.android.exoplayer2.drm.DrmSession drmSession2) {
        if (drmSession == drmSession2) {
        }
        final int i = 0;
        if (drmSession2 != null) {
            drmSession2.a(i);
        }
        if (drmSession != null) {
            drmSession.b(i);
        }
    }

    public abstract void a(com.google.android.exoplayer2.drm.u.a u$a);

    public abstract void b(com.google.android.exoplayer2.drm.u.a u$a);

    public abstract UUID d();

    public boolean e() {
        return 0;
    }

    public abstract Map<String, String> f();

    public abstract com.google.android.exoplayer2.drm.a0 g();

    public abstract com.google.android.exoplayer2.drm.DrmSession.DrmSessionException getError();

    public abstract int getState();
}

package com.google.android.exoplayer2.drm;

/* loaded from: classes2.dex */
public final class UnsupportedDrmException extends Exception {

    public final int reason;
    public UnsupportedDrmException(int i) {
        super();
        this.reason = i;
    }

    public UnsupportedDrmException(int i, Exception exception2) {
        super(exception2);
        this.reason = i;
    }
}

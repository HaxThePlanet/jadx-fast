package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class IllegalSeekPositionException extends java.lang.IllegalStateException {

    public final long positionMs;
    public final com.google.android.exoplayer2.g2 timeline;
    public final int windowIndex;
    public IllegalSeekPositionException(com.google.android.exoplayer2.g2 g2, int i2, long l3) {
        super();
        this.timeline = g2;
        this.windowIndex = i2;
        this.positionMs = l3;
    }
}

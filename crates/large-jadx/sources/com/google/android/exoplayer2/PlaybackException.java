package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public class PlaybackException extends Exception {

    public final int errorCode;
    public final long timestampMs;
    static {
        final com.google.android.exoplayer2.p0 p0Var = p0.a;
    }

    protected PlaybackException(String string, Throwable throwable2, int i3, long l4) {
        super(string, throwable2);
        this.errorCode = i3;
        this.timestampMs = l4;
    }
}

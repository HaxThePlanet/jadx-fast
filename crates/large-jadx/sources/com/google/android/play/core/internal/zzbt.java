package com.google.android.play.core.internal;

/* loaded from: classes2.dex */
public final class zzbt extends RuntimeException {
    public zzbt(String string) {
        super(string);
    }

    public zzbt(String string, Throwable throwable2) {
        super("Failed to initialize FileStorage", throwable2);
    }
}

package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class ExoTimeoutException extends RuntimeException {

    public final int timeoutOperation;
    public ExoTimeoutException(int i) {
        super(ExoTimeoutException.a(i));
        this.timeoutOperation = i;
    }

    private static String a(int i) {
        if (i != 1 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    return "Undefined timeout.";
                }
                return "Detaching surface timed out.";
            }
            return "Setting foreground mode timed out.";
        }
        return "Player release timed out.";
    }
}

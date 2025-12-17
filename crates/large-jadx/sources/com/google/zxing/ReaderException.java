package com.google.zxing;

/* loaded from: classes2.dex */
public abstract class ReaderException extends Exception {

    protected static final boolean a = false;
    protected static final java.lang.StackTraceElement[] b;
    static {
        final int i3 = 0;
        if (System.getProperty("surefire.test.class.path") != null) {
            int i = 1;
        }
        int i2 = i3;
        ReaderException.b = new StackTraceElement[i3];
    }

    @Override // java.lang.Exception
    public final Throwable fillInStackTrace() {
        return null;
        synchronized (this) {
            return null;
        }
    }
}

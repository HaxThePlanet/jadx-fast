package com.google.zxing;

/* loaded from: classes2.dex */
public final class FormatException extends com.google.zxing.ReaderException {

    private static final com.google.zxing.FormatException c;
    static {
        FormatException formatException = new FormatException();
        FormatException.c = formatException;
        formatException.setStackTrace(ReaderException.b);
    }

    public static com.google.zxing.FormatException a() {
        if (ReaderException.a) {
            FormatException formatException = new FormatException();
            return formatException;
        }
        return FormatException.c;
    }
}

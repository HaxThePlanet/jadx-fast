package com.google.android.exoplayer2;

import java.io.IOException;

/* loaded from: classes.dex */
public class ParserException extends IOException {

    public final boolean contentIsMalformed;
    public final int dataType;
    protected ParserException(String string, Throwable throwable2, boolean z3, int i4) {
        super(string, throwable2);
        this.contentIsMalformed = z3;
        this.dataType = i4;
    }

    public static com.google.android.exoplayer2.ParserException a(String string, Throwable throwable2) {
        final int i = 1;
        ParserException parserException = new ParserException(string, throwable2, i, i);
        return parserException;
    }

    public static com.google.android.exoplayer2.ParserException b(String string, Throwable throwable2) {
        ParserException parserException = new ParserException(string, throwable2, 1, 0);
        return parserException;
    }

    public static com.google.android.exoplayer2.ParserException c(String string, Throwable throwable2) {
        ParserException parserException = new ParserException(string, throwable2, 1, 4);
        return parserException;
    }

    public static com.google.android.exoplayer2.ParserException d(String string) {
        ParserException parserException = new ParserException(string, 0, 0, 1);
        return parserException;
    }
}

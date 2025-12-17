package com.google.gson.stream;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class MalformedJsonException extends IOException {

    private static final long serialVersionUID = 1L;
    public MalformedJsonException(String string) {
        super(string);
    }

    public MalformedJsonException(String string, Throwable throwable2) {
        super(string);
        initCause(throwable2);
    }

    public MalformedJsonException(Throwable throwable) {
        super();
        initCause(throwable);
    }
}

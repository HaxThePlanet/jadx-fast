package com.squareup.okhttp.internal.http;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class RequestException extends Exception {
    @Override // java.lang.Exception
    public IOException a() {
        return (IOException)super.getCause();
    }

    @Override // java.lang.Exception
    public Throwable getCause() {
        return a();
    }
}

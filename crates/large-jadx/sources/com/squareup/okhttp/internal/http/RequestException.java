package com.squareup.okhttp.internal.http;

import java.io.IOException;

/* compiled from: RequestException.java */
/* loaded from: classes2.dex */
public final class RequestException extends Exception {
    @Override // java.lang.Exception
    public IOException a() {
        return (IOException)super.getCause();
    }
}

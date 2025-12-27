package com.bumptech.glide.load;

import java.io.IOException;

/* compiled from: HttpException.java */
/* loaded from: classes.dex */
public final class HttpException extends IOException {

    private static final long serialVersionUID = 1L;
    private final int statusCode;
    public HttpException(int i) {
        this("Http request failed", i);
    }

    public HttpException(String str, int i) {
        this(str, i, null);
    }

    public HttpException(String str, int i, Throwable th) {
        final StringBuilder stringBuilder = new StringBuilder();
        String str2 = ", status code: ";
        str3 = str + str2 + i;
        super(str3, th);
        this.statusCode = i;
    }
}

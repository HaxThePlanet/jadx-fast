package com.bumptech.glide.load;

import java.io.IOException;

/* loaded from: classes.dex */
public final class HttpException extends IOException {

    private static final long serialVersionUID = 1L;
    private final int statusCode;
    public HttpException(int i) {
        super("Http request failed", i);
    }

    public HttpException(String string, int i2) {
        super(string, i2, 0);
    }

    public HttpException(String string, int i2, Throwable throwable3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(", status code: ");
        stringBuilder.append(i2);
        super(stringBuilder.toString(), throwable3);
        this.statusCode = i2;
    }
}

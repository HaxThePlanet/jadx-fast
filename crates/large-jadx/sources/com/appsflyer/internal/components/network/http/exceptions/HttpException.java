package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.bj;
import java.io.IOException;

/* loaded from: classes.dex */
public class HttpException extends IOException {

    private final bj AFInAppEventType;
    public HttpException(Throwable throwable, bj bj2) {
        super(throwable.getMessage(), throwable);
        this.AFInAppEventType = bj2;
    }

    @Override // java.io.IOException
    public bj getMetrics() {
        return this.AFInAppEventType;
    }
}

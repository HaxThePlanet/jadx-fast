package com.squareup.okhttp.internal.http;

import java.io.IOException;

/* compiled from: RouteException.java */
/* loaded from: classes2.dex */
public final class RouteException extends Exception {

    private IOException lastException;
    static {
        try {
            Class[] arr = new Class[1];
            Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
        } catch (Exception unused) {
            return;
        }
    }
}

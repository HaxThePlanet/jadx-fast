package com.amplitude.api;

import f.a.b.b;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public final class c implements b {

    public static final com.amplitude.api.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    @Override // f.a.b.b
    public final Object get() {
        OkHttpClient okHttpClient = new OkHttpClient();
        return okHttpClient;
    }
}

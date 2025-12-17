package com.amplitude.api;

import f.a.b.b;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Request;

/* loaded from: classes.dex */
public final class b implements Call.Factory {

    public final b a;
    public b(b b) {
        super();
        this.a = b;
    }

    @Override // okhttp3.Call$Factory
    public final Call newCall(Request request) {
        return f.G(this.a, request);
    }
}

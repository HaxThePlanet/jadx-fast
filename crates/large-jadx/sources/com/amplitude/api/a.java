package com.amplitude.api;

import okhttp3.Call.Factory;

/* loaded from: classes.dex */
public final class a implements Runnable {

    public final com.amplitude.api.f a;
    public final Call.Factory b;
    public final String c;
    public final com.amplitude.api.f v;
    public a(com.amplitude.api.f f, Call.Factory call$Factory2, String string3, com.amplitude.api.f f4) {
        super();
        this.a = f;
        this.b = factory2;
        this.c = string3;
        this.v = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.F(this.b, this.c, this.v);
    }
}

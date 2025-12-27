package com.amplitude.api;

import f.a.b.b;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Request;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements Call.Factory {

    public final /* synthetic */ b a;
    public /* synthetic */ b(b bVar) {
        super();
        this.a = bVar;
    }

    @Override // okhttp3.Call$Factory
    public final Call newCall(Request request) {
        return f.G(this.a, request);
    }
}

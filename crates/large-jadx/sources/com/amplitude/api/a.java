package com.amplitude.api;

import okhttp3.Call.Factory;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements Runnable {

    public final /* synthetic */ f a;
    public final /* synthetic */ Call.Factory b;
    public final /* synthetic */ String c;
    public final /* synthetic */ f v;
    public /* synthetic */ a(f fVar, Call.Factory factory, String str, f fVar2) {
        super();
        this.a = fVar;
        this.b = factory;
        this.c = str;
        this.v = fVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.F(this.b, this.c, this.v);
    }
}

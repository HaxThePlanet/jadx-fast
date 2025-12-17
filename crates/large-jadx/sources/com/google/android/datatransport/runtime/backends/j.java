package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import f.c.a.b.i.b0.a;
import f.c.a.b.i.w.b.b;
import j.a.a;

/* loaded from: classes.dex */
public final class j implements b<com.google.android.datatransport.runtime.backends.i> {

    private final a<Context> a;
    private final a<a> b;
    private final a<a> c;
    public j(a<Context> a, a<a> a2, a<a> a3) {
        super();
        this.a = a;
        this.b = a2;
        this.c = a3;
    }

    public static com.google.android.datatransport.runtime.backends.j a(a<Context> a, a<a> a2, a<a> a3) {
        j jVar = new j(a, a2, a3);
        return jVar;
    }

    public static com.google.android.datatransport.runtime.backends.i c(Context context, a a2, a a3) {
        i iVar = new i(context, a2, a3);
        return iVar;
    }

    @Override // f.c.a.b.i.w.b.b
    public com.google.android.datatransport.runtime.backends.i b() {
        return j.c((Context)this.a.get(), (a)this.b.get(), (a)this.c.get());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}

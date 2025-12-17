package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import f.c.a.b.i.w.b.b;
import j.a.a;

/* loaded from: classes.dex */
public final class l implements b<com.google.android.datatransport.runtime.backends.k> {

    private final a<Context> a;
    private final a<com.google.android.datatransport.runtime.backends.i> b;
    public l(a<Context> a, a<com.google.android.datatransport.runtime.backends.i> a2) {
        super();
        this.a = a;
        this.b = a2;
    }

    public static com.google.android.datatransport.runtime.backends.l a(a<Context> a, a<com.google.android.datatransport.runtime.backends.i> a2) {
        l lVar = new l(a, a2);
        return lVar;
    }

    public static com.google.android.datatransport.runtime.backends.k c(Context context, Object object2) {
        k kVar = new k(context, (i)object2);
        return kVar;
    }

    @Override // f.c.a.b.i.w.b.b
    public com.google.android.datatransport.runtime.backends.k b() {
        return l.c((Context)this.a.get(), this.b.get());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}

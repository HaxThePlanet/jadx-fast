package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import f.c.a.b.i.b0.a;

/* loaded from: classes.dex */
class i {

    private final Context a;
    private final a b;
    private final a c;
    i(Context context, a a2, a a3) {
        super();
        this.a = context;
        this.b = a2;
        this.c = a3;
    }

    com.google.android.datatransport.runtime.backends.h a(String string) {
        return h.a(this.a, this.b, this.c, string);
    }
}

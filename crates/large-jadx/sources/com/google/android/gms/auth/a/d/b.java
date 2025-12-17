package com.google.android.gms.auth.a.d;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.d.c;
import com.google.android.gms.common.api.a.g;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.a;
import com.google.android.gms.tasks.j;
import f.c.a.d.b.b.j;

/* loaded from: classes2.dex */
public abstract class b extends c<a.d.c> {

    private static final a.g<j> a;
    private static final a.a<j, a.d.c> b;
    private static final a<a.d.c> c;
    static {
        a.g gVar = new a.g();
        b.a = gVar;
        c cVar = new c();
        b.b = cVar;
        a aVar = new a("SmsRetriever.API", cVar, gVar);
        b.c = aVar;
    }

    public b(Context context) {
        super(context, b.c, 0, c.a.c);
    }

    public abstract j<Void> b();
}

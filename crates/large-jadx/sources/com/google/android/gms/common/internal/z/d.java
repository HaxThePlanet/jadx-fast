package com.google.android.gms.common.internal.z;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.g;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.a;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.t.a;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.tasks.j;
import f.c.a.d.b.e.d;

/* loaded from: classes2.dex */
public final class d extends c<y> implements x {

    private static final a.g<com.google.android.gms.common.internal.z.e> a;
    private static final a.a<com.google.android.gms.common.internal.z.e, y> b;
    private static final a<y> c;
    public static final int d;
    static {
        a.g gVar = new a.g();
        d.a = gVar;
        c cVar = new c();
        d.b = cVar;
        a aVar = new a("ClientTelemetry.API", cVar, gVar);
        d.c = aVar;
    }

    public d(Context context, y y2) {
        super(context, d.c, y2, c.a.c);
    }

    public final j<Void> a(v v) {
        final t.a builder = t.builder();
        com.google.android.gms.common.d[] arr = new d[1];
        final int i2 = 0;
        arr[i2] = d.a;
        builder.d(arr);
        builder.c(i2);
        b bVar = new b(v);
        builder.b(bVar);
        return doBestEffortWrite(builder.a());
    }
}

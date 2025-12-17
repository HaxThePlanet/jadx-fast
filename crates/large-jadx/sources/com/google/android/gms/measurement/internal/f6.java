package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.o1;

/* loaded from: classes2.dex */
public final class f6 {

    final Context a;
    String b;
    String c;
    String d;
    Boolean e;
    long f;
    o1 g;
    boolean h = true;
    final Long i;
    String j;
    public f6(Context context, o1 o12, Long long3) {
        long l;
        Object obj4;
        Object obj5;
        super();
        r.j(context);
        obj4 = context.getApplicationContext();
        r.j(obj4);
        this.a = obj4;
        this.i = long3;
        this.g = o12;
        this.b = o12.x;
        this.c = o12.w;
        this.d = o12.v;
        this.h = o12.c;
        this.f = o12.b;
        this.j = o12.z;
        obj4 = o12.y;
        if (o12 != null && obj4 != null) {
            this.g = o12;
            this.b = o12.x;
            this.c = o12.w;
            this.d = o12.v;
            this.h = o12.c;
            this.f = o12.b;
            this.j = o12.z;
            obj4 = o12.y;
            if (obj4 != null) {
                this.e = Boolean.valueOf(obj4.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}

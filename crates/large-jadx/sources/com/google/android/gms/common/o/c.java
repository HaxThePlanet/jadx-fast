package com.google.android.gms.common.o;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
public class c {

    private static com.google.android.gms.common.o.c b;
    private com.google.android.gms.common.o.b a = null;
    static {
        c cVar = new c();
        c.b = cVar;
    }

    public c() {
        super();
        final int i = 0;
    }

    public static com.google.android.gms.common.o.b a(Context context) {
        return c.b.b(context);
    }

    public final com.google.android.gms.common.o.b b(Context context) {
        com.google.android.gms.common.o.b bVar;
        Object obj2;
        synchronized (this) {
            try {
                if (context.getApplicationContext() != null) {
                }
                obj2 = context.getApplicationContext();
                bVar = new b(obj2);
                this.a = bVar;
                return this.a;
                throw context;
            }
        }
    }
}

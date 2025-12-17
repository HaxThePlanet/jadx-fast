package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.c;

/* loaded from: classes2.dex */
final class j6 implements com.google.android.gms.internal.measurement.g6 {

    private static com.google.android.gms.internal.measurement.j6 c;
    private final Context a;
    private final ContentObserver b;
    private j6() {
        super();
        final int i = 0;
        this.a = i;
        this.b = i;
    }

    private j6(Context context) {
        super();
        this.a = context;
        i6 i6Var = new i6(this, 0);
        this.b = i6Var;
        context.getContentResolver().registerContentObserver(w5.a, true, i6Var);
    }

    static com.google.android.gms.internal.measurement.j6 b(Context context) {
        com.google.android.gms.internal.measurement.j6 j6Var;
        final Class<com.google.android.gms.internal.measurement.j6> obj = j6.class;
        synchronized (obj) {
            if (c.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                j6Var = new j6(context);
            } else {
                try {
                    j6Var = new j6();
                    j6.c = j6Var;
                    return j6.c;
                    throw context;
                }
            }
        }
    }

    static void e() {
        Object contentResolver;
        Object context;
        final Class<com.google.android.gms.internal.measurement.j6> obj = j6.class;
        contentResolver = j6.c;
        synchronized (obj) {
            context = contentResolver.a;
            if (context != null) {
                if (contentResolver.b != null) {
                    try {
                        context.getContentResolver().unregisterContentObserver(j6Var.b);
                        j6.c = 0;
                        throw th;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.g6
    public final Object a(String string) {
        return c(string);
    }

    @Override // com.google.android.gms.internal.measurement.g6
    public final String c(String string) {
        if (this.a == null) {
            return null;
        }
        h6 h6Var = new h6(this, string);
        return (String)e6.a(h6Var);
    }

    @Override // com.google.android.gms.internal.measurement.g6
    final String d(String string) {
        return w5.a(this.a.getContentResolver(), string, 0);
    }
}

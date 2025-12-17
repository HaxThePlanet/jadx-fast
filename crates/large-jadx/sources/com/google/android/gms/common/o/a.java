package com.google.android.gms.common.o;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.l;

/* loaded from: classes2.dex */
public class a {

    private static Context a;
    private static Boolean b;
    public static boolean a(Context context) {
        String str;
        Boolean bool;
        Boolean obj4;
        final Class<com.google.android.gms.common.o.a> obj = a.class;
        final Context applicationContext = context.getApplicationContext();
        Context context2 = a.a;
        synchronized (obj) {
            bool = a.b;
            if (bool != null) {
                if (context2 != applicationContext) {
                    try {
                        return bool.booleanValue();
                        a.b = 0;
                        if (l.h()) {
                        } else {
                        }
                        a.b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        a.b = Boolean.TRUE;
                        context = Boolean.FALSE;
                        a.b = context;
                        a.a = applicationContext;
                        return a.b.booleanValue();
                        throw context;
                    } catch (java.lang.ClassNotFoundException classNotFound) {
                    } catch (Throwable th1) {
                    }
                }
            }
        }
    }
}

package com.iterable.iterableapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class g {

    static com.iterable.iterableapi.g.a a;

    static class a {
        private boolean a(com.iterable.iterableapi.e e, com.iterable.iterableapi.f f2) {
            String empty;
            if (e.e() != null && !e.e().isEmpty() && qVar.c != null) {
                if (!e.e().isEmpty()) {
                    if (qVar.c != null) {
                        return qVar2.c.a(e, f2);
                    }
                }
            }
            return 0;
        }

        private boolean c(Context context, Uri uri2, com.iterable.iterableapi.f f3) {
            com.iterable.iterableapi.y0 y0Var;
            Object intentActivities;
            int size;
            String packageName2;
            String packageName;
            com.iterable.iterableapi.f obj10;
            final int i2 = 0;
            if (!z0.h(uri2.toString())) {
                return i2;
            }
            final int i3 = 1;
            if (qVar.b != null && qVar2.b.a(uri2, f3)) {
                if (qVar2.b.a(uri2, f3)) {
                    return i3;
                }
            }
            obj10 = new Intent("android.intent.action.VIEW");
            obj10.setData(uri2);
            intentActivities = context.getPackageManager().queryIntentActivities(obj10, i2);
            final String str2 = "IterableActionRunner";
            if (intentActivities.size() > i3) {
                intentActivities = intentActivities.iterator();
                while (intentActivities.hasNext()) {
                    size = intentActivities.next();
                    if (activityInfo2.packageName.equals(context.getPackageName())) {
                        break;
                    } else {
                    }
                }
            }
            obj10.setFlags(872415232);
            if (obj10.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(obj10);
                return i3;
            }
            StringBuilder obj8 = new StringBuilder();
            obj8.append("Could not find activities to handle deep link:");
            obj8.append(uri2);
            j0.c(str2, obj8.toString());
            return i2;
        }

        boolean b(Context context, com.iterable.iterableapi.e e2, com.iterable.iterableapi.h h3) {
            if (e2 == null) {
                return 0;
            }
            f fVar = new f(e2, h3);
            if (e2.f("openUrl")) {
                return c(context, Uri.parse(e2.d()), fVar);
            }
            return a(e2, fVar);
        }
    }
    static {
        g.a aVar = new g.a();
        g.a = aVar;
    }

    static boolean a(Context context, com.iterable.iterableapi.e e2, com.iterable.iterableapi.h h3) {
        return g.a.b(context, e2, h3);
    }
}

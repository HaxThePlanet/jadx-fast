package com.iterable.iterableapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* compiled from: IterableActionRunner.java */
/* loaded from: classes2.dex */
class g {

    static g.a a;

    static class a {
        a() {
            super();
        }

        private boolean a(e eVar, f fVar) {
            if (eVar.e() != null) {
                if (!eVar.e().isEmpty()) {
                    if (j.p.b.c != null) {
                        return j.p.b.c.a(eVar, fVar);
                    }
                }
            }
            return false;
        }

        private boolean c(Context context, Uri uri, f fVar) {
            boolean equals;
            String packageName;
            final int i2 = 0;
            if (!z0.h(uri.toString())) {
                return false;
            }
            final int i3 = 1;
            if (j.p.b.b != null && j.p.b.b.a(uri, fVar)) {
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            List intentActivities = context.getPackageManager().queryIntentActivities(intent, i2);
            final String str3 = "IterableActionRunner";
            if (intentActivities.size() > i3) {
                Iterator it = intentActivities.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    if (item.activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            intent.setFlags(872415232);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return true;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            String str6 = "Could not find activities to handle deep link:";
            str5 = str6 + uri;
            j0.c(str3, str5);
            return false;
        }

        boolean b(Context context, e eVar, h hVar) {
            if (eVar == null) {
                return false;
            }
            final com.iterable.iterableapi.f fVar = new f(eVar, hVar);
            if (eVar.f("openUrl")) {
                return c(context, Uri.parse(eVar.d()), fVar);
            }
            return a(eVar, fVar);
        }
    }
    static {
        g.a = new g.a();
    }

    static boolean a(Context context, e eVar, h hVar) {
        return g.a.b(context, eVar, hVar);
    }
}

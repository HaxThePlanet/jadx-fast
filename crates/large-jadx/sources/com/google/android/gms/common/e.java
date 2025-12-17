package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.core.app.j.c;
import androidx.core.app.j.e;
import androidx.fragment.app.e;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.api.internal.n0;
import com.google.android.gms.common.api.internal.o0;
import com.google.android.gms.common.internal.d0;
import com.google.android.gms.common.internal.g0;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.i;
import com.google.android.gms.common.util.l;
import f.c.a.d.a.a;
import f.c.a.d.a.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class e extends com.google.android.gms.common.f {

    private static final Object d;
    private static final com.google.android.gms.common.e e;
    private String c;
    static {
        Object object = new Object();
        e.d = object;
        e eVar = new e();
        e.e = eVar;
    }

    public static com.google.android.gms.common.e o() {
        return e.e;
    }

    public Intent b(Context context, int i2, String string3) {
        return super.b(context, i2, string3);
    }

    public PendingIntent c(Context context, int i2, int i3) {
        return super.c(context, i2, i3);
    }

    @Override // com.google.android.gms.common.f
    public final String e(int i) {
        return super.e(i);
    }

    @Override // com.google.android.gms.common.f
    public int g(Context context) {
        return super.g(context);
    }

    @Override // com.google.android.gms.common.f
    public int h(Context context, int i2) {
        return super.h(context, i2);
    }

    @Override // com.google.android.gms.common.f
    public final boolean j(int i) {
        return super.j(i);
    }

    public Dialog l(Activity activity, int i2, int i3) {
        return m(activity, i2, i3, 0);
    }

    public Dialog m(Activity activity, int i2, int i3, DialogInterface.OnCancelListener dialogInterface$OnCancelListener4) {
        return w(activity, i2, g0.b(activity, b(activity, i2, "d"), i3), onCancelListener4);
    }

    public PendingIntent n(Context context, com.google.android.gms.common.b b2) {
        if (b2.m2()) {
            return b2.l2();
        }
        return c(context, b2.j2(), 0);
    }

    @Override // com.google.android.gms.common.f
    public boolean p(Activity activity, int i2, int i3, DialogInterface.OnCancelListener dialogInterface$OnCancelListener4) {
        final Dialog obj2 = m(activity, i2, i3, onCancelListener4);
        if (obj2 == null) {
            return 0;
        }
        x(activity, obj2, "GooglePlayServicesErrorDialog", onCancelListener4);
        return 1;
    }

    @Override // com.google.android.gms.common.f
    public void q(Context context, int i2) {
        s(context, i2, 0, d(context, i2, 0, "n"));
    }

    @Override // com.google.android.gms.common.f
    public final boolean r(Activity activity, i i2, int i3, int i4, DialogInterface.OnCancelListener dialogInterface$OnCancelListener5) {
        Dialog obj3 = w(activity, i3, g0.c(i2, b(activity, i3, "d"), 2), onCancelListener5);
        if (obj3 == null) {
            return 0;
        }
        x(activity, obj3, "GooglePlayServicesErrorDialog", onCancelListener5);
        return 1;
    }

    @Override // com.google.android.gms.common.f
    final void s(Context context, int i2, String string3, PendingIntent pendingIntent4) {
        boolean string;
        String contentEquals;
        long currentTimeMillis;
        int obj10;
        int obj11;
        int obj12;
        Object obj13;
        obj12 = 2;
        Object[] arr = new Object[obj12];
        final int i7 = 0;
        arr[i7] = Integer.valueOf(i2);
        final int i8 = 1;
        arr[i8] = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", arr), illegalArgumentException);
        if (i2 == 18) {
            y(context);
        }
        if (pendingIntent4 == null && i2 == 6) {
            if (i2 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        }
        contentEquals = d0.d(context, i2);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        r.j(systemService);
        j.e eVar = new j.e(context);
        eVar.s(i8);
        eVar.g(i8);
        eVar.m(d0.b(context, i2));
        j.c cVar = new j.c();
        cVar.h(contentEquals);
        eVar.A(cVar);
        if (i.d(context)) {
            r.m(l.e());
            eVar.y(applicationInfo.icon);
            eVar.v(obj12);
            if (i.f(context)) {
                eVar.a(a.a, resources.getString(b.o), pendingIntent4);
            } else {
                eVar.k(pendingIntent4);
            }
        } else {
            eVar.y(17301642);
            eVar.B(resources.getString(b.h));
            eVar.E(System.currentTimeMillis());
            eVar.k(pendingIntent4);
            eVar.l(contentEquals);
        }
        if (!l.h()) {
        } else {
            r.m(l.h());
            obj13 = e.d;
            synchronized (obj13) {
                r.m(l.h());
                obj13 = e.d;
            }
            string = "com.google.android.gms.availability";
            obj13 = (NotificationManager)systemService.getNotificationChannel(string);
            obj10 = d0.g(context);
            if (obj13 == null) {
                obj13 = new NotificationChannel(string, obj10, 4);
                systemService.createNotificationChannel(obj13);
            } else {
                if (!obj10.contentEquals(obj13.getName())) {
                    obj13.setName(obj10);
                    systemService.createNotificationChannel(obj13);
                }
            }
            eVar.i(string);
        }
        if (i2 != i8 && i2 != obj12 && i2 != 3) {
            if (i2 != obj12) {
                if (i2 != 3) {
                    obj11 = 39789;
                } else {
                    h.b.set(i7);
                    obj11 = 10436;
                }
            } else {
            }
        } else {
        }
        systemService.notify(obj11, eVar.c());
    }

    @Override // com.google.android.gms.common.f
    public final boolean t(Context context, com.google.android.gms.common.b b2, int i3) {
        PendingIntent intent = n(context, b2);
        final int i2 = 0;
        if (intent != null) {
            final int i5 = 1;
            s(context, b2.j2(), 0, PendingIntent.getActivity(context, i2, GoogleApiActivity.a(context, intent, i3, i5), 134217728));
            return i5;
        }
        return i2;
    }

    public final Dialog u(Activity activity, DialogInterface.OnCancelListener dialogInterface$OnCancelListener2) {
        int i2 = 0;
        ProgressBar progressBar = new ProgressBar(activity, i2, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(d0.c(activity, 18));
        builder.setPositiveButton("", i2);
        android.app.AlertDialog create = builder.create();
        x(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener2);
        return create;
    }

    @Override // com.google.android.gms.common.f
    public final o0 v(Context context, n0 n02) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        o0 o0Var = new o0(n02);
        context.registerReceiver(o0Var, intentFilter);
        o0Var.a(context);
        if (!i(context, "com.google.android.gms")) {
            n02.a();
            o0Var.b();
            return null;
        }
        return o0Var;
    }

    @Override // com.google.android.gms.common.f
    final Dialog w(Context context, int i2, g0 g03, DialogInterface.OnCancelListener dialogInterface$OnCancelListener4) {
        int builder;
        boolean equals;
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        final int i3 = 1;
        context.getTheme().resolveAttribute(16843529, typedValue, i3);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(d0.c(context, i2));
        if (onCancelListener4 != null) {
            builder.setOnCancelListener(onCancelListener4);
        }
        final String obj9 = d0.e(context, i2);
        if (obj9 != null) {
            builder.setPositiveButton(obj9, g03);
        }
        String obj6 = d0.a(context, i2);
        if (obj6 != null) {
            builder.setTitle(obj6);
        }
        obj6 = new Object[i3];
        obj6[0] = Integer.valueOf(i2);
        IllegalArgumentException obj7 = new IllegalArgumentException();
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", obj6), obj7);
        return builder.create();
    }

    @Override // com.google.android.gms.common.f
    final void x(Activity activity, Dialog dialog2, String string3, DialogInterface.OnCancelListener dialogInterface$OnCancelListener4) {
        try {
            if (activity instanceof e) {
            }
            k.B1(dialog2, onCancelListener4).show((e)activity.getSupportFragmentManager(), string3);
        }
        c.a(dialog2, onCancelListener4).show(activity.getFragmentManager(), string3);
    }

    @Override // com.google.android.gms.common.f
    final void y(Context context) {
        p pVar = new p(this, context);
        pVar.sendEmptyMessageDelayed(1, 120000);
    }
}

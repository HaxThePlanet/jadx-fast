package com.facebook.e0.v;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.e0.g.b;
import com.facebook.e0.m;
import com.facebook.e0.m.a;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.i0.a;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import com.facebook.v;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0007J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0008\u0010\u0015\u001a\u00020\u0010H\u0002J$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lcom/facebook/appevents/internal/SessionLogger;", "", "()V", "INACTIVE_SECONDS_QUANTA", "", "PACKAGE_CHECKSUM", "", "TAG", "computePackageChecksum", "context", "Landroid/content/Context;", "getQuantaIndex", "", "timeBetweenSessions", "", "logActivateApp", "", "activityName", "sourceApplicationInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "appId", "logClockSkewEvent", "logDeactivateApp", "sessionInfo", "Lcom/facebook/appevents/internal/SessionInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class i {

    private static final String a = "com.facebook.e0.v.i";
    private static final long[] b;
    public static final com.facebook.e0.v.i c;
    static {
        i iVar = new i();
        i.c = iVar;
        long[] lArr = new long[19];
        lArr = new long[]{
            300000L, 900000L, 1800000L, 3600000L, 21600000L, 43200000L, 86400000L, 172800000L, 259200000L, 604800000L,
            1209600000L, 1814400000L, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L
        };
        i.b = lArr;
    }

    public static final int b(long l) {
        int i;
        int cmp;
        long length;
        final int i2 = 0;
        if (a.d(i.class)) {
            return i2;
        }
        i = i2;
        cmp = i.b;
        while (i < cmp.length) {
            if (Long.compare(length, l) < 0) {
            }
            i++;
            cmp = i.b;
        }
        return i;
    }

    public static final void c(String string, com.facebook.e0.v.j j2, String string3, Context context4) {
        String obj4;
        if (a.d(i.class)) {
        }
        n.f(string, "activityName");
        n.f(context4, "context");
        if (j2 != null && j2.toString() != null) {
            if (j2.toString() != null) {
            } else {
                obj4 = "Unclassified";
            }
        } else {
        }
        Bundle bundle = new Bundle();
        bundle.putString("fb_mobile_launch_source", obj4);
        bundle.putString("fb_mobile_pckg_fp", i.c.a(context4));
        bundle.putString("fb_mobile_app_cert_hash", a.a(context4));
        obj4 = new m(string, string3, 0);
        obj4.d("fb_mobile_activate_app", bundle);
        if (m.b.b() != g.b.EXPLICIT_ONLY) {
            obj4.a();
        }
    }

    private final void d() {
        if (a.d(this)) {
        }
        final String str = i.a;
        n.d(str);
        v.f.b(v.APP_EVENTS, str, "Clock skew detected");
    }

    public static final void e(String string, com.facebook.e0.v.h h2, String string3) {
        Long num;
        int cmp2;
        int cmp;
        int longValue;
        long longValue3;
        int longValue2;
        Object string2;
        long l;
        Object obj = string;
        if (a.d(i.class)) {
        }
        n.f(string, "activityName");
        if (h2 == null) {
        }
        num = h2.b();
        longValue = 0;
        if (num != null) {
            longValue2 = num.longValue();
        } else {
            num = h2.e();
            if (num != null) {
                longValue3 = num.longValue();
            } else {
                longValue3 = longValue;
            }
            longValue2 = longValue - longValue3;
        }
        try {
            if (Long.compare(longValue2, longValue) < 0) {
            }
            i.c.d();
            longValue2 = longValue;
            if (Long.compare(l, longValue) < 0) {
            }
            i.c.d();
            l = longValue;
            Bundle bundle = new Bundle();
            bundle.putInt("fb_mobile_app_interruptions", h2.c());
            f0 f0Var = f0.a;
            final int i8 = 1;
            final Object[] arr = new Object[i8];
            arr[0] = Integer.valueOf(i.b(longValue2));
            String format = String.format(Locale.ROOT, "session_quanta_%d", Arrays.copyOf(arr, i8));
            n.e(format, "java.lang.String.format(locale, format, *args)");
            bundle.putString("fb_mobile_time_between_sessions", format);
            string2 = h2.g();
            if (string2 != null && string2.toString() != null) {
            } else {
            }
            if (string2.toString() != null) {
            } else {
            }
            string2 = "Unclassified";
            bundle.putString("fb_mobile_launch_source", string2);
            Long num2 = h2.e();
            if (num2 != null) {
            }
            longValue = num2.longValue();
            bundle.putLong("_logTime", longValue /= l2);
            String str4 = string3;
            m mVar = new m(string, str4, 0);
            mVar.c("fb_mobile_deactivate_app", d /= d2, str4);
            a.b(th, obj1);
        }
    }

    public final String a(Context context) {
        String str;
        int length;
        int i;
        Object obj9;
        int i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        n.f(context, "context");
        PackageManager packageManager = context.getPackageManager();
        final int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PCKGCHKSUM;");
        stringBuilder.append(packageInfo.versionName);
        String string = stringBuilder.toString();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", i3);
        String string2 = sharedPreferences.getString(string, i2);
        if (string2 != null && string2.length() == 32) {
            if (string2.length() == 32) {
                return string2;
            }
        }
        if (g.c(context, i2) != null) {
        } else {
            str = g.b(obj9.sourceDir);
        }
        try {
            sharedPreferences.edit().putString(string, str).apply();
            return str;
            a.b(context, this);
            return obj1;
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
    }
}

package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.o.a;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.internal.measurement.kd;
import com.google.android.gms.internal.measurement.se;
import com.google.android.gms.internal.measurement.uc;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public final class h3 extends com.google.android.gms.measurement.internal.f4 {

    private String c;
    private String d;
    private int e;
    private String f;
    private long g;
    private final long h;
    private List<String> i;
    private int j;
    private String k;
    private String l;
    private String m;
    h3(com.google.android.gms.measurement.internal.b5 b5, long l2) {
        super(b5);
        this.h = l2;
    }

    @EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    protected final void l() {
        String packageName;
        Object list;
        com.google.android.gms.measurement.internal.b5 b5Var;
        String versionName;
        int i;
        Object iterator;
        boolean equals2;
        int versionCode;
        boolean empty4;
        String str;
        String installerPackageName;
        int str4;
        com.google.android.gms.measurement.internal.b5 equals;
        Object packageInfo;
        com.google.android.gms.measurement.internal.o3 o3Var;
        Object resources2;
        Object string;
        String str2;
        String str3;
        boolean empty3;
        String empty2;
        String str5;
        android.content.res.Resources resources;
        boolean empty;
        packageName = this.a.f().getPackageName();
        PackageManager packageManager = this.a.f().getPackageManager();
        versionCode = Integer.MIN_VALUE;
        final int i5 = 0;
        str = "";
        installerPackageName = "unknown";
        if (packageManager == null) {
            this.a.b().r().b("PackageManager is null, app identity information might be inaccurate. appId", q3.z(packageName));
        } else {
            installerPackageName = packageManager.getInstallerPackageName(packageName);
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else {
                if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = str;
                }
            }
            packageInfo = packageManager.getPackageInfo(this.a.f().getPackageName(), i5);
            if (packageInfo != null) {
                java.lang.CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    string = applicationLabel.toString();
                } else {
                    string = versionName;
                }
                versionName = packageInfo.versionName;
                versionCode = packageInfo.versionCode;
            }
        }
        this.c = packageName;
        this.f = installerPackageName;
        this.d = versionName;
        this.e = versionCode;
        this.g = 0;
        int i4 = 1;
        if (!TextUtils.isEmpty(this.a.O()) && "am".equals(this.a.P())) {
            i = "am".equals(this.a.P()) ? i4 : i5;
        } else {
        }
        str4 = this.a.x();
        switch (str4) {
            case 0:
                this.a.b().v().a("App measurement collection enabled");
                break;
            case 1:
                this.a.b().u().a("App measurement deactivated via the manifest");
                break;
            case 2:
                this.a.b().v().a("App measurement deactivated via the init parameters");
                break;
            case 3:
                this.a.b().u().a("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                break;
            case 4:
                this.a.b().u().a("App measurement disabled via the manifest");
                break;
            case 5:
                this.a.b().v().a("App measurement disabled via the init parameters");
                break;
            case 6:
                this.a.b().x().a("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                break;
            case 7:
                this.a.b().u().a("App measurement disabled via the global data collection setting");
                break;
            default:
                this.a.b().u().a("App measurement disabled due to denied storage consent");
        }
        this.k = str;
        this.l = str;
        this.m = str;
        this.a.d();
        if (i != 0) {
            this.l = this.a.O();
        }
        int i3 = 0;
        resources2 = o7.c(this.a.f(), "google_app_id", this.a.R());
        str3 = i4 != TextUtils.isEmpty(resources2) ? resources2 : str;
        this.k = str3;
        kd.b();
        String str15 = "admob_app_id";
        if (this.a.z().B(i3, c3.d0)) {
            Context context7 = this.a.f();
            r.j(context7);
            resources = context7.getResources();
            if (!TextUtils.isEmpty(this.a.R())) {
            } else {
                str5 = u4.a(context7);
            }
            empty3 = u4.b("ga_app_id", resources, str5);
            if (i4 != TextUtils.isEmpty(empty3)) {
                str = empty3;
            }
            this.m = str;
            if (TextUtils.isEmpty(resources2)) {
                if (!TextUtils.isEmpty(empty3)) {
                    this.l = u4.b(str15, resources, str5);
                }
            } else {
            }
        } else {
            if (!TextUtils.isEmpty(resources2)) {
                Context context4 = this.a.f();
                r.j(context4);
                if (!TextUtils.isEmpty(this.a.R())) {
                } else {
                    str = u4.a(context4);
                }
                this.l = u4.b(str15, context4.getResources(), str);
            }
        }
        if (str4 == null) {
            if (TextUtils.isEmpty(this.k)) {
                resources2 = this.l;
            } else {
                try {
                    resources2 = this.k;
                    this.a.b().v().c("App measurement enabled for app package, google app id", this.c, resources2);
                    com.google.android.gms.measurement.internal.b5 b5Var13 = this.a;
                    b5Var13 = b5Var13.b();
                    b5Var13 = b5Var13.r();
                    String str6 = q3.z(str6);
                    b5Var13.c("Fetching Google App Id failed with exception. appId", str6, th);
                    this.i = i3;
                    this.a.d();
                    list = this.a.z().y("analytics.safelisted_events");
                } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
                }
                this.i = list;
                if (packageManager != null) {
                    this.j = a.a(this.a.f());
                }
                this.j = i5;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final boolean n() {
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final int o() {
        i();
        return this.j;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final int p() {
        i();
        return this.e;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final com.google.android.gms.measurement.internal.na q(String string) {
        int digest;
        long i4;
        Boolean valueOf;
        boolean z;
        long l;
        boolean invoke2;
        com.google.android.gms.measurement.internal.b5 b5Var;
        int str3;
        Object str4;
        String packageName;
        int arr;
        int invoke;
        String str;
        String str2;
        PackageManager packageManager;
        MessageDigest messageDigest;
        int i3;
        Class<Context> obj;
        int i2;
        long l2;
        Boolean bool;
        int i;
        final Object obj2 = this;
        h();
        String str6 = s();
        i();
        i();
        i();
        r.j(obj2.f);
        obj2.a.z().q();
        i();
        h();
        int i10 = 0;
        i4 = 0;
        if (Long.compare(l, i10) == 0) {
            str4 = obj2.a.N();
            digest = obj2.a.f();
            packageName = obj2.a.f().getPackageName();
            str4.h();
            r.j(digest);
            r.f(packageName);
            messageDigest = ia.s();
            i3 = -1;
            if (messageDigest == null) {
                str4.a.b().r().a("Could not get MD5 instance");
                l = i3;
            } else {
            }
            obj2.g = l;
        }
        arr = 1;
        h();
        invoke = 0;
        if (!obj2.a.o()) {
            i2 = invoke;
        } else {
        }
        b5Var = obj2.a;
        long l6 = g4Var4.e.a();
        if (Long.compare(l6, i13) == 0) {
            str2 = str6;
            l2 = b5Var;
        } else {
            str2 = str6;
            l2 = i4;
        }
        i();
        com.google.android.gms.measurement.internal.g4 g4Var = obj2.a.F();
        g4Var.h();
        i();
        valueOf = obj2.a.z().t("google_analytics_default_allow_ad_personalization_signals");
        if (valueOf == null) {
            bool = 0;
        } else {
            bool = valueOf;
        }
        kd.b();
        int i8 = 0;
        if (obj2.a.z().B(i8, c3.d0)) {
            i = z;
        } else {
            i = i8;
        }
        super(str2, u(), obj2.d, (long)i5, obj7, obj2.f, 46000, l6, l, str2, string, obj2.a.o(), z3 ^ 1, i2, 0, obj, l2, i2, obj2.j, obj2.a.z().A(), g4Var.o().getBoolean("deferred_analytics_collection", false), obj2.l, bool, obj2.h, obj27, obj2.i, i, obj2.a.F().q().i());
        return naVar2;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final String r() {
        i();
        return this.l;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final String s() {
        i();
        r.j(this.c);
        return this.c;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final String t() {
        i();
        r.j(this.m);
        return this.m;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final String u() {
        uc.b();
        if (this.a.z().B(0, c3.q0)) {
            h();
        }
        i();
        r.j(this.k);
        return this.k;
    }

    final List<String> v() {
        return this.i;
    }
}

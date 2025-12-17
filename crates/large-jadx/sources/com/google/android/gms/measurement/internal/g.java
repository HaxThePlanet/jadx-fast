package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.common.util.m;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public final class g extends com.google.android.gms.measurement.internal.v5 {

    private Boolean b;
    private com.google.android.gms.measurement.internal.f c;
    private Boolean d;
    g(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        this.c = e.a;
    }

    public static final long I() {
        return (Long)c3.d.a(0).longValue();
    }

    public static final long i() {
        return (Long)c3.D.a(0).longValue();
    }

    private final String j(String string, String string2) {
        String str;
        Class<String> obj8 = String.class;
        final int i = 2;
        final Class[] arr2 = new Class[i];
        final int i2 = 0;
        arr2[i2] = obj8;
        final int i3 = 1;
        arr2[i3] = obj8;
        Object[] arr = new Object[i];
        arr[i2] = string;
        arr[i3] = "";
        Object obj7 = Class.forName("android.os.SystemProperties").getMethod("get", arr2).invoke(0, arr);
        r.j((String)obj7);
        return obj7;
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final boolean A() {
        Boolean booleanValue;
        booleanValue = t("google_analytics_adid_collection_enabled");
        if (booleanValue != null && booleanValue.booleanValue()) {
            if (booleanValue.booleanValue()) {
            }
            return 0;
        }
        return 1;
    }

    public final boolean B(String string, com.google.android.gms.measurement.internal.b3<Boolean> b32) {
        boolean str;
        boolean obj4;
        int i = 0;
        if (string == null) {
            return (Boolean)b32.a(i).booleanValue();
        }
        obj4 = this.c.e(string, b32.b());
        if (!TextUtils.isEmpty(obj4)) {
            if (this.a.z().B(i, c3.y0)) {
                obj4 = "1".equals(obj4);
            } else {
                obj4 = Boolean.parseBoolean(obj4);
            }
            return (Boolean)b32.a(Boolean.valueOf(obj4)).booleanValue();
        }
        return (Boolean)b32.a(i).booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final boolean C(String string) {
        return "1".equals(this.c.e(string, "gaia_collection_enabled"));
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final boolean D() {
        Boolean booleanValue;
        booleanValue = t("google_analytics_automatic_screen_reporting_enabled");
        if (booleanValue != null && booleanValue.booleanValue()) {
            if (booleanValue.booleanValue()) {
            }
            return 0;
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final boolean E() {
        Boolean booleanValue;
        this.a.d();
        booleanValue = t("firebase_analytics_collection_deactivated");
        if (booleanValue != null && booleanValue.booleanValue()) {
            if (booleanValue.booleanValue()) {
                return 1;
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final boolean F(String string) {
        return "1".equals(this.c.e(string, "measurement.event_sampling_enabled"));
    }

    @Override // com.google.android.gms.measurement.internal.v5
    final boolean G() {
        Boolean fALSE;
        boolean booleanValue;
        fALSE = t("app_measurement_lite");
        this.b = fALSE;
        if (this.b == null && fALSE == null) {
            fALSE = t("app_measurement_lite");
            this.b = fALSE;
            if (fALSE == null) {
                this.b = Boolean.FALSE;
            }
        }
        if (!this.b.booleanValue() && !this.a.s()) {
            if (!this.a.s()) {
            }
            return 0;
        }
        return 1;
    }

    @EnsuresNonNull("this.isMainProcess")
    public final boolean H() {
        Object bool;
        Object applicationInfo;
        String processName;
        String str;
        int i;
        applicationInfo = this.a.f().getApplicationInfo();
        processName = applicationInfo.processName;
        i = 0;
        if (this.d == null && this.d == null && applicationInfo != null && processName != null && processName.equals(m.a())) {
            synchronized (this) {
                applicationInfo = this.a.f().getApplicationInfo();
                if (applicationInfo != null) {
                    processName = applicationInfo.processName;
                    i = 0;
                    if (processName != null) {
                        if (processName.equals(m.a())) {
                            try {
                                i = 1;
                                this.d = Boolean.valueOf(i);
                                if (this.d == null) {
                                }
                                this.d = Boolean.TRUE;
                                this.a.b().r().a("My process not in the list of running processes");
                                throw th;
                                return this.d.booleanValue();
                            }
                        }
                    }
                }
            }
        }
    }

    public final double k(String string, com.google.android.gms.measurement.internal.b3<Double> b32) {
        final int i = 0;
        if (string == null) {
            return (Double)b32.a(i).doubleValue();
        }
        final String str = b32.b();
        String obj4 = this.c.e(string, str);
        if (TextUtils.isEmpty(obj4)) {
            return (Double)b32.a(i).doubleValue();
        }
        return (Double)b32.a(Double.valueOf(Double.parseDouble(obj4))).doubleValue();
    }

    @Override // com.google.android.gms.measurement.internal.v5
    final int l(String string) {
        return p(string, c3.H, 500, 2000);
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final int m() {
        int booleanValue;
        com.google.android.gms.measurement.internal.ia iaVar = this.a.N();
        Boolean bool = iaVar.a.L().J();
        if (iaVar.o0() < 201500 && bool != null && !bool.booleanValue()) {
            if (bool != null) {
                if (!bool.booleanValue()) {
                }
            }
            return 25;
        }
        return 100;
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final int n(String string) {
        return p(string, c3.I, 25, 100);
    }

    public final int o(String string, com.google.android.gms.measurement.internal.b3<Integer> b32) {
        final int i = 0;
        if (string == null) {
            return (Integer)b32.a(i).intValue();
        }
        String obj4 = this.c.e(string, b32.b());
        if (TextUtils.isEmpty(obj4)) {
            return (Integer)b32.a(i).intValue();
        }
        return (Integer)b32.a(Integer.valueOf(Integer.parseInt(obj4))).intValue();
    }

    public final int p(String string, com.google.android.gms.measurement.internal.b3<Integer> b32, int i3, int i4) {
        return Math.max(Math.min(o(string, b32), i4), i3);
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final long q() {
        this.a.d();
        return 46000;
    }

    public final long r(String string, com.google.android.gms.measurement.internal.b3<Long> b32) {
        final int i = 0;
        if (string == null) {
            return (Long)b32.a(i).longValue();
        }
        final String str = b32.b();
        String obj4 = this.c.e(string, str);
        if (TextUtils.isEmpty(obj4)) {
            return (Long)b32.a(i).longValue();
        }
        return (Long)b32.a(Long.valueOf(Long.parseLong(obj4))).longValue();
    }

    @Override // com.google.android.gms.measurement.internal.v5
    final Bundle s() {
        int i = 0;
        if (this.a.f().getPackageManager() == null) {
            try {
                this.a.b().r().a("Failed to load metadata: PackageManager is null");
                return i;
                android.content.pm.ApplicationInfo applicationInfo = c.a(this.a.f()).c(this.a.f().getPackageName(), 128);
                if (applicationInfo == null) {
                }
                this.a.b().r().a("Failed to load metadata: ApplicationInfo is null");
                return i;
                return applicationInfo.metaData;
                com.google.android.gms.measurement.internal.b5 b5Var5 = this.a;
                b5Var5 = b5Var5.b();
                b5Var5 = b5Var5.r();
                b5Var5.b("Failed to load metadata: Package name not found", th);
                return obj0;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.v5
    final Boolean t(String string) {
        r.f(string);
        Bundle bundle = s();
        final int i = 0;
        if (bundle == null) {
            this.a.b().r().a("Failed to load metadata: Metadata bundle is null");
            return i;
        }
        if (!bundle.containsKey(string)) {
            return i;
        }
        return Boolean.valueOf(bundle.getBoolean(string));
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final String u() {
        return j("debug.firebase.analytics.app", "");
    }

    @Override // com.google.android.gms.measurement.internal.v5
    public final String v() {
        return j("debug.deferred.deeplink", "");
    }

    @Override // com.google.android.gms.measurement.internal.v5
    final String w() {
        this.a.d();
        return "FA";
    }

    public final String x(String string, com.google.android.gms.measurement.internal.b3<String> b32) {
        if (string == null) {
            return (String)b32.a(0);
        }
        return (String)b32.a(this.c.e(string, b32.b()));
    }

    final List<String> y(String string) {
        Object str;
        boolean str2;
        Integer obj4;
        obj4 = "analytics.safelisted_events";
        r.f(obj4);
        str = s();
        final int i = 0;
        if (str == null) {
            this.a.b().r().a("Failed to load metadata: Metadata bundle is null");
            obj4 = i;
        } else {
        }
        obj4 = this.a.f().getResources().getStringArray(obj4.intValue());
        if (obj4 != null && obj4 == null) {
            obj4 = this.a.f().getResources().getStringArray(obj4.intValue());
            if (obj4 == null) {
                return i;
            }
            return Arrays.asList(obj4);
        }
        return i;
    }

    @Override // com.google.android.gms.measurement.internal.v5
    final void z(com.google.android.gms.measurement.internal.f f) {
        this.c = f;
    }
}

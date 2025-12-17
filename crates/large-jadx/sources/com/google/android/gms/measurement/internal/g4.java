package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull.List;

/* loaded from: classes2.dex */
final class g4 extends com.google.android.gms.measurement.internal.w5 {

    static final Pair<String, Long> x;
    private SharedPreferences c;
    public com.google.android.gms.measurement.internal.d4 d;
    public final com.google.android.gms.measurement.internal.b4 e;
    public final com.google.android.gms.measurement.internal.b4 f;
    public final com.google.android.gms.measurement.internal.e4 g;
    private String h;
    private boolean i;
    private long j;
    public final com.google.android.gms.measurement.internal.b4 k;
    public final com.google.android.gms.measurement.internal.z3 l;
    public final com.google.android.gms.measurement.internal.e4 m;
    public final com.google.android.gms.measurement.internal.z3 n;
    public final com.google.android.gms.measurement.internal.b4 o;
    public boolean p;
    public final com.google.android.gms.measurement.internal.z3 q;
    public final com.google.android.gms.measurement.internal.z3 r;
    public final com.google.android.gms.measurement.internal.b4 s;
    public final com.google.android.gms.measurement.internal.e4 t;
    public final com.google.android.gms.measurement.internal.e4 u;
    public final com.google.android.gms.measurement.internal.b4 v;
    public final com.google.android.gms.measurement.internal.a4 w;
    static {
        Pair pair = new Pair("", Long.valueOf(0));
        g4.x = pair;
    }

    g4(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        b4 obj6 = new b4(this, "session_timeout", 1800000, obj2);
        this.k = obj6;
        obj6 = new z3(this, "start_new_session", 1);
        this.l = obj6;
        int i3 = 0;
        obj6 = new b4(this, "last_pause_time", i3, obj2);
        this.o = obj6;
        final int i4 = 0;
        obj6 = new e4(this, "non_personalized_ads", i4);
        this.m = obj6;
        final int i5 = 0;
        obj6 = new z3(this, "allow_remote_dynamite", i5);
        this.n = obj6;
        obj6 = new b4(this, "first_open_time", i3, obj2);
        this.e = obj6;
        obj6 = new b4(this, "app_install_time", i3, obj2);
        this.f = obj6;
        obj6 = new e4(this, "app_instance_id", i4);
        this.g = obj6;
        obj6 = new z3(this, "app_backgrounded", i5);
        this.q = obj6;
        obj6 = new z3(this, "deep_link_retrieval_complete", i5);
        this.r = obj6;
        obj6 = new b4(this, "deep_link_retrieval_attempts", i3, obj2);
        this.s = obj6;
        obj6 = new e4(this, "firebase_feature_rollouts", i4);
        this.t = obj6;
        obj6 = new e4(this, "deferred_attribution_cache", i4);
        this.u = obj6;
        obj6 = new b4(this, "deferred_attribution_cache_timestamp", i3, obj2);
        this.v = obj6;
        obj6 = new a4(this, "default_event_parameters", i4);
        this.w = obj6;
    }

    @EnsuresNonNull$List({@EnsuresNonNull(...), @EnsuresNonNull(...)})
    protected final void i() {
        boolean boolean;
        int i;
        i = 0;
        SharedPreferences sharedPreferences = this.a.f().getSharedPreferences("com.google.android.gms.measurement.prefs", i);
        this.c = sharedPreferences;
        String str2 = "has_been_opened";
        boolean = sharedPreferences.getBoolean(str2, i);
        this.p = boolean;
        if (!boolean) {
            boolean = this.c.edit();
            boolean.putBoolean(str2, true);
            boolean.apply();
        }
        this.a.z();
        int i3 = 0;
        super(this, "health_monitor", Math.max(0, i), obj7, 0);
        this.d = d4Var;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean j() {
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final SharedPreferences o() {
        h();
        k();
        r.j(this.c);
        return this.c;
    }

    final Pair<String, Boolean> p(String string) {
        String str2;
        String str;
        int cmp;
        boolean obj7;
        h();
        long l = this.a.c().a();
        String str5 = this.h;
        if (str5 != null && Long.compare(l, l3) >= 0) {
            if (Long.compare(l, l3) >= 0) {
            }
            obj7 = new Pair(str5, Boolean.valueOf(this.i));
            return obj7;
        }
        this.j = l += l2;
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        obj7 = AdvertisingIdClient.getAdvertisingIdInfo(this.a.f());
        this.h = "";
        str2 = obj7.getId();
        if (str2 != null) {
            this.h = str2;
        }
        this.i = obj7.isLimitAdTrackingEnabled();
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        obj7 = new Pair(this.h, Boolean.valueOf(this.i));
        return obj7;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final com.google.android.gms.measurement.internal.h q() {
        h();
        return h.b(o().getString("consent_settings", "G1"));
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final Boolean r() {
        h();
        final String str = "measurement_enabled";
        if (o().contains(str)) {
            return Boolean.valueOf(o().getBoolean(str, true));
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final void s(Boolean boolean) {
        boolean obj3;
        h();
        SharedPreferences.Editor edit = o().edit();
        final String str = "measurement_enabled";
        if (boolean) {
            edit.putBoolean(str, boolean.booleanValue());
        } else {
            edit.remove(str);
        }
        edit.apply();
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final void t(boolean z) {
        h();
        this.a.b().v().b("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = o().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean u() {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean v(long l) {
        if (Long.compare(obj3, l3) > 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    final boolean w(int i) {
        return h.l(i, o().getInt("consent_source", 100));
    }
}

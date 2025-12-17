package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class ec implements com.google.android.gms.internal.measurement.dc {

    public static final com.google.android.gms.internal.measurement.w6<Long> A;
    public static final com.google.android.gms.internal.measurement.w6<Long> B;
    public static final com.google.android.gms.internal.measurement.w6<Long> C;
    public static final com.google.android.gms.internal.measurement.w6<Long> D;
    public static final com.google.android.gms.internal.measurement.w6<Long> E;
    public static final com.google.android.gms.internal.measurement.w6<Long> F;
    public static final com.google.android.gms.internal.measurement.w6<Long> G;
    public static final com.google.android.gms.internal.measurement.w6<String> H;
    public static final com.google.android.gms.internal.measurement.w6<Long> I;
    public static final com.google.android.gms.internal.measurement.w6<Long> a;
    public static final com.google.android.gms.internal.measurement.w6<Long> b;
    public static final com.google.android.gms.internal.measurement.w6<Long> c;
    public static final com.google.android.gms.internal.measurement.w6<String> d;
    public static final com.google.android.gms.internal.measurement.w6<String> e;
    public static final com.google.android.gms.internal.measurement.w6<Long> f;
    public static final com.google.android.gms.internal.measurement.w6<Long> g;
    public static final com.google.android.gms.internal.measurement.w6<Long> h;
    public static final com.google.android.gms.internal.measurement.w6<Long> i;
    public static final com.google.android.gms.internal.measurement.w6<Long> j;
    public static final com.google.android.gms.internal.measurement.w6<Long> k;
    public static final com.google.android.gms.internal.measurement.w6<Long> l;
    public static final com.google.android.gms.internal.measurement.w6<Long> m;
    public static final com.google.android.gms.internal.measurement.w6<Long> n;
    public static final com.google.android.gms.internal.measurement.w6<Long> o;
    public static final com.google.android.gms.internal.measurement.w6<Long> p;
    public static final com.google.android.gms.internal.measurement.w6<Long> q;
    public static final com.google.android.gms.internal.measurement.w6<Long> r;
    public static final com.google.android.gms.internal.measurement.w6<Long> s;
    public static final com.google.android.gms.internal.measurement.w6<Long> t;
    public static final com.google.android.gms.internal.measurement.w6<Long> u;
    public static final com.google.android.gms.internal.measurement.w6<Long> v;
    public static final com.google.android.gms.internal.measurement.w6<Long> w;
    public static final com.google.android.gms.internal.measurement.w6<Long> x;
    public static final com.google.android.gms.internal.measurement.w6<Long> y;
    public static final com.google.android.gms.internal.measurement.w6<Long> z;
    static {
        t6 t6Var = new t6(m6.a("com.google.android.gms.measurement"));
        int i = 10000;
        ec.a = t6Var.c("measurement.ad_id_cache_time", i);
        int i8 = 100;
        ec.b = t6Var.c("measurement.max_bundles_per_iteration", i8);
        final int i12 = 86400000;
        ec.c = t6Var.c("measurement.config.cache_time", i12);
        t6Var.d("measurement.log_tag", "FA");
        ec.d = t6Var.d("measurement.config.url_authority", "app-measurement.com");
        ec.e = t6Var.d("measurement.config.url_scheme", "https");
        int i13 = 1000;
        ec.f = t6Var.c("measurement.upload.debug_upload_interval", i13);
        ec.g = t6Var.c("measurement.lifetimevalue.max_currency_tracked", 4);
        ec.h = t6Var.c("measurement.store.max_stored_events_per_app", 100000);
        ec.i = t6Var.c("measurement.experiment.max_ids", 50);
        ec.j = t6Var.c("measurement.audience.filter_result_max_count", 200);
        ec.k = t6Var.c("measurement.alarm_manager.minimum_interval", 60000);
        int i20 = 500;
        ec.l = t6Var.c("measurement.upload.minimum_delay", i20);
        ec.m = t6Var.c("measurement.monitoring.sample_period_millis", i12);
        ec.n = t6Var.c("measurement.upload.realtime_upload_interval", i);
        int i2 = 604800000;
        ec.o = t6Var.c("measurement.upload.refresh_blacklisted_config_interval", i2);
        final int i21 = 3600000;
        t6Var.c("measurement.config.cache_time.service", i21);
        ec.p = t6Var.c("measurement.service_client.idle_disconnect_millis", 5000);
        t6Var.d("measurement.log_tag.service", "FA-SVC");
        ec.q = t6Var.c("measurement.upload.stale_data_deletion_interval", i12);
        ec.r = t6Var.c("measurement.sdk.attribution.cache.ttl", i2);
        ec.s = t6Var.c("measurement.upload.backoff_period", 43200000);
        ec.t = t6Var.c("measurement.upload.initial_upload_delay_time", 15000);
        ec.u = t6Var.c("measurement.upload.interval", i21);
        int i5 = 65536;
        ec.v = t6Var.c("measurement.upload.max_bundle_size", i5);
        ec.w = t6Var.c("measurement.upload.max_bundles", i8);
        ec.x = t6Var.c("measurement.upload.max_conversions_per_day", i20);
        ec.y = t6Var.c("measurement.upload.max_error_events_per_day", i13);
        ec.z = t6Var.c("measurement.upload.max_events_per_bundle", i13);
        ec.A = t6Var.c("measurement.upload.max_events_per_day", 100000);
        ec.B = t6Var.c("measurement.upload.max_public_events_per_day", 50000);
        ec.C = t6Var.c("measurement.upload.max_queue_time", 2419200000L);
        ec.D = t6Var.c("measurement.upload.max_realtime_events_per_day", 10);
        ec.E = t6Var.c("measurement.upload.max_batch_size", i5);
        ec.F = t6Var.c("measurement.upload.retry_count", 6);
        ec.G = t6Var.c("measurement.upload.retry_time", 1800000);
        ec.H = t6Var.d("measurement.upload.url", "https://app-measurement.com/a");
        ec.I = t6Var.c("measurement.upload.window_interval", i21);
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final String A() {
        return (String)ec.e.b();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long B() {
        return (Long)ec.C.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long a() {
        return (Long)ec.g.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long b() {
        return (Long)ec.f.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long c() {
        return (Long)ec.h.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long d() {
        return (Long)ec.i.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long e() {
        return (Long)ec.r.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long f() {
        return (Long)ec.p.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long g() {
        return (Long)ec.q.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long h() {
        return (Long)ec.n.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long i() {
        return (Long)ec.o.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long j() {
        return (Long)ec.s.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long k() {
        return (Long)ec.t.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long l() {
        return (Long)ec.D.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long m() {
        return (Long)ec.w.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long n() {
        return (Long)ec.E.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long o() {
        return (Long)ec.u.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final String p() {
        return (String)ec.H.b();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long q() {
        return (Long)ec.v.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long r() {
        return (Long)ec.I.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long s() {
        return (Long)ec.A.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long t() {
        return (Long)ec.B.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final String u() {
        return (String)ec.d.b();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long v() {
        return (Long)ec.y.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long w() {
        return (Long)ec.F.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long x() {
        return (Long)ec.G.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long y() {
        return (Long)ec.z.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long z() {
        return (Long)ec.x.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long zza() {
        return (Long)ec.a.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long zzb() {
        return (Long)ec.b.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long zzc() {
        return (Long)ec.c.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long zzh() {
        return (Long)ec.j.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long zzi() {
        return (Long)ec.k.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long zzj() {
        return (Long)ec.l.b().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.dc
    public final long zzk() {
        return (Long)ec.m.b().longValue();
    }
}

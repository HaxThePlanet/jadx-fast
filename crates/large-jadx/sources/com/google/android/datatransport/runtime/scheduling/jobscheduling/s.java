package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo.Builder;
import f.c.a.b.d;
import f.c.a.b.i.b0.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class s {

    public static class a {

        private a a;
        private Map<d, com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b> b;
        public a() {
            super();
            HashMap hashMap = new HashMap();
            this.b = hashMap;
        }

        public com.google.android.datatransport.runtime.scheduling.jobscheduling.s.a a(d d, com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b s$b2) {
            this.b.put(d, b2);
            return this;
        }

        public com.google.android.datatransport.runtime.scheduling.jobscheduling.s b() {
            Objects.requireNonNull(this.a, "missing required property: clock");
            if (this.b.keySet().size() < values.length) {
            } else {
                HashMap hashMap = new HashMap();
                this.b = hashMap;
                return s.d(this.a, this.b);
            }
            IllegalStateException illegalStateException = new IllegalStateException("Not all priorities have been configured");
            throw illegalStateException;
        }

        public com.google.android.datatransport.runtime.scheduling.jobscheduling.s.a c(a a) {
            this.a = a;
            return this;
        }
    }

    public static abstract class b {
        public static com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b.a a() {
            q.b bVar = new q.b();
            bVar.c(Collections.emptySet());
            return bVar;
        }

        abstract long b();

        abstract Set<com.google.android.datatransport.runtime.scheduling.jobscheduling.s.c> c();

        abstract long d();
    }

    public static enum c {

        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING;
    }
    private long a(int i, long l2) {
        int i2;
        i--;
        i2 = Long.compare(l2, i3) > 0 ? l2 : 2;
        return (long)i7;
    }

    public static com.google.android.datatransport.runtime.scheduling.jobscheduling.s.a b() {
        s.a aVar = new s.a();
        return aVar;
    }

    static com.google.android.datatransport.runtime.scheduling.jobscheduling.s d(a a, Map<d, com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b> map2) {
        p pVar = new p(a, map2);
        return pVar;
    }

    public static com.google.android.datatransport.runtime.scheduling.jobscheduling.s f(a a) {
        final com.google.android.datatransport.runtime.scheduling.jobscheduling.s.a aVar = s.b();
        com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b.a aVar2 = s.b.a();
        aVar2.b(30000);
        int i2 = 86400000;
        aVar2.d(i2);
        aVar.a(d.DEFAULT, aVar2.a());
        com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b.a aVar3 = s.b.a();
        aVar3.b(1000);
        aVar3.d(i2);
        aVar.a(d.HIGHEST, aVar3.a());
        com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b.a aVar4 = s.b.a();
        aVar4.b(i2);
        aVar4.d(i2);
        com.google.android.datatransport.runtime.scheduling.jobscheduling.s.c[] arr = new s.c[2];
        aVar4.c(s.i(s.c.NETWORK_UNMETERED, s.c.DEVICE_IDLE));
        aVar.a(d.VERY_LOW, aVar4.a());
        aVar.c(a);
        return aVar.b();
    }

    private static <T> Set<T> i(T... tArr) {
        HashSet hashSet = new HashSet(Arrays.asList(tArr));
        return Collections.unmodifiableSet(hashSet);
    }

    private void j(JobInfo.Builder jobInfo$Builder, Set<com.google.android.datatransport.runtime.scheduling.jobscheduling.s.c> set2) {
        boolean contains;
        final int i = 1;
        if (set2.contains(s.c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(i);
        }
        if (set2.contains(s.c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(i);
        }
        if (set2.contains(s.c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(i);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder jobInfo$Builder, d d2, long l3, int i4) {
        builder.setMinimumLatency(g(d2, l3, i4));
        j(builder, (s.b)h().get(d2).c());
        return builder;
    }

    abstract a e();

    public long g(d d, long l2, int i3) {
        Object obj3 = h().get(d);
        return Math.min(Math.max(a(obj6, (s.b)obj3.b()), obj1), i3);
    }

    abstract Map<d, com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b> h();
}

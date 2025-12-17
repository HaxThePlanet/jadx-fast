package com.google.android.gms.common.m;

import androidx.annotation.RecentlyNonNull;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
@Deprecated
public class a {

    private static com.google.android.gms.common.m.a.a a;

    public interface a {
        @Deprecated
        public abstract ScheduledExecutorService a();
    }
    @Deprecated
    public static com.google.android.gms.common.m.a.a a() {
        com.google.android.gms.common.m.a.a bVar;
        final Class<com.google.android.gms.common.m.a> obj = a.class;
        synchronized (obj) {
            bVar = new b();
            a.a = bVar;
            return a.a;
        }
    }
}

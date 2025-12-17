package com.google.android.gms.common.m;

import f.c.a.d.b.g.g;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
final class b implements com.google.android.gms.common.m.a.a {
    @Override // com.google.android.gms.common.m.a$a
    public final ScheduledExecutorService a() {
        g.a();
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}

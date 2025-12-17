package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.Context;
import com.google.firebase.inappmessaging.internal.time.Clock;
import f.c.f.a.a.a.e.e;
import i.b.b;
import i.b.l;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class CampaignCacheClient {

    private final Application application;
    private e cachedResponse;
    private final Clock clock;
    private final com.google.firebase.inappmessaging.internal.ProtoStorageClient storageClient;
    CampaignCacheClient(com.google.firebase.inappmessaging.internal.ProtoStorageClient protoStorageClient, Application application2, Clock clock3) {
        super();
        this.storageClient = protoStorageClient;
        this.application = application2;
        this.clock = clock3;
    }

    public static boolean a(com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient, e e2) {
        return campaignCacheClient.isResponseValid(e2);
    }

    private e b() {
        return this.cachedResponse;
    }

    private void d(e e) {
        this.cachedResponse = e;
    }

    private void f(Throwable throwable) {
        this.cachedResponse = 0;
    }

    private void h(e e) {
        this.cachedResponse = e;
    }

    private boolean isResponseValid(e e) {
        int i;
        long l = e.e();
        final long l2 = this.clock.now();
        File obj10 = new File(this.application.getApplicationContext().getFilesDir(), "fiam_eligible_campaigns_cache_file");
        i = 0;
        final int i4 = 1;
        if (Long.compare(l, i3) != 0 && Long.compare(l2, l) < 0) {
            if (Long.compare(l2, l) < 0) {
                i = i4;
            }
            return i;
        }
        if (obj10.exists() && Long.compare(l2, i2) < 0) {
            if (Long.compare(l2, i2) < 0) {
                i = i4;
            }
            return i;
        }
        return i4;
    }

    public e c() {
        return b();
    }

    public void e(e e) {
        d(e);
    }

    public void g(Throwable throwable) {
        f(throwable);
    }

    public l<e> get() {
        d dVar = new d(this);
        e eVar = new e(this);
        f fVar = new f(this);
        h hVar = new h(this);
        return l.n(dVar).z(this.storageClient.read(e.parser()).h(eVar)).j(fVar).g(hVar);
    }

    public void i(e e) {
        h(e);
    }

    public b put(e e) {
        g gVar = new g(this, e);
        return this.storageClient.write(e).j(gVar);
    }
}

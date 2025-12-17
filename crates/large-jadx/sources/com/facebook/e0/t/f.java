package com.facebook.e0.t;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.l;
import com.facebook.internal.l.b;
import com.facebook.o;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0007J\u0008\u0010\t\u001a\u00020\u0008H\u0007J\u0008\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseManager;", "", "()V", "GOOGLE_BILLINGCLIENT_VERSION", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enableAutoLogging", "", "startTracking", "usingBillingLib2Plus", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class f {

    private static final AtomicBoolean a;
    public static final com.facebook.e0.t.f b;
    static {
        f fVar = new f();
        f.b = fVar;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        f.a = atomicBoolean;
    }

    public static final void a() {
        if (a.d(f.class)) {
        }
        f.a.set(true);
        f.b();
    }

    public static final void b() {
        boolean z;
        if (a.d(f.class)) {
        }
        if (f.a.get()) {
            if (f.b.c() && l.g(l.b.IapLoggingLib2)) {
                if (l.g(l.b.IapLoggingLib2)) {
                    b.c(o.f());
                } else {
                    a.g();
                }
            } else {
            }
        }
    }

    private final boolean c() {
        android.content.pm.ApplicationInfo applicationInfo;
        int i;
        i = 0;
        if (a.d(this)) {
            return i;
        }
        Context context = o.f();
        applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        String string = applicationInfo.metaData.getString("com.google.android.play.billingclient.version");
        if (applicationInfo != null && string == null) {
            string = applicationInfo.metaData.getString("com.google.android.play.billingclient.version");
            if (string == null) {
                return i;
            }
            if (Integer.parseInt((String)l.E0(string, /* result */, false, 3, 2, 0).get(i)) >= 2) {
                i = 1;
            }
            return i;
        }
        return i;
    }
}

package com.revenuecat.purchases;

import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0008¨\u0006\u000b", d2 = {"Lcom/revenuecat/purchases/AppLifecycleHandler;", "Landroidx/lifecycle/p;", "Lkotlin/w;", "onMoveToForeground", "()V", "onMoveToBackground", "Lcom/revenuecat/purchases/LifecycleDelegate;", "lifecycleDelegate", "Lcom/revenuecat/purchases/LifecycleDelegate;", "<init>", "(Lcom/revenuecat/purchases/LifecycleDelegate;)V", "purchases_release"}, k = 1, mv = {1, 4, 0})
public final class AppLifecycleHandler implements p {

    private final com.revenuecat.purchases.LifecycleDelegate lifecycleDelegate;
    public AppLifecycleHandler(com.revenuecat.purchases.LifecycleDelegate lifecycleDelegate) {
        n.f(lifecycleDelegate, "lifecycleDelegate");
        super();
        this.lifecycleDelegate = lifecycleDelegate;
    }

    @z(j$b.ON_STOP)
    public final void onMoveToBackground() {
        this.lifecycleDelegate.onAppBackgrounded();
    }

    @z(j$b.ON_START)
    public final void onMoveToForeground() {
        this.lifecycleDelegate.onAppForegrounded();
    }
}

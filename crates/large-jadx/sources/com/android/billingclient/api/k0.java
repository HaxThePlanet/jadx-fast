package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class k0 implements Callable {

    public final /* synthetic */ d a;
    public final /* synthetic */ SkuDetails b;
    public final /* synthetic */ String c;
    public /* synthetic */ k0(d dVar, SkuDetails skuDetails, String str) {
        super();
        this.a = dVar;
        this.b = skuDetails;
        this.c = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.z(this.b, this.c);
    }
}

package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class s0 implements Callable {

    public final /* synthetic */ d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ SkuDetails c;
    public final /* synthetic */ String v;
    public final /* synthetic */ f w;
    public final /* synthetic */ Bundle x;
    public /* synthetic */ s0(d dVar, int i, SkuDetails skuDetails, String str, f fVar, Bundle bundle) {
        super();
        this.a = dVar;
        this.b = i;
        this.c = skuDetails;
        this.v = str;
        this.w = fVar;
        this.x = bundle;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.y(this.b, this.c, this.v, this.w, this.x);
    }
}

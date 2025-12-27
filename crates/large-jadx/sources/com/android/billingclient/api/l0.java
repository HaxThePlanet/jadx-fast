package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class l0 implements Callable {

    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public /* synthetic */ l0(d dVar, String str) {
        super();
        this.a = dVar;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.G(this.b);
    }
}

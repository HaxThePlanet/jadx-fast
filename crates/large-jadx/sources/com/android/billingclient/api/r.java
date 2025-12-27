package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class r implements Callable {

    public final /* synthetic */ s a;
    public /* synthetic */ r(s sVar) {
        super();
        this.a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.a.a();
        return null;
    }
}

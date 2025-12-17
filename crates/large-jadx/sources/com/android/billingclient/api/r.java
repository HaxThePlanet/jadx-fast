package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class r implements Callable {

    public final com.android.billingclient.api.s a;
    public r(com.android.billingclient.api.s s) {
        super();
        this.a = s;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.a.a();
        return null;
    }
}

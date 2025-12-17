package com.android.billingclient.api;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class m0 implements Callable {

    public final com.android.billingclient.api.d a;
    public final String b;
    public final List c;
    public final com.android.billingclient.api.m v;
    public m0(com.android.billingclient.api.d d, String string2, List list3, String string4, com.android.billingclient.api.m m5) {
        super();
        this.a = d;
        this.b = string2;
        this.c = list3;
        this.v = m5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final int i = 0;
        this.a.J(this.b, this.c, i, this.v);
        return i;
    }
}

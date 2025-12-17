package com.android.billingclient.api;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class b0 {

    private String a;
    b0(com.android.billingclient.api.a0 a0) {
        super();
    }

    public final com.android.billingclient.api.b0 a(String string) {
        this.a = string;
        return this;
    }

    public final com.android.billingclient.api.c0 b() {
        if (TextUtils.isEmpty(this.a)) {
        } else {
            final int i = 0;
            c0 c0Var = new c0(this.a, i, i);
            return c0Var;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SKU must be set.");
        throw illegalArgumentException;
    }
}

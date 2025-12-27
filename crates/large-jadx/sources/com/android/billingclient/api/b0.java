package com.android.billingclient.api;

import android.text.TextUtils;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class b0 {

    private String a;
    public final c0 b() {
        if (TextUtils.isEmpty(this.a)) {
            throw new IllegalArgumentException("SKU must be set.");
        } else {
            final String str4 = null;
            return new c0(this.a, str4, str4);
        }
    }

    /* synthetic */ b0(a0 a0Var) {
        super();
    }

    public final b0 a(String str) {
        this.a = str;
        return this;
    }
}

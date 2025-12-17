package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
public class b {

    static int b = 31;
    private int a = 1;
    static {
    }

    public b() {
        super();
        final int i = 1;
    }

    public com.google.android.gms.auth.api.signin.internal.b a(Object object) {
        int obj3;
        if (object == null) {
            obj3 = 0;
        } else {
            obj3 = object.hashCode();
        }
        this.a = i2 += obj3;
        return this;
    }

    public int b() {
        return this.a;
    }

    public final com.google.android.gms.auth.api.signin.internal.b c(boolean z) {
        this.a = i2 += z;
        return this;
    }
}

package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class im extends com.google.android.gms.internal.firebase-auth-api.uh implements a.d {

    private final String b;
    im(String string, com.google.android.gms.internal.firebase-auth-api.gm gm2) {
        super();
        r.g(string, "A valid API key must be provided");
        this.b = string;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uh
    public final com.google.android.gms.internal.firebase-auth-api.im a() {
        final String str = this.b;
        r.f(str);
        im imVar = new im(str, 0);
        return imVar;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uh
    public final String b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uh
    public final Object clone() {
        return a();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uh
    public final boolean equals(Object object) {
        boolean z;
        Object obj5;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof im) {
            return i2;
        }
        if (p.a(this.b, object.b) && this.a == object.a) {
            if (this.a == object.a) {
                return i;
            }
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.uh
    public final int hashCode() {
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = this.b;
        return i3 += i2;
    }
}

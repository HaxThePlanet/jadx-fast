package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import f.c.a.d.b.c.c;

/* loaded from: classes2.dex */
public abstract class p extends c implements com.google.android.gms.auth.api.signin.internal.q {
    public p() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // f.c.a.d.b.c.c
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        int obj3;
        final int obj2 = 1;
        if (i != obj2) {
            if (i != 2) {
                return 0;
            }
            B();
        } else {
            T();
        }
        return obj2;
    }
}

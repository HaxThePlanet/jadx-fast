package com.google.firebase.internal;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.p.a;

/* loaded from: classes2.dex */
public class InternalTokenResult {

    private String zza;
    public InternalTokenResult(String string) {
        super();
        this.zza = string;
    }

    public boolean equals(Object object) {
        if (object instanceof InternalTokenResult == null) {
            return 0;
        }
        return p.a(this.zza, object.zza);
    }

    public String getToken() {
        return this.zza;
    }

    public int hashCode() {
        Object[] arr = new Object[1];
        return p.b(this.zza);
    }

    public String toString() {
        p.a aVar = p.c(this);
        aVar.a("token", this.zza);
        return aVar.toString();
    }
}

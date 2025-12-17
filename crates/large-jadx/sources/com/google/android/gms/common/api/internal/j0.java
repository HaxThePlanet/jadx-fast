package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.p.a;

/* loaded from: classes2.dex */
final class j0 {

    private final com.google.android.gms.common.api.internal.c<?> a;
    private final d b;
    j0(com.google.android.gms.common.api.internal.c c, d d2, com.google.android.gms.common.api.internal.d0 d03) {
        super();
        this.a = c;
        this.b = d2;
    }

    static com.google.android.gms.common.api.internal.c a(com.google.android.gms.common.api.internal.j0 j0) {
        return j0.a;
    }

    static d b(com.google.android.gms.common.api.internal.j0 j0) {
        return j0.b;
    }

    public final boolean equals(Object object) {
        boolean z;
        com.google.android.gms.common.api.internal.c cVar;
        Object obj4;
        if ((j0)object != null && object instanceof j0 && p.a(this.a, object.a) && p.a(this.b, object.b)) {
            if (object instanceof j0) {
                if (p.a(this.a, object.a)) {
                    if (p.a(this.b, object.b)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public final int hashCode() {
        Object[] arr = new Object[2];
        return p.b(this.a, this.b);
    }

    public final String toString() {
        p.a aVar = p.c(this);
        aVar.a("key", this.a);
        aVar.a("feature", this.b);
        return aVar.toString();
    }
}

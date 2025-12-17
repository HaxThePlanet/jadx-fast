package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.p;

/* loaded from: classes2.dex */
public final class c<O extends com.google.android.gms.common.api.a.d>  {

    private final int a;
    private final a<O> b;
    private final O c;
    private final String d;
    private c(a<O> a, O o2, String string3) {
        super();
        this.b = a;
        this.c = o2;
        this.d = string3;
        Object[] arr = new Object[3];
        this.a = p.b(a, o2, string3);
    }

    public static <O extends com.google.android.gms.common.api.a.d> com.google.android.gms.common.api.internal.c<O> a(a<O> a, O o2, String string3) {
        c cVar = new c(a, o2, string3);
        return cVar;
    }

    public final String b() {
        return this.b.c();
    }

    public final boolean equals(Object object) {
        boolean z;
        Object aVar;
        Object obj5;
        final int i = 0;
        if (object == null) {
            return i;
        }
        final int i2 = 1;
        if (object == this) {
            return i2;
        }
        if (!object instanceof c) {
            return i;
        }
        if (p.a(this.b, object.b) && p.a(this.c, object.c) && p.a(this.d, object.d)) {
            if (p.a(this.c, object.c)) {
                if (p.a(this.d, object.d)) {
                    return i2;
                }
            }
        }
        return i;
    }

    public final int hashCode() {
        return this.a;
    }
}

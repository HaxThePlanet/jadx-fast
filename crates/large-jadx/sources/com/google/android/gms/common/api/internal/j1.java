package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.d;
import com.google.android.gms.tasks.k;
import java.util.Map;

/* loaded from: classes2.dex */
public final class j1 extends com.google.android.gms.common.api.internal.g1<Boolean> {

    public final com.google.android.gms.common.api.internal.j.a<?> c;
    public j1(com.google.android.gms.common.api.internal.j.a<?> j$a, k<Boolean> k2) {
        super(4, k2);
        this.c = a;
    }

    @Override // com.google.android.gms.common.api.internal.g1
    public final void c(com.google.android.gms.common.api.internal.x x, boolean z2) {
    }

    public final d[] f(com.google.android.gms.common.api.internal.i0<?> i0) {
        Object obj2 = i0.w().get(this.c);
        if ((w0)obj2 == null) {
            return null;
        }
        return obj2.a.c();
    }

    public final boolean g(com.google.android.gms.common.api.internal.i0<?> i0) {
        Object obj2 = i0.w().get(this.c);
        if ((w0)obj2 != null) {
        } else {
            return 0;
        }
        obj2.a.e();
        throw 0;
    }

    public final void h(com.google.android.gms.common.api.internal.i0<?> i0) {
        Object remove = i0.w().remove(this.c);
        if ((w0)remove != null) {
            remove.b.b(i0.v(), this.b);
            remove.a.a();
        }
        this.b.e(Boolean.FALSE);
    }
}

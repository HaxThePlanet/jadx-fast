package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.e;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public class q {

    private static final com.google.android.gms.common.internal.p0 a;

    public interface a {
        public abstract T a(R r);
    }
    static {
        l0 l0Var = new l0();
        q.a = l0Var;
    }

    public static <R extends com.google.android.gms.common.api.i, T extends com.google.android.gms.common.api.h<R>> j<T> a(e<R> e, T t2) {
        n0 n0Var = new n0(t2);
        return q.b(e, n0Var);
    }

    public static <R extends com.google.android.gms.common.api.i, T> j<T> b(e<R> e, com.google.android.gms.common.internal.q.a<R, T> q$a2) {
        k kVar = new k();
        m0 m0Var = new m0(e, kVar, a2, q.a);
        e.a(m0Var);
        return kVar.a();
    }

    public static <R extends com.google.android.gms.common.api.i> j<Void> c(e<R> e) {
        o0 o0Var = new o0();
        return q.b(e, o0Var);
    }
}

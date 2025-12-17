package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public abstract class t<A extends com.google.android.gms.common.api.a.b, ResultT>  {

    private final d[] zaa;
    private final boolean zab;
    private final int zac;

    public static class a {

        private com.google.android.gms.common.api.internal.p<A, k<ResultT>> a;
        private boolean b = true;
        private d[] c;
        private int d = 0;
        a(com.google.android.gms.common.api.internal.b1 b1) {
            super();
            int obj1 = 1;
            obj1 = 0;
        }

        static com.google.android.gms.common.api.internal.p e(com.google.android.gms.common.api.internal.t.a t$a) {
            return a.a;
        }

        public com.google.android.gms.common.api.internal.t<A, ResultT> a() {
            int i;
            i = this.a != null ? 1 : 0;
            r.b(i, "execute parameter required");
            c1 c1Var = new c1(this, this.c, this.b, this.d);
            return c1Var;
        }

        public com.google.android.gms.common.api.internal.t.a<A, ResultT> b(com.google.android.gms.common.api.internal.p<A, k<ResultT>> p) {
            this.a = p;
            return this;
        }

        public com.google.android.gms.common.api.internal.t.a<A, ResultT> c(boolean z) {
            this.b = z;
            return this;
        }

        public com.google.android.gms.common.api.internal.t.a<A, ResultT> d(d... dArr) {
            this.c = dArr;
            return this;
        }
    }
    @Deprecated
    public t() {
        super();
        this.zaa = 0;
        int i2 = 0;
        this.zab = i2;
        this.zac = i2;
    }

    protected t(d[] dArr, boolean z2, int i3) {
        int i;
        super();
        this.zaa = dArr;
        i = 0;
        if (dArr != null && z2) {
            i = z2 ? 1 : i;
        }
        this.zab = i;
        this.zac = i3;
    }

    public static <A extends com.google.android.gms.common.api.a.b, ResultT> com.google.android.gms.common.api.internal.t.a<A, ResultT> builder() {
        t.a aVar = new t.a(0);
        return aVar;
    }

    protected abstract void doExecute(A a, k<ResultT> k2);

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final d[] zaa() {
        return this.zaa;
    }

    public final int zab() {
        return this.zac;
    }
}

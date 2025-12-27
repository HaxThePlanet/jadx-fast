package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;

/* compiled from: InternalChannelz.java */
/* loaded from: classes2.dex */
public final class e0 {

    public final String a;
    public final e0.b b;
    public final long c;
    public final m0 d;
    public final m0 e;

    public static final class a {

        private String a;
        private e0.b b;
        private Long c;
        private m0 d;
        private m0 e;
        public e0 a() {
            boolean z = false;
            n.p(this.a, "description");
            n.p(this.b, "severity");
            n.p(this.c, "timestampNanos");
            if (this.d == null || this.e == null) {
                int i2 = 1;
            }
            n.v(z, "at least one of channelRef and subchannelRef must be null");
            e0 e0Var = new e0(this.a, this.b, this.c.longValue(), m0Var2, this.d, this.e, 0);
            return e0Var;
        }

        public e0.a b(String str) {
            this.a = str;
            return this;
        }

        public e0.a c(e0.b bVar) {
            this.b = bVar;
            return this;
        }

        public e0.a d(m0 m0Var) {
            this.e = m0Var;
            return this;
        }

        public e0.a e(long j) {
            this.c = Long.valueOf(j);
            return this;
        }
    }

    public enum b {

        CT_ERROR,
        CT_INFO,
        CT_UNKNOWN,
        CT_WARNING;
    }
    /* synthetic */ e0(String str, e0.b bVar, long j, m0 m0Var, m0 m0Var2, d0.a aVar) {
        this(str, bVar, j, r4, m0Var, m0Var2);
    }

    public boolean equals(Object object) {
        boolean z3 = false;
        z = object instanceof e0;
        int i = 0;
        if (object instanceof e0) {
            if (k.a(this.a, object.a)) {
                if (k.a(this.b, object.b)) {
                    if (this.c == object.c) {
                        if (k.a(this.d, object.d)) {
                            if (k.a(this.e, object.e)) {
                                int i2 = 1;
                            }
                        }
                    }
                }
            }
        }
        return z3;
    }

    public int hashCode() {
        Object[] arr = new Object[5];
        int i4 = 1;
        arr[i4] = this.b;
        arr[2] = Long.valueOf(this.c);
        arr[3] = this.d;
        arr[4] = this.e;
        return k.b(arr);
    }

    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("description", this.a);
        String str3 = "severity";
        bVar.d(str3, this.b);
        bVar.c("timestampNanos", this.c);
        bVar.d("channelRef", this.d);
        bVar.d("subchannelRef", this.e);
        return bVar.toString();
    }

    private e0(String str, e0.b bVar, long j, m0 m0Var, m0 m0Var2) {
        super();
        this.a = str;
        n.p(bVar, "severity");
        this.b = bVar;
        this.c = j;
        this.d = m0Var;
        this.e = m0Var2;
    }
}

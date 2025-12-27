package io.grpc;

import com.google.common.base.n;

/* compiled from: ConnectivityStateInfo.java */
/* loaded from: classes2.dex */
public final class r {

    private final q a;
    private final d1 b;
    private r(q qVar, d1 d1Var) {
        super();
        n.p(qVar, "state is null");
        this.a = qVar;
        n.p(d1Var, "status is null");
        this.b = d1Var;
    }

    public static r a(q qVar) {
        boolean z = true;
        int r0 = qVar != q.TRANSIENT_FAILURE ? 1 : 0;
        n.e((qVar != q.TRANSIENT_FAILURE ? 1 : 0), "state is TRANSIENT_ERROR. Use forError() instead");
        return (qVar != q.TRANSIENT_FAILURE ? 1 : 0);
    }

    public static r b(d1 d1Var) {
        n.e(!d1Var.p(), "The error status must not be OK");
        return new r(q.TRANSIENT_FAILURE, d1Var);
    }

    public q c() {
        return this.a;
    }

    public d1 d() {
        return this.b;
    }

    public boolean equals(Object object) {
        boolean z = false;
        z = false;
        if (!(object instanceof r)) {
            return false;
        }
        if (this.a.equals(object.a)) {
            if (this.b.equals(object.b)) {
                int i = 1;
            }
        }
        return z;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public String toString() {
        if (this.b.p()) {
            return this.a.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "(";
        String str3 = ")";
        str = this.a + str2 + this.b + str3;
        return str;
    }
}

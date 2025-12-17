package io.grpc;

import com.google.common.base.n;

/* loaded from: classes2.dex */
public final class r {

    private final io.grpc.q a;
    private final io.grpc.d1 b;
    private r(io.grpc.q q, io.grpc.d1 d12) {
        super();
        n.p(q, "state is null");
        this.a = (q)q;
        n.p(d12, "status is null");
        this.b = (d1)d12;
    }

    public static io.grpc.r a(io.grpc.q q) {
        int i;
        i = q != q.TRANSIENT_FAILURE ? 1 : 0;
        n.e(i, "state is TRANSIENT_ERROR. Use forError() instead");
        r rVar = new r(q, d1.f);
        return rVar;
    }

    public static io.grpc.r b(io.grpc.d1 d1) {
        n.e(z ^= 1, "The error status must not be OK");
        r rVar = new r(q.TRANSIENT_FAILURE, d1);
        return rVar;
    }

    public io.grpc.q c() {
        return this.a;
    }

    public io.grpc.d1 d() {
        return this.b;
    }

    public boolean equals(Object object) {
        boolean equals;
        int i;
        Object obj4;
        if (!object instanceof r) {
            return 0;
        }
        if (this.a.equals(object.a) && this.b.equals(object.b)) {
            if (this.b.equals(object.b)) {
                i = 1;
            }
        }
        return i;
    }

    public int hashCode() {
        return i ^= i3;
    }

    public String toString() {
        if (this.b.p()) {
            return this.a.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("(");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

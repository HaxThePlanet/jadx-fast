package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;

/* loaded from: classes2.dex */
public final class e0 {

    public final String a;
    public final io.grpc.e0.b b;
    public final long c;
    public final io.grpc.m0 d;
    public final io.grpc.m0 e;

    public static final class a {

        private String a;
        private io.grpc.e0.b b;
        private Long c;
        private io.grpc.m0 d;
        private io.grpc.m0 e;
        public io.grpc.e0 a() {
            int i;
            io.grpc.m0 m0Var;
            n.p(this.a, "description");
            n.p(this.b, "severity");
            n.p(this.c, "timestampNanos");
            if (this.d != null) {
                if (this.e == null) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            n.v(i, "at least one of channelRef and subchannelRef must be null");
            super(this.a, this.b, this.c.longValue(), obj6, this.d, this.e, 0);
            return e0Var;
        }

        public io.grpc.e0.a b(String string) {
            this.a = string;
            return this;
        }

        public io.grpc.e0.a c(io.grpc.e0.b e0$b) {
            this.b = b;
            return this;
        }

        public io.grpc.e0.a d(io.grpc.m0 m0) {
            this.e = m0;
            return this;
        }

        public io.grpc.e0.a e(long l) {
            this.c = Long.valueOf(l);
            return this;
        }
    }

    public static enum b {

        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR;
    }
    private e0(String string, io.grpc.e0.b e0$b2, long l3, io.grpc.m0 m04, io.grpc.m0 m05) {
        super();
        this.a = string;
        n.p(b2, "severity");
        this.b = (e0.b)b2;
        this.c = l3;
        this.d = m05;
        this.e = obj6;
    }

    e0(String string, io.grpc.e0.b e0$b2, long l3, io.grpc.m0 m04, io.grpc.m0 m05, io.grpc.d0.a d0$a6) {
        super(string, b2, l3, m04, m05, a6);
    }

    public boolean equals(Object object) {
        boolean cmp;
        int i;
        String str;
        long l;
        Object obj7;
        i = 0;
        if (object instanceof e0 && k.a(this.a, object.a) && k.a(this.b, object.b) && Long.compare(str, l) == 0 && k.a(this.d, object.d) && k.a(this.e, object.e)) {
            if (k.a(this.a, object.a)) {
                if (k.a(this.b, object.b)) {
                    if (Long.compare(str, l) == 0) {
                        if (k.a(this.d, object.d)) {
                            if (k.a(this.e, object.e)) {
                                i = 1;
                            }
                        }
                    }
                }
            }
        }
        return i;
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
}

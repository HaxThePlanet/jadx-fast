package io.grpc.m1;

import io.grpc.d;
import io.grpc.e;

/* loaded from: classes3.dex */
public abstract class a<S extends io.grpc.m1.a<S>>  extends io.grpc.m1.c<S> {
    static {
    }

    protected a(e e, d d2) {
        super(e, d2);
    }

    public static <T extends io.grpc.m1.c<T>> T g(io.grpc.m1.c.a<T> c$a, e e2) {
        return a.h(a, e2, d.k);
    }

    public static <T extends io.grpc.m1.c<T>> T h(io.grpc.m1.c.a<T> c$a, e e2, d d3) {
        return a.a(e2, d3.q(d.b, d.d.ASYNC));
    }
}

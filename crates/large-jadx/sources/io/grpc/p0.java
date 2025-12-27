package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import java.util.Map;

/* compiled from: LoadBalancerProvider.java */
/* loaded from: classes2.dex */
public abstract class p0 extends o0.c {

    private static final v0.c a;

    private static final class a {
        a() {
            super();
        }

        public String toString() {
            return "service config is unused";
        }
    }
    static {
        p0.a = v0.c.a(new p0.a());
    }

    @Override // io.grpc.o0$c
    public v0.c e(Map<String, ?> map) {
        return p0.a;
    }

    @Override // io.grpc.o0$c
    public final int hashCode() {
        return super.hashCode();
    }

    @Override // io.grpc.o0$c
    public final String toString() {
        j.b bVar = j.c(this);
        bVar.d("policy", b());
        bVar.b("priority", c());
        bVar.e("available", d());
        return bVar.toString();
    }

    @Override // io.grpc.o0$c
    public abstract String b();

    @Override // io.grpc.o0$c
    public abstract int c();

    @Override // io.grpc.o0$c
    public abstract boolean d();

    @Override // io.grpc.o0$c
    public final boolean equals(Object object) {
        boolean z = true;
        object = this == object ? 1 : 0;
        return (this == object ? 1 : 0);
    }
}

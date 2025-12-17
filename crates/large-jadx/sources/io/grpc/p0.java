package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class p0 extends io.grpc.o0.c {

    private static final io.grpc.v0.c a;

    private static final class a {
        public String toString() {
            return "service config is unused";
        }
    }
    static {
        p0.a aVar = new p0.a();
        p0.a = v0.c.a(aVar);
    }

    @Override // io.grpc.o0$c
    public abstract String b();

    @Override // io.grpc.o0$c
    public abstract int c();

    @Override // io.grpc.o0$c
    public abstract boolean d();

    public io.grpc.v0.c e(Map<String, ?> map) {
        return p0.a;
    }

    @Override // io.grpc.o0$c
    public final boolean equals(Object object) {
        int obj1;
        obj1 = this == object ? 1 : 0;
        return obj1;
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
}

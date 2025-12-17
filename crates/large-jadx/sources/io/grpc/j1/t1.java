package io.grpc.j1;

import com.google.common.base.k;
import com.google.common.base.n;
import io.grpc.d;
import io.grpc.o0.f;
import io.grpc.t0;
import io.grpc.u0;

/* loaded from: classes3.dex */
public final class t1 extends o0.f {

    private final d a;
    private final t0 b;
    private final u0<?, ?> c;
    public t1(u0<?, ?> u0, t0 t02, d d3) {
        super();
        n.p(u0, "method");
        this.c = (u0)u0;
        n.p(t02, "headers");
        this.b = (t0)t02;
        n.p(d3, "callOptions");
        this.a = (d)d3;
    }

    @Override // io.grpc.o0$f
    public d a() {
        return this.a;
    }

    @Override // io.grpc.o0$f
    public t0 b() {
        return this.b;
    }

    public u0<?, ?> c() {
        return this.c;
    }

    @Override // io.grpc.o0$f
    public boolean equals(Object object) {
        int i;
        u0 z;
        Class<io.grpc.j1.t1> obj;
        Object dVar;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (t1.class != object.getClass()) {
            } else {
                if (k.a(this.a, object.a) && k.a(this.b, object.b) && k.a(this.c, object.c)) {
                    if (k.a(this.b, object.b)) {
                        if (k.a(this.c, object.c)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // io.grpc.o0$f
    public int hashCode() {
        Object[] arr = new Object[3];
        return k.b(this.a, this.b, this.c);
    }

    @Override // io.grpc.o0$f
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[method=");
        stringBuilder.append(this.c);
        stringBuilder.append(" headers=");
        stringBuilder.append(this.b);
        stringBuilder.append(" callOptions=");
        stringBuilder.append(this.a);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

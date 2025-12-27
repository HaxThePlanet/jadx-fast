package io.grpc;

import com.google.common.base.j;
import com.google.common.base.j.b;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingChannelBuilder.java */
/* loaded from: classes2.dex */
public abstract class z<T extends z<T>> extends s0<T> {
    protected z() {
        super();
    }

    @Override // io.grpc.s0
    public T f(long j, TimeUnit timeUnit) {
        e().c(j, timeUnit);
        g();
        return this;
    }

    @Override // io.grpc.s0
    public T h() {
        e().d();
        g();
        return this;
    }

    @Override // io.grpc.s0
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", e());
        return bVar.toString();
    }

    @Override // io.grpc.s0
    protected abstract s0<?> e();

    @Override // io.grpc.s0
    protected final T g() {
        return this;
    }
}

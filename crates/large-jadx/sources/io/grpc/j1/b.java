package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import io.grpc.r0;
import io.grpc.s0;

/* loaded from: classes3.dex */
public abstract class b<T extends s0<T>>  extends s0<T> {
    @Override // io.grpc.s0
    public r0 a() {
        return e().a();
    }

    protected abstract s0<?> e();

    @Override // io.grpc.s0
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", e());
        return bVar.toString();
    }
}

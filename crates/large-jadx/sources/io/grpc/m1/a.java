package io.grpc.m1;

import io.grpc.d;
import io.grpc.e;

/* compiled from: AbstractAsyncStub.java */
/* loaded from: classes3.dex */
public abstract class a<S extends a<S>> extends c<S> {
    protected a(e eVar, d dVar) {
        super(eVar, dVar);
    }

    public static <T extends c<T>> T g(c.a<T> aVar, e eVar) {
        return a.h(aVar, eVar, d.k);
    }

    public static <T extends c<T>> T h(c.a<T> aVar, e eVar, d dVar) {
        return aVar.a(eVar, dVar.q(d.b, d.d.ASYNC));
    }

}

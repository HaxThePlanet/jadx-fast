package io.grpc.m1;

import io.grpc.d;
import io.grpc.e;

/* compiled from: AbstractBlockingStub.java */
/* loaded from: classes3.dex */
public abstract class b<S extends b<S>> extends c<S> {
    protected b(e eVar, d dVar) {
        super(eVar, dVar);
    }

    public static <T extends c<T>> T g(c.a<T> aVar, e eVar) {
        return b.h(aVar, eVar, d.k);
    }

    public static <T extends c<T>> T h(c.a<T> aVar, e eVar, d dVar) {
        return aVar.a(eVar, dVar.q(d.b, d.d.BLOCKING));
    }

}

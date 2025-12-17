package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import f.c.f.a.a.a.e.g.b;
import j.a.a;

/* loaded from: classes2.dex */
public final class GrpcClient_Factory implements Factory<com.google.firebase.inappmessaging.internal.GrpcClient> {

    private final a<g.b> stubProvider;
    public GrpcClient_Factory(a<g.b> a) {
        super();
        this.stubProvider = a;
    }

    public static com.google.firebase.inappmessaging.internal.GrpcClient_Factory create(a<g.b> a) {
        GrpcClient_Factory grpcClient_Factory = new GrpcClient_Factory(a);
        return grpcClient_Factory;
    }

    public static com.google.firebase.inappmessaging.internal.GrpcClient newInstance(g.b g$b) {
        GrpcClient grpcClient = new GrpcClient(b);
        return grpcClient;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.GrpcClient get() {
        return GrpcClient_Factory.newInstance((g.b)this.stubProvider.get());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}

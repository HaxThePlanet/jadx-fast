package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import f.c.f.a.a.a.e.d;
import f.c.f.a.a.a.e.e;
import f.c.f.a.a.a.e.g.b;
import io.grpc.m1.c;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class GrpcClient {

    private final g.b stub;
    GrpcClient(g.b g$b) {
        super();
        this.stub = b;
    }

    public e fetchEligibleCampaigns(d d) {
        return (g.b)this.stub.e(30000, obj3).j(d);
    }
}

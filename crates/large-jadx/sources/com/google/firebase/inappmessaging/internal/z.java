package com.google.firebase.inappmessaging.internal;

import f.c.f.a.a.a.e.a;
import i.b.l0.n;

/* loaded from: classes2.dex */
public final class z implements n {

    public final com.google.firebase.inappmessaging.internal.ImpressionStorageClient a;
    public final a b;
    public z(com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient, a a2) {
        super();
        this.a = impressionStorageClient;
        this.b = a2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return this.a.k(this.b, (b)object);
    }
}

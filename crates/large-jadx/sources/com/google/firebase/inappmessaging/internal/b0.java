package com.google.firebase.inappmessaging.internal;

import i.b.l0.f;

/* loaded from: classes2.dex */
public final class b0 implements f {

    public final com.google.firebase.inappmessaging.internal.ImpressionStorageClient a;
    public b0(com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient) {
        super();
        this.a = impressionStorageClient;
    }

    @Override // i.b.l0.f
    public final void accept(Object object) {
        ImpressionStorageClient.a(this.a, (b)object);
    }
}

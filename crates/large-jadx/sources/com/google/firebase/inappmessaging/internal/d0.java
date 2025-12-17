package com.google.firebase.inappmessaging.internal;

import f.c.f.a.a.a.e.b;
import i.b.l0.a;

/* loaded from: classes2.dex */
public final class d0 implements a {

    public final com.google.firebase.inappmessaging.internal.ImpressionStorageClient a;
    public final b b;
    public d0(com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient, b b2) {
        super();
        this.a = impressionStorageClient;
        this.b = b2;
    }

    @Override // i.b.l0.a
    public final void run() {
        this.a.c(this.b);
    }
}

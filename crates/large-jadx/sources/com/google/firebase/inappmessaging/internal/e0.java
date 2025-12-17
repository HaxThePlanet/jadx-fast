package com.google.firebase.inappmessaging.internal;

import i.b.l0.n;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class e0 implements n {

    public final com.google.firebase.inappmessaging.internal.ImpressionStorageClient a;
    public final HashSet b;
    public e0(com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient, HashSet hashSet2) {
        super();
        this.a = impressionStorageClient;
        this.b = hashSet2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return this.a.e(this.b, (b)object);
    }
}

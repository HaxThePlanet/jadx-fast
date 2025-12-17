package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class d implements c {

    public final com.google.firebase.remoteconfig.internal.ConfigFetchHandler a;
    public final long b;
    public d(com.google.firebase.remoteconfig.internal.ConfigFetchHandler configFetchHandler, long l2) {
        super();
        this.a = configFetchHandler;
        this.b = l2;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.b(this.b, obj2);
    }
}

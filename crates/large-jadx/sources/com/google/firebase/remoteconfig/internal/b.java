package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class b implements i {

    public final com.google.firebase.remoteconfig.internal.ConfigCacheClient a;
    public final boolean b;
    public final com.google.firebase.remoteconfig.internal.ConfigContainer c;
    public b(com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient, boolean z2, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer3) {
        super();
        this.a = configCacheClient;
        this.b = z2;
        this.c = configContainer3;
    }

    @Override // com.google.android.gms.tasks.i
    public final j then(Object object) {
        return this.a.d(this.b, this.c, (Void)object);
    }
}

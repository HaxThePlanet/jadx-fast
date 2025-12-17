package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class f implements i {

    public final com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse a;
    public f(com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse configFetchHandler$FetchResponse) {
        super();
        this.a = fetchResponse;
    }

    @Override // com.google.android.gms.tasks.i
    public final j then(Object object) {
        return ConfigFetchHandler.c(this.a, (ConfigContainer)object);
    }
}

package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class c implements i {

    public static final com.google.firebase.remoteconfig.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    @Override // com.google.android.gms.tasks.i
    public final j then(Object object) {
        return FirebaseRemoteConfig.d((ConfigFetchHandler.FetchResponse)object);
    }
}

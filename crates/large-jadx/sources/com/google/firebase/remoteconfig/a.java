package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class a implements i {

    public static final com.google.firebase.remoteconfig.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // com.google.android.gms.tasks.i
    public final j then(Object object) {
        return FirebaseRemoteConfig.e((ConfigFetchHandler.FetchResponse)object);
    }
}

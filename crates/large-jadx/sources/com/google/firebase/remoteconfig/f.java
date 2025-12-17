package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class f implements i {

    public final com.google.firebase.remoteconfig.FirebaseRemoteConfig a;
    public f(com.google.firebase.remoteconfig.FirebaseRemoteConfig firebaseRemoteConfig) {
        super();
        this.a = firebaseRemoteConfig;
    }

    @Override // com.google.android.gms.tasks.i
    public final j then(Object object) {
        return this.a.g((Void)object);
    }
}

package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class i implements c {

    public final com.google.firebase.remoteconfig.FirebaseRemoteConfig a;
    public i(com.google.firebase.remoteconfig.FirebaseRemoteConfig firebaseRemoteConfig) {
        super();
        this.a = firebaseRemoteConfig;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return Boolean.valueOf(FirebaseRemoteConfig.h(this.a, j));
    }
}

package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class g implements c {

    public final com.google.firebase.remoteconfig.FirebaseRemoteConfig a;
    public final j b;
    public final j c;
    public g(com.google.firebase.remoteconfig.FirebaseRemoteConfig firebaseRemoteConfig, j j2, j j3) {
        super();
        this.a = firebaseRemoteConfig;
        this.b = j2;
        this.c = j3;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.b(this.b, this.c, j);
    }
}

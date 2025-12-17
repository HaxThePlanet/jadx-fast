package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class h implements c {

    public final j a;
    public h(j j) {
        super();
        this.a = j;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return FirebaseRemoteConfig.c(this.a, j);
    }
}

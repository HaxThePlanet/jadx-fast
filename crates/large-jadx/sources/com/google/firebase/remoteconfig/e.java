package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class e implements i {

    public static final com.google.firebase.remoteconfig.e a;
    static {
        e eVar = new e();
        e.a = eVar;
    }

    @Override // com.google.android.gms.tasks.i
    public final j then(Object object) {
        return FirebaseRemoteConfig.m((ConfigContainer)object);
    }
}

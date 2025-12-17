package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.g;
import io.grpc.h;

/* loaded from: classes2.dex */
public final class z implements g {

    public static final com.google.firebase.firestore.remote.z a;
    static {
        z zVar = new z();
        z.a = zVar;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        (h)object.halfClose();
    }
}

package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class i implements c {

    public final com.google.firebase.firestore.remote.Datastore a;
    public i(com.google.firebase.firestore.remote.Datastore datastore) {
        super();
        this.a = datastore;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.b(j);
    }
}

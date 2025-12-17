package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import java.util.List;

/* loaded from: classes2.dex */
public final class j implements c {

    public final com.google.firebase.firestore.remote.Datastore a;
    public final List b;
    public j(com.google.firebase.firestore.remote.Datastore datastore, List list2) {
        super();
        this.a = datastore;
        this.b = list2;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.d(this.b, j);
    }
}

package com.google.firebase.database.connection;

import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class b implements g {

    public final com.google.firebase.database.connection.PersistentConnectionImpl a;
    public final long b;
    public final j c;
    public final j d;
    public b(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, long l2, j j3, j j4) {
        super();
        this.a = persistentConnectionImpl;
        this.b = l2;
        this.c = j4;
        this.d = obj5;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.h(this.b, obj2, this.c, this.d);
    }
}

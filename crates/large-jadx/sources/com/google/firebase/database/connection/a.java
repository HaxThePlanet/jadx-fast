package com.google.firebase.database.connection;

import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    public final com.google.firebase.database.connection.PersistentConnectionImpl a;
    public final com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingGet b;
    public final long c;
    public final k v;
    public a(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingGet persistentConnectionImpl$OutstandingGet2, long l3, k k4) {
        super();
        this.a = persistentConnectionImpl;
        this.b = outstandingGet2;
        this.c = l3;
        this.v = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b, this.c, obj3);
    }
}

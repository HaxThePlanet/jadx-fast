package com.google.firebase.database.connection;

import com.google.android.gms.tasks.k;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f implements com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback {

    public final com.google.firebase.database.connection.PersistentConnectionImpl a;
    public final com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec b;
    public final k c;
    public f(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec2, k k3) {
        super();
        this.a = persistentConnectionImpl;
        this.b = querySpec2;
        this.c = k3;
    }

    @Override // com.google.firebase.database.connection.PersistentConnectionImpl$ConnectionRequestCallback
    public final void onResponse(Map map) {
        this.a.b(this.b, this.c, map);
    }
}

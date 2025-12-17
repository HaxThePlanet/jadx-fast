package com.google.firebase.database.connection;

import com.google.android.gms.tasks.f;

/* loaded from: classes2.dex */
public final class e implements f {

    public final com.google.firebase.database.connection.PersistentConnectionImpl a;
    public final long b;
    public e(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, long l2) {
        super();
        this.a = persistentConnectionImpl;
        this.b = l2;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        this.a.j(this.b, obj2);
    }
}

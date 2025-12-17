package com.google.firebase.database.connection;

/* loaded from: classes2.dex */
public final class d implements Runnable {

    public final com.google.firebase.database.connection.PersistentConnectionImpl a;
    public final boolean b;
    public final boolean c;
    public d(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, boolean z2, boolean z3) {
        super();
        this.a = persistentConnectionImpl;
        this.b = z2;
        this.c = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.l(this.b, this.c);
    }
}

package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public class g {

    protected volatile com.google.android.gms.internal.firebase-auth-api.y a;
    private volatile com.google.android.gms.internal.firebase-auth-api.wq b;
    static {
        lr.a();
    }

    public final int a() {
        if (this.b != null) {
            return zza.length;
        }
        if (this.a != null) {
            return this.a.o();
        }
        return 0;
    }

    public final com.google.android.gms.internal.firebase-auth-api.wq b() {
        com.google.android.gms.internal.firebase-auth-api.wq wqVar;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            return this.b;
        }
    }

    protected final void c(com.google.android.gms.internal.firebase-auth-api.y y) {
        com.google.android.gms.internal.firebase-auth-api.y obj2;
        if (this.a != null) {
        }
        synchronized (this) {
            this.a = y;
            this.b = wq.a;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof g) {
            return 0;
        }
        com.google.android.gms.internal.firebase-auth-api.y yVar = this.a;
        com.google.android.gms.internal.firebase-auth-api.y yVar2 = object.a;
        if (yVar == null && yVar2 != null) {
            if (yVar2 != null) {
            }
            return b().equals((g)object.b());
        }
        if (yVar != null && yVar2 == null) {
            if (yVar2 == null) {
            }
            return yVar.equals(yVar2);
        }
        if (yVar != null) {
            object.c(yVar.p());
            return yVar.equals(object.a);
        }
        c(yVar2.p());
        return this.a.equals(yVar2);
    }

    public int hashCode() {
        return 1;
    }
}

package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public class f9 {

    protected volatile com.google.android.gms.internal.measurement.y9 a;
    private volatile com.google.android.gms.internal.measurement.x7 b;
    static {
        j8.a();
    }

    public final int a() {
        if (this.b != null) {
            return zza.length;
        }
        if (this.a != null) {
            return this.a.b();
        }
        return 0;
    }

    public final com.google.android.gms.internal.measurement.x7 b() {
        com.google.android.gms.internal.measurement.x7 x7Var;
        if (this.b != null) {
            return this.b;
        }
        synchronized (this) {
            return this.b;
        }
    }

    protected final void c(com.google.android.gms.internal.measurement.y9 y9) {
        com.google.android.gms.internal.measurement.y9 obj2;
        if (this.a != null) {
        }
        synchronized (this) {
            this.a = y9;
            this.b = x7.a;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof f9) {
            return 0;
        }
        com.google.android.gms.internal.measurement.y9 y9Var = this.a;
        com.google.android.gms.internal.measurement.y9 y9Var2 = object.a;
        if (y9Var == null && y9Var2 != null) {
            if (y9Var2 != null) {
            }
            return b().equals((f9)object.b());
        }
        if (y9Var != null && y9Var2 == null) {
            if (y9Var2 == null) {
            }
            return y9Var.equals(y9Var2);
        }
        if (y9Var != null) {
            object.c(y9Var.e());
            return y9Var.equals(object.a);
        }
        c(y9Var2.e());
        return this.a.equals(y9Var2);
    }

    public int hashCode() {
        return 1;
    }
}

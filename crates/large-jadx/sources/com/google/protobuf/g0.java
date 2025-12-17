package com.google.protobuf;

/* loaded from: classes2.dex */
public class g0 {

    private com.google.protobuf.j a;
    private com.google.protobuf.q b;
    protected volatile com.google.protobuf.t0 c;
    private volatile com.google.protobuf.j d;
    static {
        q.b();
    }

    protected void a(com.google.protobuf.t0 t0) {
        com.google.protobuf.j jVar2;
        com.google.protobuf.j jVar;
        com.google.protobuf.q qVar;
        com.google.protobuf.t0 obj4;
        if (this.c != null) {
        }
        synchronized (this) {
        }
    }

    public int b() {
        if (this.d != null) {
            return this.d.size();
        }
        com.google.protobuf.j jVar3 = this.a;
        if (jVar3 != null) {
            return jVar3.size();
        }
        if (this.c != null) {
            return this.c.getSerializedSize();
        }
        return 0;
    }

    public com.google.protobuf.t0 c(com.google.protobuf.t0 t0) {
        a(t0);
        return this.c;
    }

    public com.google.protobuf.t0 d(com.google.protobuf.t0 t0) {
        final int i = 0;
        this.a = i;
        this.d = i;
        this.c = t0;
        return this.c;
    }

    public com.google.protobuf.j e() {
        com.google.protobuf.j byteString;
        if (this.d != null) {
            return this.d;
        }
        com.google.protobuf.j jVar2 = this.a;
        if (jVar2 != null) {
            return jVar2;
        }
        synchronized (this) {
            return this.d;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof g0) {
            return 0;
        }
        com.google.protobuf.t0 t0Var = this.c;
        com.google.protobuf.t0 t0Var2 = object.c;
        if (t0Var == null && t0Var2 == null) {
            if (t0Var2 == null) {
                return e().equals((g0)object.e());
            }
        }
        if (t0Var != null && t0Var2 != null) {
            if (t0Var2 != null) {
                return t0Var.equals(t0Var2);
            }
        }
        if (t0Var != null) {
            return t0Var.equals(object.c(t0Var.getDefaultInstanceForType()));
        }
        return c(t0Var2.getDefaultInstanceForType()).equals(t0Var2);
    }

    public int hashCode() {
        return 1;
    }
}

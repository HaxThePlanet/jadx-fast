package io.grpc.k1.r.j;

import l.i;

/* compiled from: Header.java */
/* loaded from: classes3.dex */
public final class d {

    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public final i a;
    public final i b;
    final int c;
    static {
        d.d = i.i(":status");
        d.e = i.i(":method");
        d.f = i.i(":path");
        d.g = i.i(":scheme");
        d.h = i.i(":authority");
        i.i(":host");
        i.i(":version");
    }

    public d(String str, String str2) {
        this(i.i(str), i.i(str2));
    }

    public boolean equals(Object object) {
        boolean z = false;
        equals = object instanceof d;
        int i = 0;
        if (object instanceof d) {
            if (this.a.equals(object.a)) {
                if (this.b.equals(object.b)) {
                    int i2 = 1;
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return (527 + this.a.hashCode()) * 31 + this.b.hashCode();
    }

    public String toString() {
        Object[] arr = new Object[2];
        return String.format("%s: %s", new Object[] { this.a.E(), this.b.E() });
    }

    public d(i iVar, String str) {
        this(iVar, i.i(str));
    }

    public d(i iVar, i iVar2) {
        super();
        this.a = iVar;
        this.b = iVar2;
        this.c = (iVar.A() + 32) + iVar2.A();
    }
}

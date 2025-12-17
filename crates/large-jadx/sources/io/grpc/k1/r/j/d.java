package io.grpc.k1.r.j;

import l.i;

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

    public d(String string, String string2) {
        super(i.i(string), i.i(string2));
    }

    public d(i i, String string2) {
        super(i, i.i(string2));
    }

    public d(i i, i i2) {
        super();
        this.a = i;
        this.b = i2;
        this.c = obj1 += obj2;
    }

    public boolean equals(Object object) {
        boolean equals;
        int i;
        i iVar;
        Object obj4;
        i = 0;
        if (object instanceof d && this.a.equals(object.a) && this.b.equals(object.b)) {
            if (this.a.equals(object.a)) {
                if (this.b.equals(object.b)) {
                    i = 1;
                }
            }
        }
        return i;
    }

    public int hashCode() {
        return i5 += i2;
    }

    public String toString() {
        Object[] arr = new Object[2];
        return String.format("%s: %s", this.a.E(), this.b.E());
    }
}

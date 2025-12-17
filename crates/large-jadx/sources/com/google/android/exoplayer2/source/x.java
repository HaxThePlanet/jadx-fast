package com.google.android.exoplayer2.source;

/* loaded from: classes2.dex */
public class x {

    public final Object a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;
    protected x(com.google.android.exoplayer2.source.x x) {
        super();
        this.a = x.a;
        this.b = x.b;
        this.c = x.c;
        this.d = x.d;
        this.e = x.e;
    }

    public x(Object object) {
        super(object, -1, obj1);
    }

    public x(Object object, int i2, int i3, long l4) {
        super(object, i2, i3, l4, obj5, -1);
    }

    private x(Object object, int i2, int i3, long l4, int i5) {
        super();
        this.a = object;
        this.b = i2;
        this.c = i3;
        this.d = l4;
        this.e = obj6;
    }

    public x(Object object, long l2) {
        super(object, -1, -1, l2, obj5, -1);
    }

    public x(Object object, long l2, int i3) {
        super(object, -1, -1, l2, obj5, obj11);
    }

    public com.google.android.exoplayer2.source.x a(Object object) {
        Object xVar;
        com.google.android.exoplayer2.source.x xVar2;
        Object obj;
        int i3;
        int i2;
        long l;
        int i;
        if (this.a.equals(object)) {
            xVar = this;
        } else {
            super(object, this.b, this.c, this.d, obj6, this.e);
        }
        return xVar;
    }

    public boolean b() {
        int i;
        i = this.b != -1 ? 1 : 0;
        return i;
    }

    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj;
        long l;
        Object obj8;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof x) {
            return i2;
        }
        if (this.a.equals(object.a) && this.b == object.b && this.c == object.c && Long.compare(obj, l) == 0 && this.e == object.e) {
            if (this.b == object.b) {
                if (this.c == object.c) {
                    if (Long.compare(obj, l) == 0) {
                        if (this.e == object.e) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public int hashCode() {
        return i14 += i5;
    }
}

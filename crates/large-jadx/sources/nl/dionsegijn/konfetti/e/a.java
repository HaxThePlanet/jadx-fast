package nl.dionsegijn.konfetti.e;

import kotlin.d0.d.g;

/* loaded from: classes3.dex */
public final class a {

    private boolean a;
    private long b;
    private boolean c;
    private boolean d;
    private long e;
    public a() {
        super(0, 0, obj3, 0, 0, 0, obj7, 31, 0);
    }

    public a(boolean z, long l2, boolean z3, boolean z4, long l5) {
        super();
        this.a = z;
        this.b = l2;
        this.c = z4;
        this.d = l5;
        this.e = obj6;
    }

    public a(boolean z, long l2, boolean z3, boolean z4, long l5, int i6, g g7) {
        int i;
        int obj6;
        int obj7;
        int obj11;
        int obj14;
        obj6 = obj13 & 1 != 0 ? 0 : obj6;
        obj7 = obj13 & 2 != 0 ? 2000 : obj7;
        int obj8 = 1;
        obj14 = obj13 & 4 != 0 ? obj8 : z4;
        i = obj13 & 8 != 0 ? obj8 : l5;
        obj11 = obj13 & 16 != 0 ? 0 : obj11;
        super(obj6, obj7, l5, obj14, i, obj11, obj14);
    }

    public final boolean a() {
        return this.d;
    }

    public final long b() {
        return this.e;
    }

    public final boolean c() {
        return this.a;
    }

    public final boolean d() {
        return this.c;
    }

    public final long e() {
        return this.b;
    }

    public boolean equals(Object object) {
        long cmp;
        boolean z;
        long l;
        Object obj5;
        if (this != (a)object && object instanceof a && this.a == object.a && Long.compare(l2, l) == 0 && this.c == object.c && this.d == object.d && Long.compare(cmp, l) == 0) {
            if (object instanceof a) {
                if (this.a == object.a) {
                    if (Long.compare(l2, l) == 0) {
                        if (this.c == object.c) {
                            if (this.d == object.d) {
                                if (Long.compare(cmp, l) == 0) {
                                }
                            }
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final void f(boolean z) {
        this.a = z;
    }

    public final void g(long l) {
        this.b = l;
    }

    public int hashCode() {
        boolean z2;
        boolean i;
        boolean z;
        i = 1;
        if (this.a) {
            z2 = i;
        }
        long l2 = this.b;
        final int i15 = 32;
        if (this.c) {
            z = i;
        }
        boolean z3 = this.d;
        if (z3) {
        } else {
            i = z3;
        }
        long l = this.e;
        return i8 += i11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConfettiConfig(fadeOut=");
        stringBuilder.append(this.a);
        stringBuilder.append(", timeToLive=");
        stringBuilder.append(this.b);
        stringBuilder.append(", rotate=");
        stringBuilder.append(this.c);
        stringBuilder.append(", accelerate=");
        stringBuilder.append(this.d);
        stringBuilder.append(", delay=");
        stringBuilder.append(this.e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.time4j.engine.j0;
import net.time4j.engine.j0.a;
import net.time4j.f1.c;
import net.time4j.i1.f;

/* loaded from: classes3.dex */
public final class z<U>  implements j0<U>, Comparable<net.time4j.z<U>>, Serializable {

    private static final long serialVersionUID = -4150291820807606229L;
    private static final net.time4j.z<TimeUnit> v;
    private static final net.time4j.z<net.time4j.n0> w;
    private final transient long a;
    private final transient int b;
    private final transient f c;
    static {
        final int i = 0;
        final int i2 = 0;
        z zVar = new z(i, obj3, i2, f.POSIX);
        z.v = zVar;
        z zVar2 = new z(i, obj3, i2, f.UTC);
        z.w = zVar2;
    }

    private z(long l, int i2, f f3) {
        int i;
        int i3;
        long obj6;
        int obj8;
        super();
        i = 1;
        i3 = 1000000000;
        while (obj8 < 0) {
            obj8 += i3;
            obj6 = c.m(obj6, i2);
            i = 1;
            i3 = 1000000000;
        }
        while (obj8 >= i3) {
            obj8 -= i3;
            obj6 = c.f(obj6, i2);
        }
        if (Long.compare(obj6, i4) < 0 && obj8 > 0) {
            if (obj8 > 0) {
                obj6 += i;
                obj8 -= i3;
            }
        }
        this.a = obj6;
        this.b = obj8;
        this.c = obj9;
    }

    private static <T> T e(Object object) {
        return object;
    }

    private void i(StringBuilder stringBuilder) {
        long l;
        int valueOf;
        long l2;
        int i;
        if (a()) {
            stringBuilder.append('-');
            stringBuilder.append(Math.abs(this.a));
        } else {
            stringBuilder.append(this.a);
        }
        if (this.b != 0) {
            stringBuilder.append('.');
            valueOf = String.valueOf(Math.abs(this.b));
            l2 = length - 9;
            while (l2 > 0) {
                stringBuilder.append('0');
                l2--;
            }
            stringBuilder.append(valueOf);
        }
    }

    public static net.time4j.z<TimeUnit> n(long l, int i2) {
        if (Long.compare(l, i) == 0 && obj4 == null) {
            if (obj4 == null) {
                return z.v;
            }
        }
        z zVar = new z(l, i2, obj4, f.POSIX);
        return zVar;
    }

    public static net.time4j.z<net.time4j.n0> o(long l, int i2) {
        if (Long.compare(l, i) == 0 && obj4 == null) {
            if (obj4 == null) {
                return z.w;
            }
        }
        z zVar = new z(l, i2, obj4, f.UTC);
        return zVar;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 5);
        return spx;
    }

    @Override // net.time4j.engine.j0
    public boolean a() {
        int i;
        int cmp;
        if (Long.compare(l, i2) >= 0) {
            if (this.b < 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public List<j0.a<U>> c() {
        int cmp;
        int i;
        Object nANOSECONDS;
        Object sECONDS;
        long l;
        ArrayList arrayList = new ArrayList(2);
        final int i5 = 0;
        if (Long.compare(l2, i5) != 0) {
            sECONDS = this.c == f.UTC ? n0.SECONDS : TimeUnit.SECONDS;
            z.e(sECONDS);
            arrayList.add(j0.a.c(Math.abs(this.a), i5));
        }
        if (this.b != 0) {
            nANOSECONDS = this.c == f.UTC ? n0.NANOSECONDS : TimeUnit.NANOSECONDS;
            z.e(nANOSECONDS);
            arrayList.add(j0.a.c((long)i4, i5));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // net.time4j.engine.j0
    public int compareTo(Object object) {
        return f((z)object);
    }

    @Override // net.time4j.engine.j0
    public boolean equals(Object object) {
        int i;
        int cmp;
        long l;
        Object obj8;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof z) {
            if (Long.compare(l, l2) == 0 && this.b == object.b && this.c == object.c) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public int f(net.time4j.z<U> z) {
        if (this.c != z.c) {
        } else {
            long l = this.a;
            final long l2 = z.a;
            if (Long.compare(l, l2) < 0) {
                return -1;
            }
            if (Long.compare(l, l2) > 0) {
                return 1;
            }
            return i -= obj6;
        }
        ClassCastException obj6 = new ClassCastException("Different time scales.");
        throw obj6;
    }

    @Override // net.time4j.engine.j0
    public int hashCode() {
        long l = this.a;
        return i9 += i4;
    }

    @Override // net.time4j.engine.j0
    public boolean isEmpty() {
        int cmp;
        int i;
        if (Long.compare(l, i2) == 0 && this.b == 0) {
            i = this.b == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // net.time4j.engine.j0
    public int j() {
        int i2;
        int i;
        i2 = this.b;
        if (i2 < 0) {
            i2 += i;
        }
        return i2;
    }

    @Override // net.time4j.engine.j0
    public f k() {
        return this.c;
    }

    @Override // net.time4j.engine.j0
    public long m() {
        long l;
        int i;
        if (this.b < 0) {
            l -= i;
        }
        return l;
    }

    @Override // net.time4j.engine.j0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        i(stringBuilder);
        stringBuilder.append("s [");
        stringBuilder.append(this.c.name());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

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

/* compiled from: MachineTime.java */
/* loaded from: classes3.dex */
public final class z<U> implements j0<U>, Comparable<z<U>>, Serializable {

    private static final long serialVersionUID = -4150291820807606229L;
    private static final z<TimeUnit> v = new z<>();
    private static final z<n0> w = new z<>();
    private final transient long a;
    private final transient int b;
    private final transient f c;
    static {
    }

    private z(long j, int i, f fVar) {
        long l2;
        int i3;
        super();
        long l = 1L;
        i = 1000000000;
        while (i3 < 0) {
            i3 = i3 + i;
            l2 = c.m(l2, l);
            l = 1L;
            i = 1000000000;
        }
        while (i3 >= i) {
            i3 = i3 - i;
            l2 = c.f(l2, l);
        }
        if (l2 < 0 && i3 > 0) {
            l2 = l2 + 1L;
            i3 = i3 - i;
        }
        this.a = l2;
        this.b = i3;
        this.c = fVar;
    }

    private void i(StringBuilder sb) {
        int i2;
        char c = 48;
        if (a()) {
            sb.append('-');
            sb.append(Math.abs(this.a));
        } else {
            sb.append(this.a);
        }
        if (this.b != 0) {
            sb.append('.');
            String str = String.valueOf(Math.abs(this.b));
            i2 = str.length() - 9;
            while (i2 > 0) {
                c = '0';
                sb.append(c);
                i2 = i2 - 1;
            }
            sb.append(str);
        }
    }

    public static z<TimeUnit> n(long j, int i) {
        if (j == 0 && i == null) {
            return z.v;
        }
        return new z(j, r3, i, f.POSIX);
    }

    public static z<n0> o(long j, int i) {
        if (j == 0 && i == null) {
            return z.w;
        }
        return new z(j, r3, i, f.UTC);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private Object writeReplace() {
        return new SPX(this, 5);
    }

    public boolean a() {
        boolean z = false;
        if (this.a < 0 || this.b < 0) {
            int i2 = 1;
        }
        return z;
    }

    public List<j0.a<U>> c() {
        net.time4j.n0 nANOSECONDS2;
        TimeUnit sECONDS2;
        long abs;
        ArrayList arrayList = new ArrayList(2);
        final long l3 = 0L;
        if (this.a != l3) {
            net.time4j.n0 r1 = this.c == f.UTC ? n0.SECONDS : TimeUnit.SECONDS;
            z.e(r1);
            arrayList.add((this.c == f.UTC ? n0.SECONDS : TimeUnit.SECONDS));
        }
        if (this.b != 0) {
            r1 = this.c == f.UTC ? n0.NANOSECONDS : TimeUnit.NANOSECONDS;
            z.e(r1);
            abs = (long)Math.abs(this.b);
            arrayList.add((this.c == f.UTC ? n0.NANOSECONDS : TimeUnit.NANOSECONDS));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        int cmp;
        long l;
        f fVar;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof z) {
            if (this.a == object.a) {
                if (this.b == object.b) {
                    if (this.c != object.c) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int f(z<U> zVar) {
        if (this.c != zVar.c) {
            throw new ClassCastException("Different time scales.");
        } else {
            if (this.a < zVar.a) {
                return -1;
            }
            if (this.a > zVar.a) {
                return 1;
            }
            return this.b - zVar.b;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (161 + (int)(l ^ (l >>> 32L))) * 23 + this.b * 23 + this.c.hashCode();
    }

    public boolean isEmpty() {
        boolean z = false;
        int r0 = this.a == 0 && this.b == 0 ? 1 : 0;
        return (this.a == 0 && this.b == 0 ? 1 : 0);
    }

    public int j() {
        int i;
        if (this.b < 0) {
            int i2 = 1000000000;
            i = i + i2;
        }
        return i;
    }

    public f k() {
        return this.c;
    }

    public long m() {
        long l;
        if (this.b < 0) {
            l = this.a - 1L;
        }
        return l;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        i(stringBuilder);
        String str2 = "s [";
        String name = this.c.name();
        str = str2 + name + 93;
        return str;
    }

    private static <T> T e(Object object) {
        return object;
    }
}

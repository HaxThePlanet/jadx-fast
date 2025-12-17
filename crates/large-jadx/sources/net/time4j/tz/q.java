package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class q implements Comparable<net.time4j.tz.q>, Serializable {

    private static final long serialVersionUID = 4594838367057225304L;
    private final int dst;
    private final long posix;
    private final int previous;
    private final int total;
    public q(long l, int i2, int i3, int i4) {
        super();
        this.posix = l;
        this.previous = i3;
        this.total = i4;
        this.dst = obj5;
        q.c(i3);
        q.c(i4);
        q.a(obj5);
    }

    private static void a(int i) {
        if (i != Integer.MAX_VALUE) {
            q.c(i);
        }
    }

    private static void c(int i) {
        int i2;
        if (i < -64800) {
        } else {
            if (i > 64800) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offset out of range: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        q.c(this.previous);
        q.c(this.total);
        q.a(this.dst);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return e((q)object);
    }

    @Override // java.lang.Comparable
    public int e(net.time4j.tz.q q) {
        int i;
        int previous;
        int cmp;
        Object obj6;
        int i6 = 0;
        if (Long.compare(i, i6) == 0 && Long.compare(i, i6) == 0 && Long.compare(i, i6) == 0 && Long.compare(i, i6) == 0) {
            if (Long.compare(i, i6) == 0) {
                if (Long.compare(i, i6) == 0) {
                    if (Long.compare(i, i6) == 0) {
                        return 0;
                    }
                }
            }
        }
        obj6 = Long.compare(i, i6) < 0 ? -1 : 1;
        return obj6;
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        int previous;
        long previous2;
        Object obj8;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof q) {
            if (Long.compare(previous2, posix) == 0 && this.previous == object.previous && this.total == object.total && f() == (q)object.f()) {
                if (this.previous == object.previous) {
                    if (this.total == object.total) {
                        if (f() == object.f()) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // java.lang.Comparable
    public int f() {
        int dst;
        if (this.dst == Integer.MAX_VALUE) {
            dst = 0;
        }
        return dst;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        long posix = this.posix;
        return (int)i;
    }

    @Override // java.lang.Comparable
    public long i() {
        return this.posix;
    }

    @Override // java.lang.Comparable
    public int j() {
        return this.previous;
    }

    @Override // java.lang.Comparable
    public int k() {
        return total -= previous;
    }

    @Override // java.lang.Comparable
    public int m() {
        return total -= i2;
    }

    @Override // java.lang.Comparable
    public int n() {
        return this.total;
    }

    @Override // java.lang.Comparable
    public boolean o() {
        int i;
        i = this.total > this.previous ? 1 : 0;
        return i;
    }

    @Override // java.lang.Comparable
    public boolean p() {
        int i;
        i = this.total < this.previous ? 1 : 0;
        return i;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("[POSIX=");
        stringBuilder.append(this.posix);
        stringBuilder.append(", previous-offset=");
        stringBuilder.append(this.previous);
        stringBuilder.append(", total-offset=");
        stringBuilder.append(this.total);
        stringBuilder.append(", dst-offset=");
        stringBuilder.append(f());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

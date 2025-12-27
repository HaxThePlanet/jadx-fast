package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* compiled from: ZonalTransition.java */
/* loaded from: classes3.dex */
public final class q implements Comparable<q>, Serializable {

    private static final long serialVersionUID = 4594838367057225304L;
    private final int dst;
    private final long posix;
    private final int previous;
    private final int total;
    public q(long j, int i, int i2, int i3) {
        super();
        this.posix = j;
        this.previous = i;
        this.total = i2;
        this.dst = i3;
        q.c(i);
        q.c(i2);
        q.a(i3);
    }

    private static void a(int i) {
        if (i != 0x7fffffff /* Unknown resource */) {
            q.c(i);
        }
    }

    private static void c(int i) {
        int i2 = -64800;
        if (i < -64800) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Offset out of range: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            i2 = 64800;
            if (i <= 64800) {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws java.lang.ClassNotFoundException, java.io.IOException, InvalidObjectException {
        objectInputStream.defaultReadObject();
        try {
            q.c(this.previous);
            q.c(this.total);
            q.a(this.dst);
        } catch (java.lang.IllegalArgumentException iae) {
            iae = iae.getMessage();
            throw new InvalidObjectException(iae);
        }
    }

    public int e(q qVar) {
        long l;
        int i = 1;
        l = this.posix - qVar.posix;
        long l2 = 0L;
        if (this.total == l2 && this.total == l2 && this.total == l2 && this.total == l2) {
            return 0;
        }
        qVar = this.total < l2 ? -1 : 1;
        return (this.total < l2 ? -1 : 1);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        int cmp;
        long posix2;
        int i2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof q) {
            if (this.posix == object.posix) {
                if (this.previous == object.previous) {
                    if (this.total == object.total) {
                        if (f() != object.f()) {
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int f() {
        int dst2 = 0;
        if (this.dst == 0x7fffffff /* Unknown resource */) {
            dst2 = 0;
        }
        return dst2;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (int)(posix2 ^ (posix2 >>> 32L));
    }

    public long i() {
        return this.posix;
    }

    public int j() {
        return this.previous;
    }

    public int k() {
        return this.total - this.previous;
    }

    public int m() {
        return this.total - f();
    }

    public int n() {
        return this.total;
    }

    public boolean o() {
        boolean z = true;
        int r0 = this.total > this.previous ? 1 : 0;
        return (this.total > this.previous ? 1 : 0);
    }

    public boolean p() {
        boolean z = true;
        int r0 = this.total < this.previous ? 1 : 0;
        return (this.total < this.previous ? 1 : 0);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        String str2 = "[POSIX=";
        String str3 = ", previous-offset=";
        String str4 = ", total-offset=";
        String str5 = ", dst-offset=";
        int i2 = f();
        str = 128 + str2 + this.posix + str3 + this.previous + str4 + this.total + str5 + i2 + 93;
        return str;
    }
}

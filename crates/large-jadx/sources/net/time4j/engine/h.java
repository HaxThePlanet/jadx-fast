package net.time4j.engine;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final class h implements Comparable<net.time4j.engine.h>, Serializable {

    public static final net.time4j.engine.h a;
    public static final net.time4j.engine.h b;
    private final long days;
    static {
        h hVar = new h(0, obj2);
        h.a = hVar;
        h hVar2 = new h(1, obj2);
        h.b = hVar2;
    }

    private h(long l) {
        super();
        this.days = l;
    }

    public static net.time4j.engine.h e(long l) {
        int hVar;
        net.time4j.engine.h obj2;
        if (Long.compare(l, i) == 0) {
            obj2 = h.a;
        } else {
            if (Long.compare(l, i2) == 0) {
                obj2 = h.b;
            } else {
                hVar = new h(l, obj3);
                obj2 = hVar;
            }
        }
        return obj2;
    }

    @Override // java.lang.Comparable
    public int a(net.time4j.engine.h h) {
        int obj5;
        final long days = this.days;
        final long days2 = h.days;
        obj5 = Long.compare(days, days2) < 0 ? -1 : obj5 > 0 ? 1 : 0;
        return obj5;
    }

    @Override // java.lang.Comparable
    public long c() {
        return this.days;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return a((h)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof h) {
            if (Long.compare(days, days2) == 0) {
            } else {
                i = i2;
            }
            return i;
        }
        return i2;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        long days = this.days;
        return (int)i;
    }

    @Override // java.lang.Comparable
    public String toString() {
        int cmp;
        StringBuilder stringBuilder = new StringBuilder();
        if (Long.compare(days, i3) < 0) {
            stringBuilder.append('-');
        }
        stringBuilder.append('P');
        stringBuilder.append(Math.abs(this.days));
        stringBuilder.append('D');
        return stringBuilder.toString();
    }
}

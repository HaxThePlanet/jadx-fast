package net.time4j.engine;

import java.io.Serializable;

/* compiled from: CalendarDays.java */
/* loaded from: classes3.dex */
public final class h implements Comparable<h>, Serializable {

    public static final h a = new h();
    public static final h b = new h();
    private final long days;

    private h(long j) {
        super();
        this.days = j;
    }

    public static h e(long j) {
        net.time4j.engine.h hVar;
        if (j == 0) {
            hVar = h.a;
        } else {
            j = j == 1 ? h.b : new h(j, r3);
        }
        return (j == 1 ? h.b : new h(j, r3));
    }

    public int a(h hVar) {
        int i = -1;
        if (this.days < hVar.days) {
            i = -1;
        } else {
            hVar = this.days > hVar.days ? 1 : 0;
        }
        return (this.days > hVar.days ? 1 : 0);
    }

    public long c() {
        return this.days;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof h) {
            if (this.days != object.days) {
            }
            return z;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (int)(days2 ^ (days2 >>> 32L));
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.days < 0) {
            stringBuilder.append('-');
        }
        stringBuilder.append('P');
        stringBuilder.append(Math.abs(this.days));
        stringBuilder.append('D');
        return stringBuilder.toString();
    }
}

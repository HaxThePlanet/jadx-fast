package net.time4j.tz.model;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import net.time4j.c0;
import net.time4j.f1.b;
import net.time4j.g0;
import net.time4j.x0;

/* loaded from: classes3.dex */
final class h extends net.time4j.tz.model.g {

    private static final long serialVersionUID = -946839310332554772L;
    private final transient byte x;
    h(c0 c0, x0 x02, int i3, net.time4j.tz.model.i i4, int i5) {
        super(c0, i3, i4, i5);
        this.x = (byte)obj1;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, g());
        return spx;
    }

    @Override // net.time4j.tz.model.g
    public boolean equals(Object object) {
        int i;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof h) {
            if (this.x == object.x && super.l((h)object)) {
                if (super.l(object)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.tz.model.g
    int g() {
        return 122;
    }

    @Override // net.time4j.tz.model.g
    public int hashCode() {
        return i += i3;
    }

    @Override // net.time4j.tz.model.g
    protected g0 j(int i) {
        int i2;
        final byte b = k();
        int i3 = b.d(i, b);
        i5 -= b2;
        if (i2 < 0) {
            i2 += 7;
        }
        return g0.K0(i, b, i3 -= i2);
    }

    @Override // net.time4j.tz.model.g
    byte m() {
        return this.x;
    }

    @Override // net.time4j.tz.model.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LastDayOfWeekPattern:[month=");
        stringBuilder.append(k());
        stringBuilder.append(",day-of-week=");
        stringBuilder.append(x0.valueOf(this.x));
        stringBuilder.append(",day-overflow=");
        stringBuilder.append(c());
        stringBuilder.append(",time-of-day=");
        stringBuilder.append(f());
        stringBuilder.append(",offset-indicator=");
        stringBuilder.append(d());
        stringBuilder.append(",dst-offset=");
        stringBuilder.append(e());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

package net.time4j.tz.model;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import net.time4j.c0;
import net.time4j.f1.b;
import net.time4j.g0;

/* loaded from: classes3.dex */
final class f extends net.time4j.tz.model.g {

    private static final long serialVersionUID = 3957240859230862745L;
    private final transient byte x;
    f(c0 c0, int i2, int i3, net.time4j.tz.model.i i4, int i5) {
        super(c0, i3, i4, i5);
        b.a(2000, c0.getValue(), i2);
        this.x = (byte)i2;
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
        if (object instanceof f) {
            if (this.x == object.x && super.l((f)object)) {
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
        return 120;
    }

    @Override // net.time4j.tz.model.g
    public int hashCode() {
        return b += i2;
    }

    @Override // net.time4j.tz.model.g
    protected g0 j(int i) {
        return g0.K0(i, k(), this.x);
    }

    @Override // net.time4j.tz.model.g
    int m() {
        return this.x;
    }

    @Override // net.time4j.tz.model.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("FixedDayPattern:[month=");
        stringBuilder.append(k());
        stringBuilder.append(",day-of-month=");
        stringBuilder.append(this.x);
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

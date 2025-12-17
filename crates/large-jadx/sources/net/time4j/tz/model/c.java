package net.time4j.tz.model;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import net.time4j.c0;
import net.time4j.engine.i0;
import net.time4j.f;
import net.time4j.f1.b;
import net.time4j.g0;
import net.time4j.x0;

/* loaded from: classes3.dex */
final class c extends net.time4j.tz.model.g {

    private static final long serialVersionUID = -7354650946442523175L;
    private final transient byte x;
    private final transient byte y;
    private final transient boolean z;
    c(c0 c0, int i2, x0 x03, int i4, net.time4j.tz.model.i i5, int i6, boolean z7) {
        super(c0, i4, i5, i6);
        b.a(2000, c0.getValue(), i2);
        this.x = (byte)i2;
        this.y = (byte)obj1;
        this.z = z7;
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
        byte b;
        byte b2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof c) {
            if (this.x == object.x && this.y == object.y && this.z == object.z && super.l((c)object)) {
                if (this.y == object.y) {
                    if (this.z == object.z) {
                        if (super.l(object)) {
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

    @Override // net.time4j.tz.model.g
    int g() {
        return 121;
    }

    @Override // net.time4j.tz.model.g
    public int hashCode() {
        return i += z;
    }

    @Override // net.time4j.tz.model.g
    protected g0 j(int i) {
        int i3;
        int i2;
        byte b = k();
        int i4 = b.c(i, b, this.x);
        g0 obj4 = g0.K0(i, b, this.x);
        byte b2 = this.y;
        if (i4 == b2) {
            return obj4;
        }
        i3 = -1;
        if (this.z) {
            i2 = -i2;
            i3 = 1;
        }
        if (i2 < 0) {
            i2 += 7;
        }
        i2 *= i3;
        return (g0)obj4.M((long)i5, i5);
    }

    @Override // net.time4j.tz.model.g
    int m() {
        return this.x;
    }

    @Override // net.time4j.tz.model.g
    byte n() {
        return this.y;
    }

    @Override // net.time4j.tz.model.g
    boolean o() {
        return this.z;
    }

    @Override // net.time4j.tz.model.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("DayOfWeekInMonthPattern:[month=");
        stringBuilder.append(k());
        stringBuilder.append(",dayOfMonth=");
        stringBuilder.append(this.x);
        stringBuilder.append(",dayOfWeek=");
        stringBuilder.append(x0.valueOf(this.y));
        stringBuilder.append(",day-overflow=");
        stringBuilder.append(c());
        stringBuilder.append(",time-of-day=");
        stringBuilder.append(f());
        stringBuilder.append(",offset-indicator=");
        stringBuilder.append(d());
        stringBuilder.append(",dst-offset=");
        stringBuilder.append(e());
        stringBuilder.append(",after=");
        stringBuilder.append(this.z);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

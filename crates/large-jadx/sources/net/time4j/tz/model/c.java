package net.time4j.tz.model;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import net.time4j.c0;
import net.time4j.engine.i0;
import net.time4j.f;
import net.time4j.f1.b;
import net.time4j.g0;
import net.time4j.x0;

/* compiled from: DayOfWeekInMonthPattern.java */
/* loaded from: classes3.dex */
final class c extends g {

    private static final long serialVersionUID = -7354650946442523175L;
    private final transient byte x;
    private final transient byte y;
    private final transient boolean z;
    c(c0 c0Var, int i, x0 x0Var, int i2, i iVar, int i3, boolean z) {
        super(c0Var, i2, iVar, i3);
        b.a(2000, c0Var.getValue(), i);
        this.x = (byte)i;
        this.y = (byte)x0Var.getValue();
        this.z = z;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private Object writeReplace() {
        return new SPX(this, g());
    }

    @Override // net.time4j.tz.model.g
    public boolean equals(Object object) {
        boolean z = true;
        byte b;
        byte b2;
        boolean z2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof c) {
            if (this.x == object.x) {
                if (this.y == object.y) {
                    if (this.z != object.z || !l(object)) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.tz.model.g
    public int hashCode() {
        return (this.x + (this.y + (k() * 37)) * 17) + this.z;
    }

    @Override // net.time4j.tz.model.g
    protected g0 j(int i) {
        int i2 = -1;
        int i3;
        byte b = k();
        int i4 = b.c(i, b, this.x);
        g0 g0Var = g0.K0(i, b, this.x);
        if (i4 == this.y) {
            return g0Var;
        }
        i3 = i4 - b2;
        i2 = -1;
        if (this.z) {
            i3 = -(i4 - b2);
            i2 = 1;
        }
        if (this.x < 0) {
            i3 = i3 + 7;
        }
        i3 *= i2;
        return (g0)g0Var.M((long)i5, f.DAYS);
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
        String str2 = "DayOfWeekInMonthPattern:[month=";
        byte b = k();
        String str3 = ",dayOfMonth=";
        String str4 = ",dayOfWeek=";
        x0 str5 = x0.valueOf(this.y);
        String str6 = ",day-overflow=";
        long l = c();
        String str7 = ",time-of-day=";
        net.time4j.h0 h0Var = f();
        String str8 = ",offset-indicator=";
        net.time4j.tz.model.i iVar = d();
        String str9 = ",dst-offset=";
        int i2 = e();
        String str10 = ",after=";
        str = 64 + str2 + b + str3 + this.x + str4 + str5 + str6 + l + str7 + h0Var + str8 + iVar + str9 + i2 + str10 + this.z + 93;
        return str;
    }

    @Override // net.time4j.tz.model.g
    int g() {
        return 121;
    }
}

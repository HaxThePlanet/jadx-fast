package net.time4j.tz.model;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import net.time4j.c0;
import net.time4j.f1.b;
import net.time4j.g0;
import net.time4j.x0;

/* compiled from: LastWeekdayPattern.java */
/* loaded from: classes3.dex */
final class h extends g {

    private static final long serialVersionUID = -946839310332554772L;
    private final transient byte x;
    h(c0 c0Var, x0 x0Var, int i, i iVar, int i2) {
        super(c0Var, i, iVar, i2);
        this.x = (byte)x0Var.getValue();
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
        boolean z2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof h) {
            if (this.x != object.x || !l(object)) {
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.tz.model.g
    public int hashCode() {
        return (this.x * 17) + (k() * 37);
    }

    @Override // net.time4j.tz.model.g
    protected g0 j(int i) {
        int i2;
        final byte b = k();
        int i3 = b.d(i, b);
        i2 = (b.c(i, b, i3)) - this.x;
        if (i2 < 0) {
            i2 = i2 + 7;
        }
        return g0.K0(i, b, i3 - i2);
    }

    @Override // net.time4j.tz.model.g
    byte m() {
        return this.x;
    }

    @Override // net.time4j.tz.model.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String str2 = "LastDayOfWeekPattern:[month=";
        byte b = k();
        String str3 = ",day-of-week=";
        x0 str4 = x0.valueOf(this.x);
        String str5 = ",day-overflow=";
        long l = c();
        String str6 = ",time-of-day=";
        net.time4j.h0 h0Var = f();
        String str7 = ",offset-indicator=";
        net.time4j.tz.model.i iVar = d();
        String str8 = ",dst-offset=";
        int i2 = e();
        str = 64 + str2 + b + str3 + str4 + str5 + l + str6 + h0Var + str7 + iVar + str8 + i2 + 93;
        return str;
    }

    @Override // net.time4j.tz.model.g
    int g() {
        return 122;
    }
}

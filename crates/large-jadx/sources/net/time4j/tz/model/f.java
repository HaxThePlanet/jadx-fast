package net.time4j.tz.model;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import net.time4j.c0;
import net.time4j.f1.b;
import net.time4j.g0;

/* compiled from: FixedDayPattern.java */
/* loaded from: classes3.dex */
final class f extends g {

    private static final long serialVersionUID = 3957240859230862745L;
    private final transient byte x;
    f(c0 c0Var, int i, int i2, i iVar, int i3) {
        super(c0Var, i2, iVar, i3);
        b.a(2000, c0Var.getValue(), i);
        this.x = (byte)i;
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
        if (object instanceof f) {
            if (this.x != object.x || !l(object)) {
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.tz.model.g
    public int hashCode() {
        return this.x + (k() * 37);
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
        String str2 = "FixedDayPattern:[month=";
        byte b = k();
        String str3 = ",day-of-month=";
        String str4 = ",day-overflow=";
        long l = c();
        String str5 = ",time-of-day=";
        net.time4j.h0 h0Var = f();
        String str6 = ",offset-indicator=";
        net.time4j.tz.model.i iVar = d();
        String str7 = ",dst-offset=";
        int i2 = e();
        str = 64 + str2 + b + str3 + this.x + str4 + l + str5 + h0Var + str6 + iVar + str7 + i2 + 93;
        return str;
    }

    @Override // net.time4j.tz.model.g
    int g() {
        return 120;
    }
}

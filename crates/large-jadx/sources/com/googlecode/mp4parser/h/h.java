package com.googlecode.mp4parser.h;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* compiled from: Matrix.java */
/* loaded from: classes2.dex */
public class h {

    public static final h j;
    public static final h k;
    public static final h l;
    public static final h m;
    double a;
    double b;
    double c;
    double d;
    double e;
    double f;
    double g;
    double h;
    double i;
    static {
        final double d2 = 0.0d;
        final double d4 = 0.0d;
        final double d6 = 1d;
        final double d8 = 0.0d;
        final int i4 = 0;
        final long l4 = 4607182418800017408L;
        final int i6 = 0;
        final int i8 = 0;
        h hVar = new h(1d, d, d2, d3, d4, d5, d6, d7, d8, obj, i4, obj2, l4, obj3, i6, obj4, i8, obj5);
        h.j = hVar;
        final double d9 = 0.0d;
        final double d13 = 0.0d;
        final double d15 = 0.0d;
        final int i10 = 0;
        final long l10 = 4607182418800017408L;
        final int i11 = 0;
        final int i12 = 0;
        h hVar2 = new h(d9, d10, 1d, d11, -1d, d12, d13, d14, d15, obj6, i10, obj7, l10, obj8, i11, obj9, i12, obj10);
        h.k = hVar2;
        h hVar3 = new h(-1d, d2, 0.0d, d4, 0.0d, d6, -1d, d8, 0.0d, i4, 0, l4, 4607182418800017408L, i6, 0, i8, 0, hVar);
        h.l = hVar3;
        h hVar4 = new h(d9, d10, -1d, d11, 1d, d12, d13, d14, d15, obj6, i10, obj7, l10, obj8, i11, obj9, i12, obj10);
        h.m = hVar4;
    }

    public h(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        final Object d15 = this;
        super();
        d15.a = d5;
        d15.b = d6;
        d15.c = d7;
        d15.d = d;
        d15.e = d2;
        d15.f = d3;
        d15.g = d4;
        d15.h = d8;
        d15.i = d9;
    }

    public static h a(ByteBuffer byteBuffer) {
        return h.b(e.d(byteBuffer), e.d(byteBuffer), e.c(byteBuffer), e.d(byteBuffer), e.d(byteBuffer), e.c(byteBuffer), e.d(byteBuffer), e.d(byteBuffer), e.c(byteBuffer));
    }

    public static h b(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        h hVar = new h(d, d11, d2, d12, d4, d13, d5, d14, d3, obj, d6, obj3, d9, obj5, d7, obj7, d8, obj9);
        return hVar;
    }

    public void c(ByteBuffer byteBuffer) {
        g.b(byteBuffer, this.d);
        g.b(byteBuffer, this.e);
        g.a(byteBuffer, this.a);
        g.b(byteBuffer, this.f);
        g.b(byteBuffer, this.g);
        g.a(byteBuffer, this.b);
        g.b(byteBuffer, this.h);
        g.b(byteBuffer, this.i);
        g.a(byteBuffer, this.c);
    }

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = h.class;
            Class cls = object.getClass();
            if (obj == cls) {
                if (Double.compare(object.d, this.d) != 0) {
                    return false;
                }
                if (Double.compare(object.e, this.e) != 0) {
                    return false;
                }
                if (Double.compare(object.f, this.f) != 0) {
                    return false;
                }
                if (Double.compare(object.g, this.g) != 0) {
                    return false;
                }
                if (Double.compare(object.h, this.h) != 0) {
                    return false;
                }
                if (Double.compare(object.i, this.i) != 0) {
                    return false;
                }
                if (Double.compare(object.a, this.a) != 0) {
                    return false;
                }
                if (Double.compare(object.b, this.b) != 0) {
                    return false;
                }
                return Double.compare(object.c, this.c) != 0 ? z2 : z;
            }
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        final int i26 = 32;
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        long doubleToLongBits3 = Double.doubleToLongBits(this.c);
        long doubleToLongBits4 = Double.doubleToLongBits(this.d);
        long doubleToLongBits5 = Double.doubleToLongBits(this.e);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f);
        long doubleToLongBits7 = Double.doubleToLongBits(this.g);
        long doubleToLongBits8 = Double.doubleToLongBits(this.h);
        long doubleToLongBits9 = Double.doubleToLongBits(this.i);
        return (int)(doubleToLongBits ^ (doubleToLongBits >>> i26)) * 31 + (int)(doubleToLongBits2 ^ (doubleToLongBits2 >>> i26)) * 31 + (int)(doubleToLongBits3 ^ (doubleToLongBits3 >>> i26)) * 31 + (int)(doubleToLongBits4 ^ (doubleToLongBits4 >>> i26)) * 31 + (int)(doubleToLongBits5 ^ (doubleToLongBits5 >>> i26)) * 31 + (int)(doubleToLongBits6 ^ (doubleToLongBits6 >>> i26)) * 31 + (int)(doubleToLongBits7 ^ (doubleToLongBits7 >>> i26)) * 31 + (int)(doubleToLongBits8 ^ (doubleToLongBits8 >>> i26)) * 31 + (int)(doubleToLongBits9 >>> i26) ^ doubleToLongBits9;
    }

    public String toString() {
        if (equals(h.j)) {
            return "Rotate 0°";
        }
        if (equals(h.k)) {
            return "Rotate 90°";
        }
        if (equals(h.l)) {
            return "Rotate 180°";
        }
        if (equals(h.m)) {
            return "Rotate 270°";
        }
        String str6 = "Matrix{u=";
        StringBuilder stringBuilder = new StringBuilder(str6);
        String str7 = ", v=";
        String str8 = ", w=";
        String str9 = ", a=";
        String str10 = ", b=";
        String str11 = ", c=";
        String str12 = ", d=";
        String str13 = ", tx=";
        String str14 = ", ty=";
        str3 = str6 + this.a + str7 + this.b + str8 + this.c + str9 + this.d + str10 + this.e + str11 + this.f + str12 + this.g + str13 + this.h + str14 + this.i + 125;
        return str3;
    }
}

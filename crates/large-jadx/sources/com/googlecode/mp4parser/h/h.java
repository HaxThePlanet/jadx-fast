package com.googlecode.mp4parser.h;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class h {

    public static final com.googlecode.mp4parser.h.h j;
    public static final com.googlecode.mp4parser.h.h k;
    public static final com.googlecode.mp4parser.h.h l;
    public static final com.googlecode.mp4parser.h.h m;
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
        final int i = 0;
        final int i3 = 0;
        final long l3 = 4607182418800017408L;
        final int i5 = 0;
        final int i7 = 0;
        final long l5 = 4607182418800017408L;
        final int i9 = 0;
        final int i11 = 0;
        super(4607182418800017408L, obj2, i, obj4, i3, obj6, l3, obj8, i5, obj10, i7, obj12, l5, obj14, i9, obj16, i11, obj18);
        h.j = hVar6;
        final int i13 = 0;
        final int i14 = 0;
        final int i15 = 0;
        final int i16 = 0;
        final long l11 = 4607182418800017408L;
        final int i17 = 0;
        final int i18 = 0;
        super(i13, obj22, 4607182418800017408L, obj24, -4616189618054758400L, obj26, i14, obj28, i15, obj30, i16, obj32, l11, obj34, i17, obj36, i18, obj38);
        h.k = hVar2;
        super(-4616189618054758400L, i, 0, i3, 0, l3, -4616189618054758400L, i5, 0, i7, 0, l5, 4607182418800017408L, i9, 0, i11, 0, hVar6);
        h.l = hVar3;
        super(i13, obj22, -4616189618054758400L, obj24, 4607182418800017408L, obj26, i14, obj28, i15, obj30, i16, obj32, l11, obj34, i17, obj36, i18, obj38);
        h.m = hVar4;
    }

    public h(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        final Object obj = this;
        super();
        obj.a = d9;
        obj.b = obj14;
        obj.c = obj16;
        obj.d = d;
        obj.e = d3;
        obj.f = d5;
        obj.g = d7;
        obj.h = obj18;
        obj.i = obj20;
    }

    public static com.googlecode.mp4parser.h.h a(ByteBuffer byteBuffer) {
        return h.b(e.d(byteBuffer), obj1, e.d(byteBuffer), obj3, e.c(byteBuffer), obj5, e.d(byteBuffer), obj7, e.d(byteBuffer));
    }

    public static com.googlecode.mp4parser.h.h b(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        super(d, obj2, d3, obj4, d7, obj6, d9, obj8, d5, obj10, obj30, obj12, obj36, obj14, obj32, obj16, obj34, obj18);
        return hVar2;
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
        Class<com.googlecode.mp4parser.h.h> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            class = object.getClass();
            if (h.class != class) {
            } else {
                if (Double.compare(object.d, class) != 0) {
                    return i2;
                }
                if (Double.compare(object.e, class) != 0) {
                    return i2;
                }
                if (Double.compare(object.f, class) != 0) {
                    return i2;
                }
                if (Double.compare(object.g, class) != 0) {
                    return i2;
                }
                if (Double.compare(object.h, class) != 0) {
                    return i2;
                }
                if (Double.compare(object.i, class) != 0) {
                    return i2;
                }
                if (Double.compare(object.a, class) != 0) {
                    return i2;
                }
                if (Double.compare(object.b, class) != 0) {
                    return i2;
                }
                if (Double.compare(object.c, class) != 0) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        final int i29 = 32;
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        long doubleToLongBits3 = Double.doubleToLongBits(this.c);
        long doubleToLongBits4 = Double.doubleToLongBits(this.d);
        long doubleToLongBits5 = Double.doubleToLongBits(this.e);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f);
        long doubleToLongBits7 = Double.doubleToLongBits(this.g);
        long doubleToLongBits8 = Double.doubleToLongBits(this.h);
        long doubleToLongBits9 = Double.doubleToLongBits(this.i);
        return i17 += i28;
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
        StringBuilder stringBuilder = new StringBuilder("Matrix{u=");
        stringBuilder.append(this.a);
        stringBuilder.append(", v=");
        stringBuilder.append(this.b);
        stringBuilder.append(", w=");
        stringBuilder.append(this.c);
        stringBuilder.append(", a=");
        stringBuilder.append(this.d);
        stringBuilder.append(", b=");
        stringBuilder.append(this.e);
        stringBuilder.append(", c=");
        stringBuilder.append(this.f);
        stringBuilder.append(", d=");
        stringBuilder.append(this.g);
        stringBuilder.append(", tx=");
        stringBuilder.append(this.h);
        stringBuilder.append(", ty=");
        stringBuilder.append(this.i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

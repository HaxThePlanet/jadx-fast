package com.skydoves.balloon.vectortext;

import android.graphics.drawable.Drawable;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
public final class a {

    private Integer a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private Drawable h;
    private boolean i;
    private final Integer j;
    private final Integer k;
    private final Integer l;
    private Integer m;
    private Integer n;
    private Integer o;
    private Integer p;
    private Integer q;
    public a() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 131071, 0);
    }

    public a(Integer integer, Integer integer2, Integer integer3, Integer integer4, Drawable drawable5, Drawable drawable6, Drawable drawable7, Drawable drawable8, boolean z9, Integer integer10, Integer integer11, Integer integer12, Integer integer13, Integer integer14, Integer integer15, Integer integer16, Integer integer17) {
        final Object obj = this;
        super();
        obj.a = integer;
        obj.b = integer2;
        obj.c = integer3;
        obj.d = integer4;
        obj.e = drawable5;
        obj.f = drawable6;
        obj.g = drawable7;
        obj.h = drawable8;
        obj.i = z9;
        obj.j = integer10;
        obj.k = integer11;
        obj.l = integer12;
        obj.m = integer13;
        obj.n = integer14;
        obj.o = integer15;
        obj.p = integer16;
        obj.q = integer17;
    }

    public a(Integer integer, Integer integer2, Integer integer3, Integer integer4, Drawable drawable5, Drawable drawable6, Drawable drawable7, Drawable drawable8, boolean z9, Integer integer10, Integer integer11, Integer integer12, Integer integer13, Integer integer14, Integer integer15, Integer integer16, Integer integer17, int i18, g g19) {
        int i3;
        int i13;
        int i17;
        int i15;
        int i4;
        int i8;
        int i12;
        int i14;
        int i;
        int i2;
        int i11;
        int i5;
        int i9;
        int i6;
        int i7;
        int i16;
        int i10;
        int i19 = i18;
        i13 = i19 & 1 != 0 ? 0 : integer;
        i15 = i19 & 2 != 0 ? 0 : integer2;
        i4 = i19 & 4 != 0 ? 0 : integer3;
        i8 = i19 & 8 != 0 ? 0 : integer4;
        i12 = i19 & 16 != 0 ? 0 : drawable5;
        i14 = i19 & 32 != 0 ? 0 : drawable6;
        i = i19 & 64 != 0 ? 0 : drawable7;
        i2 = i19 & 128 != 0 ? 0 : drawable8;
        i11 = i19 & 256 != 0 ? 0 : z9;
        i5 = i19 & 512 != 0 ? 0 : integer10;
        i9 = i19 & 1024 != 0 ? 0 : integer11;
        i6 = i19 & 2048 != 0 ? 0 : integer12;
        i7 = i19 & 4096 != 0 ? 0 : integer13;
        i16 = i19 & 8192 != 0 ? 0 : integer14;
        i17 = i19 & 16384 != 0 ? 0 : integer15;
        i10 = i19 & i36 != 0 ? 0 : integer16;
        i3 = i19 &= i38 != 0 ? 0 : integer17;
        super(i13, i15, i4, i8, i12, i14, i, i2, i11, i5, i9, i6, i7, i16, i17, i10, i3);
    }

    public final Integer a() {
        return this.j;
    }

    public final Integer b() {
        return this.m;
    }

    public final Drawable c() {
        return this.g;
    }

    public final Integer d() {
        return this.c;
    }

    public final Drawable e() {
        return this.f;
    }

    public boolean equals(Object object) {
        boolean z;
        Integer num;
        Object obj3;
        if (this != (a)object && object instanceof a && n.b(this.a, object.a) && n.b(this.b, object.b) && n.b(this.c, object.c) && n.b(this.d, object.d) && n.b(this.e, object.e) && n.b(this.f, object.f) && n.b(this.g, object.g) && n.b(this.h, object.h) && this.i == object.i && n.b(this.j, object.j) && n.b(this.k, object.k) && n.b(this.l, object.l) && n.b(this.m, object.m) && n.b(this.n, object.n) && n.b(this.o, object.o) && n.b(this.p, object.p) && n.b(this.q, object.q)) {
            if (object instanceof a) {
                if (n.b(this.a, object.a)) {
                    if (n.b(this.b, object.b)) {
                        if (n.b(this.c, object.c)) {
                            if (n.b(this.d, object.d)) {
                                if (n.b(this.e, object.e)) {
                                    if (n.b(this.f, object.f)) {
                                        if (n.b(this.g, object.g)) {
                                            if (n.b(this.h, object.h)) {
                                                if (this.i == object.i) {
                                                    if (n.b(this.j, object.j)) {
                                                        if (n.b(this.k, object.k)) {
                                                            if (n.b(this.l, object.l)) {
                                                                if (n.b(this.m, object.m)) {
                                                                    if (n.b(this.n, object.n)) {
                                                                        if (n.b(this.o, object.o)) {
                                                                            if (n.b(this.p, object.p)) {
                                                                                if (n.b(this.q, object.q)) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final Integer f() {
        return this.b;
    }

    public final Drawable g() {
        return this.e;
    }

    public final Integer h() {
        return this.a;
    }

    public int hashCode() {
        int i13;
        int i4;
        int i;
        int i10;
        int i14;
        int i5;
        int i9;
        int i6;
        int i16;
        boolean z;
        int i2;
        int i7;
        int i8;
        int i15;
        int i11;
        int i12;
        int i3;
        Integer num = this.a;
        i4 = 0;
        if (num != null) {
            i13 = num.hashCode();
        } else {
            i13 = i4;
        }
        Integer num2 = this.b;
        if (num2 != null) {
            i = num2.hashCode();
        } else {
            i = i4;
        }
        Integer num3 = this.c;
        if (num3 != null) {
            i10 = num3.hashCode();
        } else {
            i10 = i4;
        }
        Integer num4 = this.d;
        if (num4 != null) {
            i14 = num4.hashCode();
        } else {
            i14 = i4;
        }
        Drawable drawable = this.e;
        if (drawable != null) {
            i5 = drawable.hashCode();
        } else {
            i5 = i4;
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            i9 = drawable2.hashCode();
        } else {
            i9 = i4;
        }
        Drawable drawable3 = this.g;
        if (drawable3 != null) {
            i6 = drawable3.hashCode();
        } else {
            i6 = i4;
        }
        Drawable drawable4 = this.h;
        if (drawable4 != null) {
            i16 = drawable4.hashCode();
        } else {
            i16 = i4;
        }
        if (this.i) {
            z = 1;
        }
        Integer num5 = this.j;
        if (num5 != null) {
            i2 = num5.hashCode();
        } else {
            i2 = i4;
        }
        Integer num6 = this.k;
        if (num6 != null) {
            i7 = num6.hashCode();
        } else {
            i7 = i4;
        }
        Integer num7 = this.l;
        if (num7 != null) {
            i8 = num7.hashCode();
        } else {
            i8 = i4;
        }
        Integer num8 = this.m;
        if (num8 != null) {
            i15 = num8.hashCode();
        } else {
            i15 = i4;
        }
        Integer num9 = this.n;
        if (num9 != null) {
            i11 = num9.hashCode();
        } else {
            i11 = i4;
        }
        Integer num10 = this.o;
        if (num10 != null) {
            i12 = num10.hashCode();
        } else {
            i12 = i4;
        }
        Integer num11 = this.p;
        if (num11 != null) {
            i3 = num11.hashCode();
        } else {
            i3 = i4;
        }
        Integer num12 = this.q;
        if (num12 != null) {
            i4 = num12.hashCode();
        }
        return i47 += i4;
    }

    public final Drawable i() {
        return this.h;
    }

    public final Integer j() {
        return this.d;
    }

    public final Integer k() {
        return this.p;
    }

    public final Integer l() {
        return this.l;
    }

    public final Integer m() {
        return this.k;
    }

    public final Integer n() {
        return this.q;
    }

    public final Integer o() {
        return this.n;
    }

    public final Integer p() {
        return this.o;
    }

    public final boolean q() {
        return this.i;
    }

    public final void r(Drawable drawable) {
        this.g = drawable;
    }

    public final void s(Integer integer) {
        this.c = integer;
    }

    public final void t(Drawable drawable) {
        this.f = drawable;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VectorTextViewParams(drawableStartRes=");
        stringBuilder.append(this.a);
        stringBuilder.append(", drawableEndRes=");
        stringBuilder.append(this.b);
        stringBuilder.append(", drawableBottomRes=");
        stringBuilder.append(this.c);
        stringBuilder.append(", drawableTopRes=");
        stringBuilder.append(this.d);
        stringBuilder.append(", drawableStart=");
        stringBuilder.append(this.e);
        stringBuilder.append(", drawableEnd=");
        stringBuilder.append(this.f);
        stringBuilder.append(", drawableBottom=");
        stringBuilder.append(this.g);
        stringBuilder.append(", drawableTop=");
        stringBuilder.append(this.h);
        stringBuilder.append(", isRtlLayout=");
        stringBuilder.append(this.i);
        stringBuilder.append(", compoundDrawablePadding=");
        stringBuilder.append(this.j);
        stringBuilder.append(", iconWidth=");
        stringBuilder.append(this.k);
        stringBuilder.append(", iconHeight=");
        stringBuilder.append(this.l);
        stringBuilder.append(", compoundDrawablePaddingRes=");
        stringBuilder.append(this.m);
        stringBuilder.append(", tintColor=");
        stringBuilder.append(this.n);
        stringBuilder.append(", widthRes=");
        stringBuilder.append(this.o);
        stringBuilder.append(", heightRes=");
        stringBuilder.append(this.p);
        stringBuilder.append(", squareSizeRes=");
        stringBuilder.append(this.q);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void u(Integer integer) {
        this.b = integer;
    }

    public final void v(Drawable drawable) {
        this.e = drawable;
    }

    public final void w(Integer integer) {
        this.a = integer;
    }

    public final void x(Drawable drawable) {
        this.h = drawable;
    }

    public final void y(Integer integer) {
        this.d = integer;
    }

    public final void z(boolean z) {
        this.i = z;
    }
}

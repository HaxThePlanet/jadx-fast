package com.skydoves.balloon.vectortext;

import android.graphics.drawable.Drawable;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: VectorTextViewParams.kt */
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
    public a(Integer integer, Integer integer2, Integer integer3, Integer integer4, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, boolean z, Integer integer5, Integer integer6, Integer integer7, Integer integer8, Integer integer9, Integer integer10, Integer integer11, Integer integer12) {
        final Object integer62 = this;
        super();
        integer62.a = integer;
        integer62.b = integer2;
        integer62.c = integer3;
        integer62.d = integer4;
        integer62.e = drawable;
        integer62.f = drawable2;
        integer62.g = drawable3;
        integer62.h = drawable4;
        integer62.i = z;
        integer62.j = integer5;
        integer62.k = integer6;
        integer62.l = integer7;
        integer62.m = integer8;
        integer62.n = integer9;
        integer62.o = integer10;
        integer62.p = integer11;
        integer62.q = integer12;
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

    public final Integer f() {
        return this.b;
    }

    public final Drawable g() {
        return this.e;
    }

    public final Integer h() {
        return this.a;
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

    public /* synthetic */ a(Integer integer, Integer integer2, Integer integer3, Integer integer4, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, boolean z, Integer integer5, Integer integer6, Integer integer7, Integer integer8, Integer integer9, Integer integer10, Integer integer11, Integer integer12, int i, g gVar) {
        int integer172 = 0;
        int integer52 = 0;
        int integer152 = 0;
        int integer22 = 0;
        int integer32 = 0;
        int integer42 = 0;
        int drawable52 = 0;
        int drawable62 = 0;
        int drawable72 = 0;
        int drawable82 = 0;
        int z92 = 0;
        int integer102 = 0;
        int integer112 = 0;
        int integer122 = 0;
        int integer132 = 0;
        int integer142 = 0;
        int integer162 = 0;
        int i182 = i;
        int r1 = i182 & 1 != 0 ? 0 : integer;
        int r3 = i182 & 2 != 0 ? 0 : integer2;
        int r4 = i182 & 4 != 0 ? 0 : integer3;
        int r5 = i182 & 8 != 0 ? 0 : integer4;
        int r6 = i182 & 16 != 0 ? 0 : drawable;
        int r7 = i182 & 32 != 0 ? 0 : drawable2;
        int r8 = i182 & 64 != 0 ? 0 : drawable3;
        int r9 = i182 & 128 != 0 ? 0 : drawable4;
        int r10 = i182 & 256 != 0 ? 0 : z;
        int r11 = i182 & 512 != 0 ? 0 : integer5;
        int r12 = i182 & 1024 != 0 ? 0 : integer6;
        int r13 = i182 & 2048 != 0 ? 0 : integer7;
        int r14 = i182 & 4096 != 0 ? 0 : integer8;
        int r15 = i182 & 8192 != 0 ? 0 : integer9;
        int r2 = i182 & 16384 != 0 ? 0 : integer10;
        int r16 = i182 & 32768 != 0 ? 0 : integer11;
        int r0 = i182 & 65536 != 0 ? 0 : integer12;
        this(integer52, integer22, integer32, integer42, drawable52, drawable62, drawable72, drawable82, z92, integer102, integer112, integer122, integer132, integer142, integer152, integer162, (i182 & 65536 != 0 ? 0 : integer12));
    }

    public a() {
        this(null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, 131071, null);
    }

    public boolean equals(Object object) {
        if (this != object) {
            z = object instanceof a;
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        boolean z = true;
        i = 0;
        if (this.a != null) {
            i = this.a.hashCode();
        } else {
        }
        if (this.b != null) {
            i = this.b.hashCode();
        } else {
        }
        if (this.c != null) {
            i = this.c.hashCode();
        } else {
        }
        if (this.d != null) {
            i = this.d.hashCode();
        } else {
        }
        if (this.e != null) {
            i = this.e.hashCode();
        } else {
        }
        if (this.f != null) {
            i = this.f.hashCode();
        } else {
        }
        if (this.g != null) {
            i = this.g.hashCode();
        } else {
        }
        if (this.h != null) {
            i = this.h.hashCode();
        } else {
        }
        if (this.i) {
            int i34 = 1;
        }
        if (this.j != null) {
            i = this.j.hashCode();
        } else {
        }
        if (this.k != null) {
            i = this.k.hashCode();
        } else {
        }
        if (this.l != null) {
            i = this.l.hashCode();
        } else {
        }
        if (this.m != null) {
            i = this.m.hashCode();
        } else {
        }
        if (this.n != null) {
            i = this.n.hashCode();
        } else {
        }
        if (this.o != null) {
            i = this.o.hashCode();
        } else {
        }
        if (this.p != null) {
            i = this.p.hashCode();
        } else {
        }
        if (this.q != null) {
            i = this.q.hashCode();
        }
        return (i * 31) + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + z * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "VectorTextViewParams(drawableStartRes=";
        String str3 = ", drawableEndRes=";
        String str4 = ", drawableBottomRes=";
        String str5 = ", drawableTopRes=";
        String str6 = ", drawableStart=";
        String str7 = ", drawableEnd=";
        String str8 = ", drawableBottom=";
        String str9 = ", drawableTop=";
        String str10 = ", isRtlLayout=";
        String str11 = ", compoundDrawablePadding=";
        String str12 = ", iconWidth=";
        String str13 = ", iconHeight=";
        String str14 = ", compoundDrawablePaddingRes=";
        String str15 = ", tintColor=";
        String str16 = ", widthRes=";
        String str17 = ", heightRes=";
        String str18 = ", squareSizeRes=";
        String str19 = ")";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + str6 + this.e + str7 + this.f + str8 + this.g + str9 + this.h + str10 + this.i + str11 + this.j + str12 + this.k + str13 + this.l + str14 + this.m + str15 + this.n + str16 + this.o + str17 + this.p + str18 + this.q + str19;
        return str;
    }
}

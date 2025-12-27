package com.airbnb.lottie.v;

/* compiled from: DocumentData.java */
/* loaded from: classes.dex */
public class b {

    public final String a;
    public final String b;
    public final float c;
    public final b.a d;
    public final int e;
    public final float f;
    public final float g;
    public final int h;
    public final int i;
    public final float j;
    public final boolean k;

    public enum a {

        CENTER,
        LEFT_ALIGN,
        RIGHT_ALIGN;
    }
    public b(String str, String str2, float f, b.a aVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z) {
        super();
        this.a = str;
        this.b = str2;
        this.c = f;
        this.d = aVar;
        this.e = i;
        this.f = f2;
        this.g = f3;
        this.h = i2;
        this.i = i3;
        this.j = f4;
        this.k = z;
    }

    public int hashCode() {
        long l = (long)Float.floatToRawIntBits(this.f);
        return (int)(float)(this.a.hashCode() * 31) + this.b.hashCode() * 31 + this.c * 31 + this.d.ordinal() * 31 + this.e * 31 + (int)(l ^ (l >>> 32L)) * 31 + this.h;
    }
}

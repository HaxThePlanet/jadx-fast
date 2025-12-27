package com.airbnb.lottie.z;

/* compiled from: ScaleXY.java */
/* loaded from: classes.dex */
public class d {

    private float a;
    private float b;
    public d(float f, float f2) {
        super();
        this.a = f;
        this.b = f2;
    }

    public boolean a(float f, float f2) {
        boolean z = false;
        if (this.a == f) {
            f = this.b == f2 ? 1 : 0;
        }
        return (this.b == f2 ? 1 : 0);
    }

    public float b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public void d(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        float f = b();
        String str2 = "x";
        float f2 = c();
        str = f + str2 + f2;
        return str;
    }

    public d() {
        final float f = 1f;
        this(f, f);
    }
}

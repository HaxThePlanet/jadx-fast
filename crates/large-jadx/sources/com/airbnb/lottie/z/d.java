package com.airbnb.lottie.z;

/* loaded from: classes.dex */
public class d {

    private float a;
    private float b;
    public d() {
        final int i = 1065353216;
        super(i, i);
    }

    public d(float f, float f2) {
        super();
        this.a = f;
        this.b = f2;
    }

    public boolean a(float f, float f2) {
        int obj2;
        if (Float.compare(f3, f) == 0 && Float.compare(obj2, f2) == 0) {
            obj2 = Float.compare(obj2, f2) == 0 ? 1 : 0;
        } else {
        }
        return obj2;
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
        stringBuilder.append(b());
        stringBuilder.append("x");
        stringBuilder.append(c());
        return stringBuilder.toString();
    }
}

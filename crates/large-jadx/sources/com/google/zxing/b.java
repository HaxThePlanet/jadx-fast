package com.google.zxing;

/* loaded from: classes2.dex */
public final class b {

    private final int a;
    private final int b;
    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean i;
        int i2;
        Object obj4;
        if (object instanceof b && this.a == object.a && this.b == object.b) {
            if (this.a == object.a) {
                if (this.b == object.b) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("x");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}

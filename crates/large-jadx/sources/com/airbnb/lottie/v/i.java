package com.airbnb.lottie.v;

/* loaded from: classes.dex */
public class i<T>  {

    T a;
    T b;
    private static boolean a(Object object, Object object2) {
        boolean obj0;
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    obj0 = 1;
                } else {
                    obj0 = 0;
                }
            } else {
            }
        } else {
        }
        return obj0;
    }

    public void b(T t, T t2) {
        this.a = t;
        this.b = t2;
    }

    public boolean equals(Object object) {
        boolean z;
        int i;
        Object obj4;
        if (!object instanceof d) {
            return 0;
        }
        if (i.a(object.a, this.a) && i.a(object.b, this.b)) {
            if (i.a(object.b, this.b)) {
                i = 1;
            }
        }
        return i;
    }

    public int hashCode() {
        int i2;
        int i;
        Object obj = this.a;
        if (obj == null) {
            i2 = i;
        } else {
            i2 = obj.hashCode();
        }
        final Object obj2 = this.b;
        if (obj2 == null) {
        } else {
            i = obj2.hashCode();
        }
        return i2 ^= i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair{");
        stringBuilder.append(String.valueOf(this.a));
        stringBuilder.append(" ");
        stringBuilder.append(String.valueOf(this.b));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

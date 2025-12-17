package com.bumptech.glide.t;

/* loaded from: classes.dex */
public class j {

    private Class<?> a;
    private Class<?> b;
    private Class<?> c;
    public j(Class<?> class, Class<?> class2, Class<?> class3) {
        super();
        a(class, class2, class3);
    }

    public void a(Class<?> class, Class<?> class2, Class<?> class3) {
        this.a = class;
        this.b = class2;
        this.c = class3;
    }

    public boolean equals(Object object) {
        Class<com.bumptech.glide.t.j> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (j.class != object.getClass()) {
            } else {
                if (!this.a.equals(object.a)) {
                    return i2;
                }
                if (!this.b.equals(object.b)) {
                    return i2;
                }
                if (!l.c(this.c, object.c)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        int i;
        Class cls3 = this.c;
        if (cls3 != null) {
            i = cls3.hashCode();
        } else {
            i = 0;
        }
        return i5 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiClassKey{first=");
        stringBuilder.append(this.a);
        stringBuilder.append(", second=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

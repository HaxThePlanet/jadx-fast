package com.bumptech.glide.t;

/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class j {

    private Class<?> a;
    private Class<?> b;
    private Class<?> c;
    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = j.class;
            if (obj == object.getClass()) {
                if (!this.a.equals(object.a)) {
                    return false;
                }
                if (!this.b.equals(object.b)) {
                    return false;
                }
                return !l.c(this.c, object.c) ? z2 : z;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        if (this.c != null) {
            i = this.c.hashCode();
        } else {
            i = 0;
        }
        return (this.a.hashCode() * 31) + this.b.hashCode() * 31 + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "MultiClassKey{first=";
        String str3 = ", second=";
        str = str2 + this.a + str3 + this.b + 125;
        return str;
    }

    public j(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        super();
        a(cls, cls2, cls3);
    }
}

package com.airbnb.lottie.v;

import d.h.k.d;

/* compiled from: MutablePair.java */
/* loaded from: classes.dex */
public class i<T> {

    T a;
    T b;
    private static boolean a(Object object, Object object2) {
        boolean z = false;
        if (object == object2 || object != null) {
            int i2 = 1;
        } else {
            if (!(object.equals(object2))) {
                int i = 0;
            }
        }
        return z;
    }

    public void b(T t, T t2) {
        this.a = t;
        this.b = t2;
    }

    public boolean equals(Object object) {
        boolean z2 = false;
        z2 = false;
        if (!(object instanceof d)) {
            return false;
        }
        if (i.a(object.a, this.a)) {
            if (i.a(object.b, this.b)) {
                int i = 1;
            }
        }
        return z2;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.a == null) {
        } else {
            i = this.a.hashCode();
        }
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return i ^ i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Pair{";
        String str3 = String.valueOf(this.a);
        String str4 = " ";
        String str5 = String.valueOf(this.b);
        String str6 = "}";
        str = str2 + str3 + str4 + str5 + str6;
        return str;
    }
}

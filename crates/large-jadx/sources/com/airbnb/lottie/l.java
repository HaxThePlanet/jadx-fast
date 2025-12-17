package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class l<V>  {

    private final V a;
    private final Throwable b;
    public l(V v) {
        super();
        this.a = v;
        this.b = 0;
    }

    public l(Throwable throwable) {
        super();
        this.b = throwable;
        this.a = 0;
    }

    public Throwable a() {
        return this.b;
    }

    public V b() {
        return this.a;
    }

    public boolean equals(Object object) {
        Object equals;
        Object obj;
        Object obj5;
        int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof l) {
            return i2;
        }
        if (b() != null && b().equals((l)object.b())) {
            if (b().equals(object.b())) {
                return i;
            }
        }
        if (a() != null && object.a() != null) {
            if (object.a() != null) {
                return a().toString().equals(a().toString());
            }
        }
        return i2;
    }

    public int hashCode() {
        Object[] arr = new Object[2];
        return Arrays.hashCode(b(), a());
    }
}

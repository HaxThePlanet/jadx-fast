package com.airbnb.lottie;

import java.util.Arrays;

/* compiled from: LottieResult.java */
/* loaded from: classes.dex */
public final class l<V> {

    private final V a;
    private final Throwable b;
    public l(V v) {
        super();
        this.a = v;
        this.b = null;
    }

    public Throwable a() {
        return this.b;
    }

    public V b() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z3 = false;
        if (!(object instanceof l)) {
            return false;
        }
        if (b() != null && this.b().equals(object.b())) {
            return true;
        }
        if (a() != null && object.a() != null) {
            return a().toString().equals(a().toString());
        }
        return false;
    }

    public int hashCode() {
        Object[] arr = new Object[2];
        return Arrays.hashCode(new Object[] { b(), a() });
    }

    public l(Throwable th) {
        super();
        this.b = th;
        this.a = null;
    }
}

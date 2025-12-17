package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class i8 {

    private final Object a;
    private final int b;
    i8(Object object, int i2) {
        super();
        this.a = object;
        this.b = i2;
    }

    public final boolean equals(Object object) {
        Object obj;
        Object obj4;
        final int i = 0;
        if (!object instanceof i8) {
            return i;
        }
        if (this.a == object.a && this.b == object.b) {
            if (this.b == object.b) {
                return 1;
            }
        }
        return i;
    }

    public final int hashCode() {
        return i += i4;
    }
}

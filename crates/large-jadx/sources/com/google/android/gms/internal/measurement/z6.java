package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class z6<T>  extends com.google.android.gms.internal.measurement.b7<T> {

    static final com.google.android.gms.internal.measurement.z6<Object> a;
    static {
        z6 z6Var = new z6();
        z6.a = z6Var;
    }

    public final T a() {
        IllegalStateException illegalStateException = new IllegalStateException("Optional.get() cannot be called on an absent value");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.internal.measurement.b7
    public final boolean b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.b7
    public final boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.b7
    public final int hashCode() {
        return 2040732332;
    }

    @Override // com.google.android.gms.internal.measurement.b7
    public final String toString() {
        return "Optional.absent()";
    }
}

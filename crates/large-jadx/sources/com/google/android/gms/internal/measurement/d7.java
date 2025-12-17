package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class d7<T>  extends com.google.android.gms.internal.measurement.b7<T> {

    private final T zza;
    d7(T t) {
        super();
        this.zza = t;
    }

    public final T a() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.b7
    public final boolean b() {
        return 1;
    }

    @Override // com.google.android.gms.internal.measurement.b7
    public final boolean equals(Object object) {
        if (object instanceof d7) {
            return this.zza.equals(object.zza);
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.b7
    public final int hashCode() {
        return i += i3;
    }

    @Override // com.google.android.gms.internal.measurement.b7
    public final String toString() {
        String string = this.zza.toString();
        StringBuilder stringBuilder = new StringBuilder(length += 13);
        stringBuilder.append("Optional.of(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class h7<T>  implements Serializable, com.google.android.gms.internal.measurement.e7 {

    final T zza;
    h7(T t) {
        super();
        this.zza = t;
    }

    @Override // java.io.Serializable
    public final boolean equals(Object object) {
        Object obj3;
        final int i = 0;
        Object zza = this.zza;
        obj3 = object.zza;
        if (object instanceof h7 && zza != obj3 && zza.equals(obj3)) {
            zza = this.zza;
            obj3 = object.zza;
            if (zza != obj3) {
                if (zza.equals(obj3)) {
                }
                return i;
            }
            return 1;
        }
        return i;
    }

    @Override // java.io.Serializable
    public final int hashCode() {
        Object[] arr = new Object[1];
        return Arrays.hashCode(this.zza);
    }

    @Override // java.io.Serializable
    public final String toString() {
        String string = this.zza.toString();
        StringBuilder stringBuilder = new StringBuilder(length += 22);
        stringBuilder.append("Suppliers.ofInstance(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final T zza() {
        return this.zza;
    }
}

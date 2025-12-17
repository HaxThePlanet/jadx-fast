package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
final class f7<T>  implements Serializable, com.google.android.gms.internal.measurement.e7 {

    volatile transient boolean a;
    transient T b;
    final com.google.android.gms.internal.measurement.e7<T> zza;
    f7(com.google.android.gms.internal.measurement.e7<T> e7) {
        super();
        Objects.requireNonNull(e7);
        this.zza = e7;
    }

    @Override // java.io.Serializable
    public final String toString() {
        Object string;
        String str;
        StringBuilder stringBuilder;
        if (this.a) {
            String valueOf2 = String.valueOf(this.b);
            stringBuilder = new StringBuilder(length2 += 25);
            stringBuilder.append("<supplier that returned ");
            stringBuilder.append(valueOf2);
            stringBuilder.append(">");
            string = stringBuilder.toString();
        } else {
            string = this.zza;
        }
        String valueOf = String.valueOf(string);
        StringBuilder stringBuilder2 = new StringBuilder(length += 19);
        stringBuilder2.append("Suppliers.memoize(");
        stringBuilder2.append(valueOf);
        stringBuilder2.append(")");
        return stringBuilder2.toString();
    }

    public final T zza() {
        boolean z;
        if (!this.a && !this.a) {
            synchronized (this) {
                Object obj = this.zza.zza();
                this.b = obj;
                this.a = true;
                return obj;
            }
        }
        try {
            return this.b;
        }
    }
}

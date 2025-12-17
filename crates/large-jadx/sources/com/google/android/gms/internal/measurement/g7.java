package com.google.android.gms.internal.measurement;

import java.util.Objects;

/* loaded from: classes2.dex */
final class g7<T>  implements com.google.android.gms.internal.measurement.e7<T> {

    volatile com.google.android.gms.internal.measurement.e7<T> a;
    volatile boolean b;
    T c;
    g7(com.google.android.gms.internal.measurement.e7<T> e7) {
        super();
        Objects.requireNonNull(e7);
        this.a = e7;
    }

    @Override // com.google.android.gms.internal.measurement.e7
    public final String toString() {
        Object string;
        String str;
        StringBuilder stringBuilder;
        if (this.a == null) {
            String valueOf = String.valueOf(this.c);
            stringBuilder = new StringBuilder(length += 25);
            stringBuilder.append("<supplier that returned ");
            stringBuilder.append(valueOf);
            stringBuilder.append(">");
            string = stringBuilder.toString();
        }
        String string2 = string.toString();
        StringBuilder stringBuilder2 = new StringBuilder(length2 += 19);
        stringBuilder2.append("Suppliers.memoize(");
        stringBuilder2.append(string2);
        stringBuilder2.append(")");
        return stringBuilder2.toString();
    }

    public final T zza() {
        boolean z;
        if (!this.b && !this.b) {
            synchronized (this) {
                com.google.android.gms.internal.measurement.e7 e7Var = this.a;
                e7Var.getClass();
                Object obj = e7Var.zza();
                this.c = obj;
                this.b = true;
                this.a = 0;
                return obj;
            }
        }
        try {
            return this.c;
        }
    }
}

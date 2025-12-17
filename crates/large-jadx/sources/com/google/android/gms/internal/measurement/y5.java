package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Objects;

/* loaded from: classes2.dex */
final class y5 extends com.google.android.gms.internal.measurement.u6 {

    private final Context a;
    private final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.b7<com.google.android.gms.internal.measurement.k6>> b;
    y5(Context context, com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.b7<com.google.android.gms.internal.measurement.k6>> e72) {
        super();
        Objects.requireNonNull(context, "Null context");
        this.a = context;
        this.b = e72;
    }

    @Override // com.google.android.gms.internal.measurement.u6
    final Context a() {
        return this.a;
    }

    final com.google.android.gms.internal.measurement.e7<com.google.android.gms.internal.measurement.b7<com.google.android.gms.internal.measurement.k6>> b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.measurement.u6
    public final boolean equals(Object object) {
        boolean equals;
        Context context;
        boolean obj5;
        final int i = 1;
        if (object == this) {
            return i;
        }
        if (object instanceof u6 && this.a.equals((u6)object.a())) {
            if (this.a.equals((u6)object.a())) {
                equals = this.b;
                if (equals == null) {
                    if (object.b() == null) {
                    }
                } else {
                    if (!equals.equals(object.b())) {
                    }
                }
                return i;
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.u6
    public final int hashCode() {
        int i;
        int i6 = 1000003;
        com.google.android.gms.internal.measurement.e7 e7Var = this.b;
        if (e7Var == null) {
            i = 0;
        } else {
            i = e7Var.hashCode();
        }
        return i4 ^= i;
    }

    @Override // com.google.android.gms.internal.measurement.u6
    public final String toString() {
        String string = this.a.toString();
        String valueOf = String.valueOf(this.b);
        StringBuilder stringBuilder = new StringBuilder(i += length);
        stringBuilder.append("FlagsContext{context=");
        stringBuilder.append(string);
        stringBuilder.append(", hermeticFileOverrides=");
        stringBuilder.append(valueOf);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

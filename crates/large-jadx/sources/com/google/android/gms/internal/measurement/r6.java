package com.google.android.gms.internal.measurement;

import android.util.Log;

/* loaded from: classes2.dex */
final class r6 extends com.google.android.gms.internal.measurement.w6<Double> {
    r6(com.google.android.gms.internal.measurement.t6 t6, String string2, Double double3, boolean z4) {
        super(t6, "measurement.test.double_flag", double3, 1, 0);
    }

    @Override // com.google.android.gms.internal.measurement.w6
    final Object a(Object object) {
        double double;
        double str;
        StringBuilder stringBuilder;
        int length;
        Double obj5;
        try {
            obj5 = Double.valueOf(Double.parseDouble((String)object));
            String str2 = super.c();
            str = String.valueOf(str2);
            str = str.length();
            str += 27;
            str += length;
            stringBuilder = new StringBuilder(str);
            str = "Invalid double value for ";
            stringBuilder.append(str);
            stringBuilder.append(str2);
            str2 = ": ";
            stringBuilder.append(str2);
            stringBuilder.append(object);
            object = stringBuilder.toString();
            str2 = "PhenotypeFlag";
            Log.e(str2, object);
            object = null;
            return obj5;
        }
    }
}

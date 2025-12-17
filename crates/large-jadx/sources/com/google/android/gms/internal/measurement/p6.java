package com.google.android.gms.internal.measurement;

import android.util.Log;

/* loaded from: classes2.dex */
final class p6 extends com.google.android.gms.internal.measurement.w6<Long> {
    p6(com.google.android.gms.internal.measurement.t6 t6, String string2, Long long3, boolean z4) {
        super(t6, string2, long3, 1, 0);
    }

    @Override // com.google.android.gms.internal.measurement.w6
    final Object a(Object object) {
        long long;
        long str;
        StringBuilder stringBuilder;
        int length;
        Long obj5;
        try {
            obj5 = Long.valueOf(Long.parseLong((String)object));
            String str2 = super.c();
            str = String.valueOf(str2);
            str = str.length();
            str += 25;
            str += length;
            stringBuilder = new StringBuilder(str);
            str = "Invalid long value for ";
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

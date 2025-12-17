package com.google.android.gms.internal.measurement;

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class q6 extends com.google.android.gms.internal.measurement.w6<Boolean> {
    q6(com.google.android.gms.internal.measurement.t6 t6, String string2, Boolean boolean3, boolean z4) {
        super(t6, string2, boolean3, 1, 0);
    }

    @Override // com.google.android.gms.internal.measurement.w6
    final Object a(Object object) {
        boolean matches;
        String str;
        StringBuilder stringBuilder;
        int length;
        Boolean obj5;
        if (w5.c.matcher(object).matches()) {
            obj5 = Boolean.TRUE;
        } else {
            if (w5.d.matcher(object).matches()) {
                obj5 = Boolean.FALSE;
            } else {
                String str2 = super.c();
                stringBuilder = new StringBuilder(i += length);
                stringBuilder.append("Invalid boolean value for ");
                stringBuilder.append(str2);
                stringBuilder.append(": ");
                stringBuilder.append(object);
                Log.e("PhenotypeFlag", stringBuilder.toString());
                obj5 = 0;
            }
        }
        return obj5;
    }
}

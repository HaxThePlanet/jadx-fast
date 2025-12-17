package com.google.android.gms.internal.firebase-auth-api;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class qm {
    public static String a() {
        int equals;
        Locale default = Locale.getDefault();
        StringBuilder stringBuilder = new StringBuilder();
        qm.b(stringBuilder, default);
        final Locale uS = Locale.US;
        if (!default.equals(uS) && stringBuilder.length() > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            qm.b(stringBuilder, uS);
        }
        return stringBuilder.toString();
    }

    private static void b(StringBuilder stringBuilder, Locale locale2) {
        String language;
        String obj2;
        language = locale2.getLanguage();
        stringBuilder.append(language);
        obj2 = locale2.getCountry();
        if (language != null && obj2 != null) {
            stringBuilder.append(language);
            obj2 = locale2.getCountry();
            if (obj2 != null) {
                stringBuilder.append("-");
                stringBuilder.append(obj2);
            }
        }
    }
}

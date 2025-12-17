package androidx.core.database;

import android.text.TextUtils;

/* loaded from: classes5.dex */
@Deprecated
public final class DatabaseUtilsCompat {
    @Deprecated
    public static String[] appendSelectionArgs(String[] originalValues, String[] newValues) {
        int length;
        if (originalValues != null && originalValues.length == 0) {
            if (originalValues.length == 0) {
            }
            String[] strArr = new String[length2 += length3];
            final int i2 = 0;
            System.arraycopy(originalValues, i2, strArr, i2, originalValues.length);
            System.arraycopy(newValues, i2, strArr, originalValues.length, newValues.length);
            return strArr;
        }
        return newValues;
    }

    @Deprecated
    public static String concatenateWhere(String a, String b) {
        if (TextUtils.isEmpty(a)) {
            return b;
        }
        if (TextUtils.isEmpty(b)) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("(").append(a).append(") AND (").append(b).append(")").toString();
    }
}

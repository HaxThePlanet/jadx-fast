package com.google.android.gms.internal.firebase-auth-api;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class hq {
    public static com.google.android.gms.internal.firebase-auth-api.zzpz a(Exception exception, String string2, String string3) {
        String message = exception.getMessage();
        StringBuilder stringBuilder = new StringBuilder(i2 += length3);
        String str = "Failed to parse ";
        stringBuilder.append(str);
        stringBuilder.append(string2);
        String str2 = " for string [";
        stringBuilder.append(str2);
        stringBuilder.append(string3);
        stringBuilder.append("] with exception: ");
        stringBuilder.append(message);
        Log.e(string2, stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder(i4 += length5);
        stringBuilder2.append(str);
        stringBuilder2.append(string2);
        stringBuilder2.append(str2);
        stringBuilder2.append(string3);
        stringBuilder2.append("]");
        zzpz zzpz = new zzpz(stringBuilder2.toString(), exception);
        return zzpz;
    }

    public static List<String> b(JSONArray jSONArray) {
        int length2;
        String length;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() != 0) {
            if (jSONArray.length() != 0) {
                length2 = 0;
                while (length2 < jSONArray.length()) {
                    arrayList.add(jSONArray.getString(length2));
                    length2++;
                }
            }
        }
        return arrayList;
    }
}

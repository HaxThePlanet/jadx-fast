package com.google.firebase.storage.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class Slashes {
    public static String normalizeSlashes(String string) {
        boolean startsWith;
        int i;
        String str;
        boolean length;
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        String str2 = "/";
        if (!string.startsWith(str2) && !string.endsWith(str2) && string.contains("//")) {
            if (!string.endsWith(str2)) {
                if (string.contains("//")) {
                }
                return string;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] obj6 = string.split(str2, -1);
        i = 0;
        while (i < obj6.length) {
            str = obj6[i];
            if (!TextUtils.isEmpty(str)) {
            }
            i++;
            if (stringBuilder.length() > 0) {
            } else {
            }
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static String preserveSlashEncode(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return Slashes.slashize(Uri.encode(string));
    }

    public static String slashize(String string) {
        r.j(string);
        return string.replace("%2F", "/");
    }
}

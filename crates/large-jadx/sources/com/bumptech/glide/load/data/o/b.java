package com.bumptech.glide.load.data.o;

import android.net.Uri;
import java.util.List;

/* compiled from: MediaStoreUtil.java */
/* loaded from: classes.dex */
public final class b {
    public static boolean a(Uri uri) {
        boolean z3 = false;
        uri = b.b(uri) && !b.e(uri) ? 1 : 0;
        return (b.b(uri) && !b.e(uri) ? 1 : 0);
    }

    public static boolean b(Uri uri) {
        boolean equals;
        String str2;
        boolean z = true;
        if (uri != null) {
            str2 = "content";
            if (str2.equals(uri.getScheme())) {
                str = "media";
                uri = str.equals(uri.getAuthority()) ? 1 : 0;
            }
        }
        return (str.equals(uri.getAuthority()) ? 1 : 0);
    }

    public static boolean c(Uri uri) {
        boolean z3 = false;
        uri = b.b(uri) && b.e(uri) ? 1 : 0;
        return (b.b(uri) && b.e(uri) ? 1 : 0);
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static boolean d(int i, int i2) {
        int i3 = -2147483648;
        boolean z = true;
        i3 = Integer.MIN_VALUE;
        i = i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384 ? 1 : 0;
        return (i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384 ? 1 : 0);
    }
}

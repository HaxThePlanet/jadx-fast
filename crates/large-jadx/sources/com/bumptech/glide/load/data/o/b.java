package com.bumptech.glide.load.data.o;

import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
public final class b {
    public static boolean a(Uri uri) {
        Uri obj1;
        if (b.b(uri) && !b.e(uri)) {
            obj1 = !b.e(uri) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean b(Uri uri) {
        String equals;
        String str;
        int obj2;
        if (uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            if ("content".equals(uri.getScheme())) {
                obj2 = "media".equals(uri.getAuthority()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public static boolean c(Uri uri) {
        Uri obj1;
        if (b.b(uri) && b.e(uri)) {
            obj1 = b.e(uri) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean d(int i, int i2) {
        int i3;
        int obj1;
        i3 = Integer.MIN_VALUE;
        if (i != i3 && i2 != i3 && i <= 512 && i2 <= 384) {
            if (i2 != i3) {
                if (i <= 512) {
                    obj1 = i2 <= 384 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}

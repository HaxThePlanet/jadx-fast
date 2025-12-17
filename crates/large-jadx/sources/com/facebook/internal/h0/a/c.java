package com.facebook.internal.h0.a;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\n\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0006H\u0002¨\u0006\r", d2 = {"Lcom/facebook/internal/logging/dumpsys/ResourcesUtil;", "", "()V", "getFallbackIdString", "", "resourceId", "", "getIdString", "r", "Landroid/content/res/Resources;", "getIdStringQuietly", "getResourcePackageId", "id", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c {

    public static final com.facebook.internal.h0.a.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    private final String a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        stringBuilder.append(Integer.toHexString(i));
        return stringBuilder.toString();
    }

    public static final String b(Resources resources, int i2) {
        String str;
        String resourcePackageName;
        if (resources == null) {
            return c.a.a(i2);
        }
        if (c.a.d(i2) != 127) {
            n.e(resources.getResourcePackageName(i2), "r.getResourcePackageName(resourceId)");
            str = ":";
        } else {
            str = resourcePackageName;
        }
        String resourceTypeName = resources.getResourceTypeName(i2);
        String obj5 = resources.getResourceEntryName(i2);
        StringBuilder obj6 = new StringBuilder(i7 += length4);
        obj6.append("@");
        obj6.append(resourcePackageName);
        obj6.append(str);
        obj6.append(resourceTypeName);
        obj6.append("/");
        obj6.append(obj5);
        obj5 = obj6.toString();
        n.e(obj5, "sb.toString()");
        return obj5;
    }

    public static final String c(Resources resources, int i2) {
        String obj0;
        try {
            obj0 = c.b(resources, i2);
            resources = c.a;
            resources = resources.a(i2);
            return obj0;
        }
    }

    private final int d(int i) {
        return obj1 &= 255;
    }
}

package com.google.android.play.core.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class h1 {

    private static final com.google.android.play.core.internal.h a;
    static {
        h hVar = new h("PhoneskyVerificationUtils");
        h1.a = hVar;
    }

    public static boolean a(Context context) {
        int callingUid;
        String[] obj1;
        obj1 = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (obj1 != null && Arrays.asList(obj1).contains("com.android.vending")) {
            if (Arrays.asList(obj1).contains("com.android.vending")) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean b(Context context) {
        String length;
        boolean enabled;
        boolean equals;
        String contains;
        String str;
        Signature[] obj6;
        length = "com.android.vending";
        final int i = 0;
        if (applicationInfo.enabled) {
            obj6 = obj6.signatures;
            if (obj6 != null) {
                length = obj6.length;
                if (length == 0) {
                    try {
                        enabled = i;
                        while (enabled < length) {
                            equals = g1.a(obj6[enabled].toByteArray());
                            enabled++;
                        }
                        equals = g1.a(obj6[enabled].toByteArray());
                        if (!"8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(equals)) {
                        }
                        if (!Build.TAGS.contains("dev-keys")) {
                        } else {
                        }
                        if (Build.TAGS.contains("test-keys")) {
                        } else {
                        }
                        if (!"GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(equals)) {
                        }
                        enabled++;
                        return 1;
                        h1.a.e("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[i]);
                        return i;
                    }
                } else {
                }
            } else {
            }
        }
    }
}

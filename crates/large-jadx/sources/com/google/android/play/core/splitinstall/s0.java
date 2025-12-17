package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.play.core.internal.h;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class s0 {

    private static final h c;
    private final Context a;
    private final String b;
    static {
        h hVar = new h("SplitInstallInfoProvider");
        s0.c = hVar;
    }

    s0(Context context) {
        super();
        this.a = context;
        this.b = context.getPackageName();
    }

    public static String b(String string) {
        if (string.startsWith("config.")) {
            return "";
        }
        return string.split("\\.config\\.", 2)[0];
    }

    public static boolean e(String string) {
        return string.startsWith("config.");
    }

    public static boolean f(String string) {
        boolean startsWith;
        boolean obj1;
        if (!string.startsWith("config.") && string.contains(".config.")) {
            if (string.contains(".config.")) {
            }
            return 0;
        }
        return 1;
    }

    private final Bundle g() {
        Object applicationInfo;
        applicationInfo = this.a.getPackageManager().getApplicationInfo(this.b, 128);
        applicationInfo = applicationInfo.metaData;
        if (applicationInfo != null && applicationInfo == null) {
            applicationInfo = applicationInfo.metaData;
            if (applicationInfo == null) {
                try {
                    return applicationInfo;
                    s0.c.a("App has no applicationInfo or metaData", new Object[0]);
                    return null;
                    int arr = new Object[arr];
                    s0.c.e("App is not found in PackageManager", arr);
                    return obj0;
                }
            }
        }
    }

    private final Set<String> h() {
        Object str2;
        int sDK_INT;
        int splitNames;
        int str3;
        int arr2;
        int str;
        android.content.pm.PackageInfo packageInfo;
        String empty;
        String arr;
        String string;
        HashSet hashSet = new HashSet();
        str2 = g();
        str3 = 0;
        if (str2 == null) {
        } else {
            String string2 = str2.getString("com.android.dynamic.apk.fused.modules");
            if (string2 != null) {
                if (string2.isEmpty()) {
                    s0.c.a("App has no fused modules.", new Object[str3]);
                } else {
                    Collections.addAll(hashSet, string2.split(",", -1));
                    hashSet.remove("");
                    hashSet.remove("base");
                }
            } else {
            }
        }
        splitNames = 0;
        packageInfo = this.a.getPackageManager().getPackageInfo(this.b, str3);
        if (Build.VERSION.SDK_INT >= 21 && packageInfo != null) {
            splitNames = 0;
            packageInfo = this.a.getPackageManager().getPackageInfo(this.b, str3);
            if (packageInfo != null) {
                splitNames = packageInfo.splitNames;
            }
            if (splitNames != 0) {
                arr = new Object[1];
                arr[str3] = Arrays.toString(splitNames);
                s0.c.a("Adding splits from package manager: %s", arr);
                Collections.addAll(hashSet, splitNames);
            } else {
                s0.c.a("No splits are found or app cannot be found in package manager.", new Object[str3]);
            }
            sDK_INT = r0.a();
            if (sDK_INT != null) {
                hashSet.addAll(sDK_INT.zza());
            }
        }
        return hashSet;
    }

    public final com.google.android.play.core.splitinstall.k0 a() {
        Object i0Var;
        int arr;
        Object resources;
        Bundle bundle = g();
        int i = 0;
        arr = 0;
        if (bundle == null) {
            s0.c.e("No metadata found in Context.", new Object[arr]);
            return i;
        }
        int int = bundle.getInt("com.android.vending.splits");
        if (int == 0) {
            s0.c.e("No metadata found in AndroidManifest.", new Object[arr]);
            return i;
        }
        i0Var = new i0();
        com.google.android.play.core.splitinstall.k0 k0Var = b0.a(this.a.getResources().getXml(int), i0Var);
        if (k0Var == null) {
            s0.c.e("Can't parse languages metadata.", new Object[arr]);
        }
        return k0Var;
    }

    public final Set<String> c() {
        Object next;
        boolean z;
        HashSet hashSet = new HashSet();
        Iterator iterator = h().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!s0.f((String)next)) {
            }
            hashSet.add(next);
        }
        return hashSet;
    }

    public final Set<String> d() {
        String next;
        Set all;
        com.google.android.play.core.splitinstall.k0 k0Var = a();
        if (k0Var == null) {
            return 0;
        }
        HashSet hashSet = new HashSet();
        final Set set = h();
        next = "";
        set.add(next);
        all = c();
        all.add(next);
        Iterator iterator = k0Var.a(all).entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (set.containsAll((Collection)(Map.Entry)next.getValue()) != null) {
            }
            hashSet.add((String)next.getKey());
        }
        return hashSet;
    }
}

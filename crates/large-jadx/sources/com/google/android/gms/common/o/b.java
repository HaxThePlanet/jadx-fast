package com.google.android.gms.common.o;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.util.l;

/* loaded from: classes2.dex */
public class b {

    protected final Context a;
    public b(Context context) {
        super();
        this.a = context;
    }

    public int a(String string) {
        return this.a.checkCallingOrSelfPermission(string);
    }

    public int b(String string, String string2) {
        return this.a.getPackageManager().checkPermission(string, string2);
    }

    public ApplicationInfo c(String string, int i2) {
        return this.a.getPackageManager().getApplicationInfo(string, i2);
    }

    public java.lang.CharSequence d(String string) {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(string, 0));
    }

    public PackageInfo e(String string, int i2) {
        return this.a.getPackageManager().getPackageInfo(string, i2);
    }

    public boolean f() {
        boolean nameForUid;
        int callingUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.a);
        }
        nameForUid = this.a.getPackageManager().getNameForUid(Binder.getCallingUid());
        if (l.h() && nameForUid != null) {
            nameForUid = this.a.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                return this.a.getPackageManager().isInstantApp(nameForUid);
            }
        }
        return 0;
    }

    public final boolean g(int i, String string2) {
        int packageManager;
        boolean length;
        final int i2 = 1;
        final int i3 = 0;
        if (l.d()) {
            Object systemService = this.a.getSystemService("appops");
            if ((AppOpsManager)systemService == null) {
            } else {
                (AppOpsManager)systemService.checkPackage(i, string2);
                return i2;
            }
            NullPointerException obj5 = new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            throw obj5;
        }
        obj5 = this.a.getPackageManager().getPackagesForUid(i);
        if (string2 != null && obj5 != null) {
            if (obj5 != null) {
                packageManager = i3;
                try {
                    for (Object str : i) {
                    }
                    if (string2.equals(obj5[packageManager])) {
                    } else {
                    }
                    return i2;
                    packageManager++;
                    return i3;
                }
            }
        }
    }
}

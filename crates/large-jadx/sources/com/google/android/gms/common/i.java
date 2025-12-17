package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class i {

    private static com.google.android.gms.common.i c;
    private final Context a;
    private volatile String b;
    public i(Context context) {
        super();
        this.a = context.getApplicationContext();
    }

    public static com.google.android.gms.common.i a(Context context) {
        com.google.android.gms.common.i iVar;
        r.j(context);
        final Class<com.google.android.gms.common.i> obj = i.class;
        synchronized (obj) {
            b0.a(context);
            iVar = new i(context);
            i.c = iVar;
            return i.c;
        }
    }

    static final com.google.android.gms.common.x d(PackageInfo packageInfo, com.google.android.gms.common.x... x2Arr2) {
        int i;
        byte[] obj3;
        Signature[] signatures = packageInfo.signatures;
        final int i2 = 0;
        if (signatures == null) {
            return i2;
        }
        if (signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return i2;
        }
        y yVar = new y(packageInfo.signatures[0].toByteArray());
        for (Object obj3 : x2Arr2) {
        }
        return i2;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z2) {
        Signature[] signatures;
        com.google.android.gms.common.x xVar;
        Object obj3;
        com.google.android.gms.common.x[] obj4;
        final int i = 0;
        if (packageInfo != null && packageInfo.signatures != null) {
            if (packageInfo.signatures != null) {
                signatures = 1;
                if (z2 != null) {
                    obj3 = i.d(packageInfo, a0.a);
                } else {
                    obj4 = new x[signatures];
                    obj4[i] = a0.a[i];
                    obj3 = i.d(packageInfo, obj4);
                }
                if (obj3 != null) {
                    return signatures;
                }
            }
        }
        return i;
    }

    private final com.google.android.gms.common.l0 f(String string, boolean z2, boolean z3) {
        boolean z;
        int i;
        String packageName;
        boolean z4;
        com.google.android.gms.common.l0 obj7;
        boolean obj8;
        obj7 = "null pkg";
        if (string == null) {
            return l0.d(obj7);
        }
        if (!string.equals(this.b)) {
            final int i2 = 0;
            if (b0.d()) {
                obj7 = b0.b(string, h.f(this.a), i2, i2);
            } else {
                obj8 = this.a.getPackageManager().getPackageInfo(string, 64);
                if (obj8 == null) {
                    obj7 = l0.d(obj7);
                } else {
                    obj7 = obj8.signatures;
                    if (obj7 != null) {
                        i = 1;
                        if (obj7.length != i) {
                            obj7 = l0.d("single cert required");
                        } else {
                            obj7 = new y(obj8.signatures[i2].toByteArray());
                            packageName = obj8.packageName;
                            z = b0.c(packageName, obj7, h.f(this.a), i2);
                            obj8 = obj8.applicationInfo;
                            if (z.a && obj8 != null && obj8 &= 2 != 0 && obj7.a) {
                                obj8 = obj8.applicationInfo;
                                if (obj8 != null) {
                                    if (obj8 &= 2 != 0) {
                                        if (obj7.a) {
                                            obj7 = l0.d("debuggable release cert app rejected");
                                        } else {
                                            obj7 = z;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            }
            if (obj7.a) {
                this.b = string;
            }
            return obj7;
        }
        return l0.b();
    }

    public boolean b(PackageInfo packageInfo) {
        boolean str;
        boolean obj4;
        final int i = 0;
        if (packageInfo == null) {
            return i;
        }
        final int i2 = 1;
        if (i.e(packageInfo, i)) {
            return i2;
        }
        if (i.e(packageInfo, i2) && h.f(this.a)) {
            if (h.f(this.a)) {
                return i2;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return i;
    }

    public boolean c(int i) {
        PackageManager packageManager;
        com.google.android.gms.common.l0 l0Var;
        int i2;
        int i3;
        boolean z;
        String obj6;
        obj6 = this.a.getPackageManager().getPackagesForUid(i);
        if (obj6 != null) {
            packageManager = obj6.length;
            if (packageManager == null) {
                l0Var = l0.d("no pkgs");
            } else {
                l0Var = 0;
                i2 = 0;
                i3 = i2;
                while (i3 < packageManager) {
                    i3++;
                }
                r.j(l0Var);
            }
        } else {
        }
        l0Var.f();
        return l0Var.a;
    }
}

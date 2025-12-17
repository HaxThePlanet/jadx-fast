package androidx.core.content.d;

import android.content.pm.PackageInfo;
import android.os.Build.VERSION;

/* loaded from: classes.dex */
public final class a {
    public static long a(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long)obj2;
    }
}

package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

/* loaded from: classes.dex */
public final class d {
    public static int a(Context context, String string2, String string3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return (AppOpsManager)context.getSystemService(AppOpsManager.class).noteProxyOpNoThrow(string2, string3);
        }
        return 1;
    }

    public static String b(String string) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(string);
        }
        return null;
    }
}

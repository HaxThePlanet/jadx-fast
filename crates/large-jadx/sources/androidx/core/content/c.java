package androidx.core.content;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import androidx.core.app.d;

/* loaded from: classes.dex */
public final class c {
    public static int a(Context context, String string2, int i3, int i4, String string5) {
        int obj4;
        String obj5;
        final int i = -1;
        if (context.checkPermission(string2, i3, i4) == i) {
            return i;
        }
        final String obj2 = d.b(string2);
        int obj3 = 0;
        if (obj2 == null) {
            return obj3;
        }
        obj4 = context.getPackageManager().getPackagesForUid(i4);
        if (string5 == null && obj4 != null && obj4.length <= 0) {
            obj4 = context.getPackageManager().getPackagesForUid(i4);
            if (obj4 != null) {
                if (obj4.length <= 0) {
                }
                obj5 = obj4[obj3];
            }
            return i;
        }
        if (d.a(context, obj2, obj5) != 0) {
            return -2;
        }
        return obj3;
    }

    public static int b(Context context, String string2) {
        return c.a(context, string2, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}

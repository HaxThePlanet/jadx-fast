package zendesk.belvedere;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.content.a;

/* loaded from: classes3.dex */
class w {
    static boolean a(Context context, String string2) {
        String packageName;
        int i;
        boolean equals;
        final int i2 = 0;
        String[] obj4 = obj4.requestedPermissions;
        if (obj4 != null && obj4.length > 0) {
            if (obj4.length > 0) {
                i = i2;
                while (i < obj4.length) {
                    i++;
                }
            }
        }
        return i2;
    }

    static boolean b(Context context, String string2) {
        int obj0;
        obj0 = a.a(context, string2) == 0 ? 1 : 0;
        return obj0;
    }
}

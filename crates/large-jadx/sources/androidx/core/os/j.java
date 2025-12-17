package androidx.core.os;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;

/* loaded from: classes.dex */
public class j {
    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return (UserManager)context.getSystemService(UserManager.class).isUserUnlocked();
        }
        return 1;
    }
}

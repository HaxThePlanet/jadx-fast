package androidx.core.os;

import android.content.Context;
import android.os.UserManager;

/* loaded from: classes5.dex */
public class UserManagerCompat {

    static class Api24Impl {
        static boolean isUserUnlocked(Context context) {
            return (UserManager)context.getSystemService(UserManager.class).isUserUnlocked();
        }
    }
    public static boolean isUserUnlocked(Context context) {
        return UserManagerCompat.Api24Impl.isUserUnlocked(context);
    }
}

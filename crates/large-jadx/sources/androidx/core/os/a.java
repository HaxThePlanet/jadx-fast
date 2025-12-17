package androidx.core.os;

import android.os.Build.VERSION;

/* loaded from: classes.dex */
public class a {
    @Deprecated
    public static boolean a() {
        int i;
        i = Build.VERSION.SDK_INT >= 30 ? 1 : 0;
        return i;
    }
}

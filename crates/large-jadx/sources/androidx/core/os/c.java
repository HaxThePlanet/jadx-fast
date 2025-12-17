package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build.VERSION;

/* loaded from: classes.dex */
public final class c {
    public static androidx.core.os.e a(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.e(configuration.getLocales());
        }
        java.util.Locale[] arr = new Locale[1];
        return e.a(configuration.locale);
    }
}

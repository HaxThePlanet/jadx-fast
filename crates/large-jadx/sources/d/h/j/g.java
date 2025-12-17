package d.h.j;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public final class g {

    private static final Locale a;
    static {
        final String str = "";
        Locale locale = new Locale(str, str);
        g.a = locale;
    }

    private static int a(Locale locale) {
        int i;
        final int i2 = 0;
        byte obj3 = Character.getDirectionality(locale.getDisplayName(locale).charAt(i2));
        final int i3 = 1;
        if (obj3 != i3 && obj3 != 2) {
            if (obj3 != 2) {
                return i2;
            }
        }
        return i3;
    }

    public static int b(Locale locale) {
        int sDK_INT;
        boolean obj2;
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        sDK_INT = c.c(locale);
        if (locale != null && !locale.equals(g.a) && sDK_INT == null) {
            if (!locale.equals(g.a)) {
                sDK_INT = c.c(locale);
                if (sDK_INT == null) {
                    return g.a(locale);
                }
                if (!sDK_INT.equalsIgnoreCase("Arab") && sDK_INT.equalsIgnoreCase("Hebr")) {
                    if (sDK_INT.equalsIgnoreCase("Hebr")) {
                    }
                }
                return 1;
            }
        }
        return 0;
    }
}

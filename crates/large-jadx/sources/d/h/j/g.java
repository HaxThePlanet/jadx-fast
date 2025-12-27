package d.h.j;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: TextUtilsCompat.java */
/* loaded from: classes.dex */
public final class g {

    private static final Locale a = new Locale("", "");

    private static int a(Locale locale) {
        final int i = 0;
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(i));
        final byte b2 = (byte) 1;
        return directionality != b2 && directionality != (byte) 2 ? i : b2;
    }

    public static int b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null) {
            if (!locale.equals(g.a) && str == null) {
                return g.a(locale);
            }
        }
        return 0;
    }
}

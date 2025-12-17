package d.h.j;

import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;

/* loaded from: classes.dex */
public final class b {
    public static Spanned a(String string, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(string, i2);
        }
        return Html.fromHtml(string);
    }
}

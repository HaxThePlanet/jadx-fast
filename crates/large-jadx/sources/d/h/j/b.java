package d.h.j;

import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;

/* compiled from: HtmlCompat.java */
/* loaded from: classes.dex */
public final class b {
    public static Spanned a(String str, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, i);
        }
        return Html.fromHtml(str);
    }
}

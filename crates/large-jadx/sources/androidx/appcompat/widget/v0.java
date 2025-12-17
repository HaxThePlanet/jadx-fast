package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.View;

/* loaded from: classes.dex */
public class v0 {
    public static void a(View view, java.lang.CharSequence charSequence2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence2);
        } else {
            w0.f(view, charSequence2);
        }
    }
}

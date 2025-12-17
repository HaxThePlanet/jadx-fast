package androidx.databinding.k;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

/* loaded from: classes.dex */
public class h {
    public static void a(View view, Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable2);
        } else {
            view.setBackgroundDrawable(drawable2);
        }
    }
}

package androidx.databinding.k;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;

/* loaded from: classes.dex */
public class b {
    public static ColorStateList a(int i) {
        return ColorStateList.valueOf(i);
    }

    public static ColorDrawable b(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        return colorDrawable;
    }
}

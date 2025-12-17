package f.c.a.e.t;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public final class a {
    public static PorterDuffColorFilter a(Drawable drawable, ColorStateList colorStateList2, PorterDuff.Mode porterDuff$Mode3) {
        if (colorStateList2 != null && mode3 == null) {
            if (mode3 == null) {
            }
            PorterDuffColorFilter obj2 = new PorterDuffColorFilter(colorStateList2.getColorForState(drawable.getState(), 0), mode3);
            return obj2;
        }
        return null;
    }
}

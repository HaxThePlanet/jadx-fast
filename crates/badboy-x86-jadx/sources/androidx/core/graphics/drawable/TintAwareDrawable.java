package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

/* loaded from: classes5.dex */
public interface TintAwareDrawable {
    public abstract void setTint(int i);

    public abstract void setTintList(ColorStateList colorStateList);

    public abstract void setTintMode(PorterDuff.Mode porterDuff$Mode);
}

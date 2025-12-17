package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

/* loaded from: classes5.dex */
public interface TintableCheckedTextView {
    public abstract ColorStateList getSupportCheckMarkTintList();

    public abstract PorterDuff.Mode getSupportCheckMarkTintMode();

    public abstract void setSupportCheckMarkTintList(ColorStateList colorStateList);

    public abstract void setSupportCheckMarkTintMode(PorterDuff.Mode porterDuff$Mode);
}

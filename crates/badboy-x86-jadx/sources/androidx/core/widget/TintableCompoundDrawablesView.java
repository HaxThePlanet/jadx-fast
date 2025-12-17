package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

/* loaded from: classes5.dex */
public interface TintableCompoundDrawablesView {
    public abstract ColorStateList getSupportCompoundDrawablesTintList();

    public abstract PorterDuff.Mode getSupportCompoundDrawablesTintMode();

    public abstract void setSupportCompoundDrawablesTintList(ColorStateList colorStateList);

    public abstract void setSupportCompoundDrawablesTintMode(PorterDuff.Mode porterDuff$Mode);
}

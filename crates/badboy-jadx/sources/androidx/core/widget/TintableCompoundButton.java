package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

/* loaded from: classes5.dex */
public interface TintableCompoundButton {
    public abstract ColorStateList getSupportButtonTintList();

    public abstract PorterDuff.Mode getSupportButtonTintMode();

    public abstract void setSupportButtonTintList(ColorStateList colorStateList);

    public abstract void setSupportButtonTintMode(PorterDuff.Mode porterDuff$Mode);
}

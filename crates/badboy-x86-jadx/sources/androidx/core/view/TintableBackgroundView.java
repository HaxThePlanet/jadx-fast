package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

/* loaded from: classes5.dex */
public interface TintableBackgroundView {
    public abstract ColorStateList getSupportBackgroundTintList();

    public abstract PorterDuff.Mode getSupportBackgroundTintMode();

    public abstract void setSupportBackgroundTintList(ColorStateList colorStateList);

    public abstract void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode);
}

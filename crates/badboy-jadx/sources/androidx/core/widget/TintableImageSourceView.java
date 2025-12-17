package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

/* loaded from: classes5.dex */
public interface TintableImageSourceView {
    public abstract ColorStateList getSupportImageTintList();

    public abstract PorterDuff.Mode getSupportImageTintMode();

    public abstract void setSupportImageTintList(ColorStateList colorStateList);

    public abstract void setSupportImageTintMode(PorterDuff.Mode porterDuff$Mode);
}

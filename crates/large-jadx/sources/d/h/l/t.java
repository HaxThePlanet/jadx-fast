package d.h.l;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

/* compiled from: TintableBackgroundView.java */
/* loaded from: classes.dex */
public interface t {
    ColorStateList getSupportBackgroundTintList();

    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList list);

    void setSupportBackgroundTintMode(PorterDuff.Mode mode);
}

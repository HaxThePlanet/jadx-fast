package androidx.appcompat.widget;

import android.content.res.Resources.Theme;
import android.widget.SpinnerAdapter;

/* loaded from: classes.dex */
public interface p0 extends SpinnerAdapter {
    @Override // android.widget.SpinnerAdapter
    public abstract Resources.Theme getDropDownViewTheme();

    @Override // android.widget.SpinnerAdapter
    public abstract void setDropDownViewTheme(Resources.Theme resources$Theme);
}

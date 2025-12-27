package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellSocialHeaderBinding.java */
/* loaded from: classes.dex */
public abstract class i7 extends ViewDataBinding {

    public final View O;
    protected i7(Object object, View view, int i, ImageView imageView, View view2) {
        super(object, view, i);
        this.O = view2;
    }

    public static i7 T(View view) {
        return i7.U(view, f.e());
    }

    @Deprecated
    public static i7 U(View view, Object object) {
        return (i7)ViewDataBinding.k(object, view, 2131558554);
    }
}

package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class i7 extends ViewDataBinding {

    public final View O;
    protected i7(Object object, View view2, int i3, ImageView imageView4, View view5) {
        super(object, view2, i3);
        this.O = view5;
    }

    public static app.dogo.com.dogo_android.h.i7 T(View view) {
        return i7.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.i7 U(View view, Object object2) {
        return (i7)ViewDataBinding.k(object2, view, 2131558554);
    }
}

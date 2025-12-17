package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class a0 extends ViewDataBinding {

    public final ImageView O;
    protected a0(Object object, View view2, int i3, ImageView imageView4) {
        super(object, view2, i3);
        this.O = imageView4;
    }

    public static app.dogo.com.dogo_android.h.a0 T(View view) {
        return a0.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.a0 U(View view, Object object2) {
        return (a0)ViewDataBinding.k(object2, view, 2131558457);
    }
}

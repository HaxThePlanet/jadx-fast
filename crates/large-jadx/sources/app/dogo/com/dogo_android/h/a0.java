package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellBlankScreenRowBinding.java */
/* loaded from: classes.dex */
public abstract class a0 extends ViewDataBinding {

    public final ImageView O;
    protected a0(Object object, View view, int i, ImageView imageView) {
        super(object, view, i);
        this.O = imageView;
    }

    public static a0 T(View view) {
        return a0.U(view, f.e());
    }

    @Deprecated
    public static a0 U(View view, Object object) {
        return (a0)ViewDataBinding.k(object, view, 2131558457);
    }
}

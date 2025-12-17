package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class c6 extends ViewDataBinding {

    public final TextView O;
    protected c6(Object object, View view2, int i3, TextView textView4, ImageView imageView5, TextView textView6) {
        super(object, view2, i3);
        this.O = textView4;
    }

    public static app.dogo.com.dogo_android.h.c6 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return c6.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.c6 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (c6)ViewDataBinding.z(layoutInflater, 2131558538, viewGroup2, z3, object4);
    }
}

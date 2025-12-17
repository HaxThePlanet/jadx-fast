package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class u7 extends ViewDataBinding {

    public final TextView O;
    protected String P;
    protected u7(Object object, View view2, int i3, ImageView imageView4, TextView textView5, TextView textView6) {
        super(object, view2, i3);
        this.O = textView5;
    }

    public static app.dogo.com.dogo_android.h.u7 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return u7.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.u7 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (u7)ViewDataBinding.z(layoutInflater, 2131558561, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String string);
}

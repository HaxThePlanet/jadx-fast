package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.k.e;

/* loaded from: classes.dex */
public abstract class u1 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    protected e R;
    protected u1(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, TextView textView6) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = imageView5;
        this.Q = textView6;
    }

    public static app.dogo.com.dogo_android.h.u1 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return u1.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.u1 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (u1)ViewDataBinding.z(layoutInflater, 2131558481, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}

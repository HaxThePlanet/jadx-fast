package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class q0 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    protected q0(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView7) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = imageView6;
        this.Q = textView7;
    }

    public static app.dogo.com.dogo_android.h.q0 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return q0.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.q0 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (q0)ViewDataBinding.z(layoutInflater, 2131558466, viewGroup2, z3, object4);
    }
}

package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.a.n.e;

/* loaded from: classes.dex */
public abstract class u0 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final ImageView Q;
    public final ImageView R;
    public final ImageView S;
    public final TextView T;
    protected e U;
    protected u0(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, View view6, ImageView imageView7, ImageView imageView8, ImageView imageView9, TextView textView10) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = imageView5;
        this.Q = imageView7;
        this.R = imageView8;
        this.S = imageView9;
        this.T = textView10;
    }

    public static app.dogo.com.dogo_android.h.u0 T(View view) {
        return u0.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.u0 U(View view, Object object2) {
        return (u0)ViewDataBinding.k(object2, view, 2131558468);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}

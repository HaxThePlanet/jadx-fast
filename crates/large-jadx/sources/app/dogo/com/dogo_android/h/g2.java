package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.d.r.h;

/* loaded from: classes.dex */
public abstract class g2 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    public final ImageView R;
    public final TextView S;
    public final TextView T;
    public final ImageView U;
    public final TextView V;
    protected h W;
    protected g2(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, TextView textView6, ImageView imageView7, RelativeLayout relativeLayout8, TextView textView9, AppCompatImageView appCompatImageView10, TextView textView11, ImageView imageView12, TextView textView13) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = imageView5;
        this.Q = textView6;
        this.R = imageView7;
        this.S = textView9;
        this.T = textView11;
        this.U = imageView12;
        this.V = textView13;
    }

    public static app.dogo.com.dogo_android.h.g2 T(View view) {
        return g2.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.g2 U(View view, Object object2) {
        return (g2)ViewDataBinding.k(object2, view, 2131558488);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h h);
}

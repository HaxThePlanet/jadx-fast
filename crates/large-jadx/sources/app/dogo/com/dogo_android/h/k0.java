package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.b.z.l;

/* loaded from: classes.dex */
public abstract class k0 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    public final TextView S;
    public final FrameLayout T;
    public final RelativeLayout U;
    public final ImageView V;
    public final ProgressBar W;
    public final ImageView X;
    public final ImageView Y;
    public final FrameLayout Z;
    public final FrameLayout a0;
    public final TextView b0;
    public final RelativeLayout c0;
    protected l d0;
    protected k0(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, View view6, TextView textView7, TextView textView8, TextView textView9, FrameLayout frameLayout10, RelativeLayout relativeLayout11, ImageView imageView12, ProgressBar progressBar13, ImageView imageView14, ImageView imageView15, TextView textView16, FrameLayout frameLayout17, FrameLayout frameLayout18, FrameLayout frameLayout19, TextView textView20, RelativeLayout relativeLayout21) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = imageView4;
        obj.P = imageView5;
        obj.Q = textView7;
        obj.R = textView8;
        obj.S = textView9;
        obj.T = frameLayout10;
        obj.U = relativeLayout11;
        obj.V = imageView12;
        obj.W = progressBar13;
        obj.X = imageView14;
        obj.Y = imageView15;
        obj.Z = frameLayout17;
        obj.a0 = frameLayout18;
        obj.b0 = textView20;
        obj.c0 = relativeLayout21;
    }

    public static app.dogo.com.dogo_android.h.k0 T(View view) {
        return k0.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.k0 U(View view, Object object2) {
        return (k0)ViewDataBinding.k(object2, view, 2131558463);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l l);
}

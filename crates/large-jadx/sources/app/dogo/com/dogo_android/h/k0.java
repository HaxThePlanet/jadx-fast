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

/* compiled from: CellChallengeCommentItemBinding.java */
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
    protected k0(Object object, View view, int i, ImageView imageView, ImageView imageView2, View view2, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout, RelativeLayout relativeLayout, ImageView imageView3, ProgressBar progressBar, ImageView imageView4, ImageView imageView5, TextView textView4, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, TextView textView5, RelativeLayout relativeLayout2) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = imageView;
        object2.P = imageView2;
        object2.Q = textView;
        object2.R = textView2;
        object2.S = textView3;
        object2.T = frameLayout;
        object2.U = relativeLayout;
        object2.V = imageView3;
        object2.W = progressBar;
        object2.X = imageView4;
        object2.Y = imageView5;
        object2.Z = frameLayout2;
        object2.a0 = frameLayout3;
        object2.b0 = textView5;
        object2.c0 = relativeLayout2;
    }

    public static k0 T(View view) {
        return k0.U(view, f.e());
    }

    @Deprecated
    public static k0 U(View view, Object object) {
        return (k0)ViewDataBinding.k(object, view, 2131558463);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l lVar);
}

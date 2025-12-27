package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.d.b.z.j;
import app.dogo.com.dogo_android.util.k0.c;

/* compiled from: CellChallengeCommentCaptionItemBinding.java */
/* loaded from: classes.dex */
public abstract class i0 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    public final ImageView S;
    public final ViewPager T;
    public final AppCompatImageView U;
    public final FrameLayout V;
    public final ProgressBar W;
    public final LinearLayout X;
    public final ImageView Y;
    public final ImageView Z;
    public final FrameLayout a0;
    public final TextView b0;
    public final RelativeLayout c0;
    public final TextView d0;
    protected j e0;
    protected c f0;
    protected i0(Object object, View view, int i, ImageView imageView, View view2, ImageView imageView2, TextView textView, TextView textView2, ImageView imageView3, ViewPager viewPager, AppCompatImageView appCompatImageView, ImageView imageView4, FrameLayout frameLayout, ProgressBar progressBar, LinearLayout linearLayout, ImageView imageView5, ImageView imageView6, FrameLayout frameLayout2, TextView textView3, RelativeLayout relativeLayout, TextView textView4) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = imageView;
        object2.P = imageView2;
        object2.Q = textView;
        object2.R = textView2;
        object2.S = imageView3;
        object2.T = viewPager;
        object2.U = appCompatImageView;
        object2.V = frameLayout;
        object2.W = progressBar;
        object2.X = linearLayout;
        object2.Y = imageView5;
        object2.Z = imageView6;
        object2.a0 = frameLayout2;
        object2.b0 = textView3;
        object2.c0 = relativeLayout;
        object2.d0 = textView4;
    }

    public static i0 T(View view) {
        return i0.U(view, f.e());
    }

    @Deprecated
    public static i0 U(View view, Object object) {
        return (i0)ViewDataBinding.k(object, view, 2131558462);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c cVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(j jVar);
}

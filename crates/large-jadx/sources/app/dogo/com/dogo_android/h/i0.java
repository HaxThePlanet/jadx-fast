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
    protected i0(Object object, View view2, int i3, ImageView imageView4, View view5, ImageView imageView6, TextView textView7, TextView textView8, ImageView imageView9, ViewPager viewPager10, AppCompatImageView appCompatImageView11, ImageView imageView12, FrameLayout frameLayout13, ProgressBar progressBar14, LinearLayout linearLayout15, ImageView imageView16, ImageView imageView17, FrameLayout frameLayout18, TextView textView19, RelativeLayout relativeLayout20, TextView textView21) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = imageView4;
        obj.P = imageView6;
        obj.Q = textView7;
        obj.R = textView8;
        obj.S = imageView9;
        obj.T = viewPager10;
        obj.U = appCompatImageView11;
        obj.V = frameLayout13;
        obj.W = progressBar14;
        obj.X = linearLayout15;
        obj.Y = imageView16;
        obj.Z = imageView17;
        obj.a0 = frameLayout18;
        obj.b0 = textView19;
        obj.c0 = relativeLayout20;
        obj.d0 = textView21;
    }

    public static app.dogo.com.dogo_android.h.i0 T(View view) {
        return i0.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.i0 U(View view, Object object2) {
        return (i0)ViewDataBinding.k(object2, view, 2131558462);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c c);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(j j);
}

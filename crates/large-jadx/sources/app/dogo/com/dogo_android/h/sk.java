package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.k0.c;

/* loaded from: classes.dex */
public abstract class sk extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final AppCompatImageView Q;
    public final RelativeLayout R;
    public final ViewPager S;
    public final app.dogo.com.dogo_android.h.ci T;
    public final TextView U;
    public final Button V;
    public final TextView W;
    public final ImageView X;
    public final ImageView Y;
    public final FrameLayout Z;
    public final AppCompatImageView a0;
    public final FrameLayout b0;
    public final ProgressBar c0;
    public final LinearLayout d0;
    public final ImageView e0;
    public final FrameLayout f0;
    public final ImageView g0;
    public final TextView h0;
    public final TextView i0;
    protected c j0;
    protected a0 k0;
    protected sk(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, AppCompatImageView appCompatImageView6, Barrier barrier7, RelativeLayout relativeLayout8, ViewPager viewPager9, app.dogo.com.dogo_android.h.ci ci10, TextView textView11, Button button12, TextView textView13, ImageView imageView14, RelativeLayout relativeLayout15, ImageView imageView16, FrameLayout frameLayout17, AppCompatImageView appCompatImageView18, FrameLayout frameLayout19, ProgressBar progressBar20, LinearLayout linearLayout21, ConstraintLayout constraintLayout22, ImageView imageView23, FrameLayout frameLayout24, ImageView imageView25, TextView textView26, RelativeLayout relativeLayout27, TextView textView28) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = imageView4;
        obj.P = imageView5;
        obj.Q = appCompatImageView6;
        obj.R = relativeLayout8;
        obj.S = viewPager9;
        obj.T = ci10;
        obj.U = textView11;
        obj.V = button12;
        obj.W = textView13;
        obj.X = imageView14;
        obj.Y = imageView16;
        obj.Z = frameLayout17;
        obj.a0 = appCompatImageView18;
        obj.b0 = frameLayout19;
        obj.c0 = progressBar20;
        obj.d0 = linearLayout21;
        obj.e0 = imageView23;
        obj.f0 = frameLayout24;
        obj.g0 = imageView25;
        obj.h0 = textView26;
        obj.i0 = textView28;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(c c);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(a0 a0);
}

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

/* compiled from: LayoutEntryBaseBinding.java */
/* loaded from: classes.dex */
public abstract class sk extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final AppCompatImageView Q;
    public final RelativeLayout R;
    public final ViewPager S;
    public final ci T;
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
    protected sk(Object object, View view, int i, ImageView imageView, ImageView imageView2, AppCompatImageView appCompatImageView, Barrier barrier, RelativeLayout relativeLayout, ViewPager viewPager, ci ciVar, TextView textView, Button button, TextView textView2, ImageView imageView3, RelativeLayout relativeLayout2, ImageView imageView4, FrameLayout frameLayout, AppCompatImageView appCompatImageView2, FrameLayout frameLayout2, ProgressBar progressBar, LinearLayout linearLayout, ConstraintLayout constraintLayout, ImageView imageView5, FrameLayout frameLayout3, ImageView imageView6, TextView textView3, RelativeLayout relativeLayout3, TextView textView4) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = imageView;
        object2.P = imageView2;
        object2.Q = appCompatImageView;
        object2.R = relativeLayout;
        object2.S = viewPager;
        object2.T = ciVar;
        object2.U = textView;
        object2.V = button;
        object2.W = textView2;
        object2.X = imageView3;
        object2.Y = imageView4;
        object2.Z = frameLayout;
        object2.a0 = appCompatImageView2;
        object2.b0 = frameLayout2;
        object2.c0 = progressBar;
        object2.d0 = linearLayout;
        object2.e0 = imageView5;
        object2.f0 = frameLayout3;
        object2.g0 = imageView6;
        object2.h0 = textView3;
        object2.i0 = textView4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(c cVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(a0 a0Var);
}

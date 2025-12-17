package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.d.a.n.e;

/* loaded from: classes.dex */
public abstract class s0 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final ImageView Q;
    public final ViewPager R;
    public final TextView S;
    public final ImageView T;
    public final FrameLayout U;
    public final ImageView V;
    public final ImageView W;
    public final TextView X;
    public final TextView Y;
    protected e Z;
    protected s0(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, View view6, ImageView imageView7, ViewPager viewPager8, TextView textView9, ConstraintLayout constraintLayout10, FrameLayout frameLayout11, ImageView imageView12, FrameLayout frameLayout13, ImageView imageView14, ImageView imageView15, TextView textView16, TextView textView17) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = imageView4;
        obj.P = imageView5;
        obj.Q = imageView7;
        obj.R = viewPager8;
        obj.S = textView9;
        obj.T = imageView12;
        obj.U = frameLayout13;
        obj.V = imageView14;
        obj.W = imageView15;
        obj.X = textView16;
        obj.Y = textView17;
    }

    public static app.dogo.com.dogo_android.h.s0 T(View view) {
        return s0.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.s0 U(View view, Object object2) {
        return (s0)ViewDataBinding.k(object2, view, 2131558467);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}

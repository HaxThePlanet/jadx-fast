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

/* compiled from: CellChallengeFanEntryItemBinding.java */
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
    protected s0(Object object, View view, int i, ImageView imageView, ImageView imageView2, View view2, ImageView imageView3, ViewPager viewPager, TextView textView, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView4, FrameLayout frameLayout2, ImageView imageView5, ImageView imageView6, TextView textView2, TextView textView3) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = imageView;
        object2.P = imageView2;
        object2.Q = imageView3;
        object2.R = viewPager;
        object2.S = textView;
        object2.T = imageView4;
        object2.U = frameLayout2;
        object2.V = imageView5;
        object2.W = imageView6;
        object2.X = textView2;
        object2.Y = textView3;
    }

    public static s0 T(View view) {
        return s0.U(view, f.e());
    }

    @Deprecated
    public static s0 U(View view, Object object) {
        return (s0)ViewDataBinding.k(object, view, 2131558467);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e eVar);
}

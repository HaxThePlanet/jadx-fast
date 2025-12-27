package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.util.k0.e;
import app.dogo.com.dogo_android.view.dailytraining.l;

/* compiled from: LayoutCurrentDogViewV2Binding.java */
/* loaded from: classes.dex */
public abstract class ei extends ViewDataBinding {

    public final FrameLayout O;
    public final TextView P;
    public final ImageView Q;
    public final ImageView R;
    public final ImageView S;
    public final ImageView T;
    public final TextView U;
    public final View V;
    public final ConstraintLayout W;
    public final ImageView X;
    protected l Y;
    protected e Z;
    protected ei(Object object, View view, int i, FrameLayout frameLayout, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView2, View view2, ConstraintLayout constraintLayout, ImageView imageView5, ImageView imageView6) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = textView;
        this.Q = imageView;
        this.R = imageView2;
        this.S = imageView3;
        this.T = imageView4;
        this.U = textView2;
        this.V = view2;
        this.W = constraintLayout;
        this.X = imageView6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(e eVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(l lVar);
}

package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.util.k0.e;
import app.dogo.com.dogo_android.view.dailytraining.l;

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
    protected ei(Object object, View view2, int i3, FrameLayout frameLayout4, TextView textView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, TextView textView10, View view11, ConstraintLayout constraintLayout12, ImageView imageView13, ImageView imageView14) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = textView5;
        this.Q = imageView6;
        this.R = imageView7;
        this.S = imageView8;
        this.T = imageView9;
        this.U = textView10;
        this.V = view11;
        this.W = constraintLayout12;
        this.X = imageView14;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(e e);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(l l);
}

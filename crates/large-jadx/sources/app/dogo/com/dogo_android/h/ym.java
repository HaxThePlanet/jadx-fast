package app.dogo.com.dogo_android.h;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.k.n;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;

/* loaded from: classes.dex */
public abstract class ym extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    public final ImageView Q;
    public final TextView R;
    public final TextView S;
    public final ProgressBar T;
    public final CardView U;
    public final TextView V;
    protected DogoSkuDetails W;
    protected View.OnClickListener X;
    protected Boolean Y;
    protected Boolean Z;
    protected n a0;
    protected ym(Object object, View view2, int i3, ImageView imageView4, Guideline guideline5, TextView textView6, FrameLayout frameLayout7, ImageView imageView8, TextView textView9, TextView textView10, ProgressBar progressBar11, CardView cardView12, TextView textView13) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = textView6;
        this.Q = imageView8;
        this.R = textView9;
        this.S = textView10;
        this.T = progressBar11;
        this.U = cardView12;
        this.V = textView13;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(View.OnClickListener view$OnClickListener);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n n);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(DogoSkuDetails dogoSkuDetails);
}

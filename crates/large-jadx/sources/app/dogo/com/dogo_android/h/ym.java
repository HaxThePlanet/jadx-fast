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

/* compiled from: LayoutSubscriptionPlanInformationCardBinding.java */
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
    protected ym(Object object, View view, int i, ImageView imageView, Guideline guideline, TextView textView, FrameLayout frameLayout, ImageView imageView2, TextView textView2, TextView textView3, ProgressBar progressBar, CardView cardView, TextView textView4) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
        this.Q = imageView2;
        this.R = textView2;
        this.S = textView3;
        this.T = progressBar;
        this.U = cardView;
        this.V = textView4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(View.OnClickListener list);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n nVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(DogoSkuDetails dogoSkuDetails);
}

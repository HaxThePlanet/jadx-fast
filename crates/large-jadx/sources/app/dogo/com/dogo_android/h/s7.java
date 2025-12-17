package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.k.n;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;

/* loaded from: classes.dex */
public abstract class s7 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    public final ImageView Q;
    public final TextView R;
    public final TextView S;
    public final CardView T;
    public final TextView U;
    protected DogoSkuDetails V;
    protected Boolean W;
    protected Boolean X;
    protected n Y;
    protected s7(Object object, View view2, int i3, ImageView imageView4, Guideline guideline5, TextView textView6, FrameLayout frameLayout7, ImageView imageView8, TextView textView9, TextView textView10, CardView cardView11, TextView textView12) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = textView6;
        this.Q = imageView8;
        this.R = textView9;
        this.S = textView10;
        this.T = cardView11;
        this.U = textView12;
    }

    public static app.dogo.com.dogo_android.h.s7 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return s7.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.s7 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (s7)ViewDataBinding.z(layoutInflater, 2131558559, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(n n);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void Y(DogoSkuDetails dogoSkuDetails);
}

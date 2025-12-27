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

/* compiled from: CellSubscriptionPlanInformationCardBinding.java */
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
    protected s7(Object object, View view, int i, ImageView imageView, Guideline guideline, TextView textView, FrameLayout frameLayout, ImageView imageView2, TextView textView2, TextView textView3, CardView cardView, TextView textView4) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
        this.Q = imageView2;
        this.R = textView2;
        this.S = textView3;
        this.T = cardView;
        this.U = textView4;
    }

    public static s7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return s7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static s7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (s7)ViewDataBinding.z(layoutInflater, 2131558559, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(n nVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void Y(DogoSkuDetails dogoSkuDetails);
}

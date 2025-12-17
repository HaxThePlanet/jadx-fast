package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* loaded from: classes.dex */
public abstract class c3 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ImageView P;
    public final TextView Q;
    public final CardView R;
    public final ImageView S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    public final TextView W;
    protected ProgramDescriptionItem X;
    protected c3(Object object, View view2, int i3, ConstraintLayout constraintLayout4, ImageView imageView5, TextView textView6, CardView cardView7, ImageView imageView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, Guideline guideline13, TextView textView14) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = imageView5;
        this.Q = textView6;
        this.R = cardView7;
        this.S = imageView8;
        this.T = textView9;
        this.U = textView10;
        this.V = textView11;
        this.W = textView14;
    }

    public static app.dogo.com.dogo_android.h.c3 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return c3.V(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.c3 V(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (c3)ViewDataBinding.z(layoutInflater, 2131558499, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public ProgramDescriptionItem T() {
        return this.X;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(ProgramDescriptionItem programDescriptionItem);
}

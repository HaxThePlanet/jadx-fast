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
public abstract class a4 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ImageView P;
    public final CardView Q;
    public final ImageView R;
    public final TextView S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    protected ProgramDescriptionItem W;
    protected a4(Object object, View view2, int i3, ConstraintLayout constraintLayout4, ImageView imageView5, CardView cardView6, ImageView imageView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, Guideline guideline12, TextView textView13) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = imageView5;
        this.Q = cardView6;
        this.R = imageView7;
        this.S = textView8;
        this.T = textView9;
        this.U = textView10;
        this.V = textView13;
    }

    public static app.dogo.com.dogo_android.h.a4 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return a4.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.a4 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (a4)ViewDataBinding.z(layoutInflater, 2131558511, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramDescriptionItem programDescriptionItem);
}

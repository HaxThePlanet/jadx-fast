package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.t;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;

/* loaded from: classes.dex */
public abstract class wi extends ViewDataBinding {

    public final FrameLayout O;
    public final TextView P;
    public final ImageView Q;
    public final TextView R;
    public final ProgressBar S;
    public final CardView T;
    public final TextView U;
    protected ProgramExamSummary V;
    protected t W;
    protected wi(Object object, View view2, int i3, FrameLayout frameLayout4, TextView textView5, ImageView imageView6, TextView textView7, ProgressBar progressBar8, Guideline guideline9, CardView cardView10, Barrier barrier11, TextView textView12) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = textView5;
        this.Q = imageView6;
        this.R = textView7;
        this.S = progressBar8;
        this.T = cardView10;
        this.U = textView12;
    }

    public static app.dogo.com.dogo_android.h.wi T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return wi.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.wi U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (wi)ViewDataBinding.z(layoutInflater, 2131558753, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(t t);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(ProgramExamSummary programExamSummary);
}

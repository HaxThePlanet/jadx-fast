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

/* compiled from: LayoutDashboardExamsCardBinding.java */
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
    protected wi(Object object, View view, int i, FrameLayout frameLayout, TextView textView, ImageView imageView, TextView textView2, ProgressBar progressBar, Guideline guideline, CardView cardView, Barrier barrier, TextView textView3) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = textView;
        this.Q = imageView;
        this.R = textView2;
        this.S = progressBar;
        this.T = cardView;
        this.U = textView3;
    }

    public static wi T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wi.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wi U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wi)ViewDataBinding.z(layoutInflater, 2131558753, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(t tVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(ProgramExamSummary programExamSummary);
}

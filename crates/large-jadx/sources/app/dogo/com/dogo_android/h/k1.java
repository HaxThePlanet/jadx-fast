package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/* loaded from: classes.dex */
public abstract class k1 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final ConstraintLayout P;
    public final TextView Q;
    public final CircularProgressIndicator R;
    public final AppCompatImageView S;
    public final TextView T;
    protected TrainingTimeMetrics.TrainingTimeDay U;
    protected k1(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, ConstraintLayout constraintLayout5, TextView textView6, CircularProgressIndicator circularProgressIndicator7, AppCompatImageView appCompatImageView8, TextView textView9) {
        super(object, view2, i3);
        this.O = appCompatImageView4;
        this.P = constraintLayout5;
        this.Q = textView6;
        this.R = circularProgressIndicator7;
        this.S = appCompatImageView8;
        this.T = textView9;
    }

    public static app.dogo.com.dogo_android.h.k1 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return k1.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.k1 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (k1)ViewDataBinding.z(layoutInflater, 2131558476, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrainingTimeMetrics.TrainingTimeDay trainingTimeMetrics$TrainingTimeDay);
}

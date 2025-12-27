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

/* compiled from: CellDashboardWeekSumaryDayBinding.java */
/* loaded from: classes.dex */
public abstract class k1 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final ConstraintLayout P;
    public final TextView Q;
    public final CircularProgressIndicator R;
    public final AppCompatImageView S;
    public final TextView T;
    protected TrainingTimeMetrics.TrainingTimeDay U;
    protected k1(Object object, View view, int i, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, TextView textView, CircularProgressIndicator circularProgressIndicator, AppCompatImageView appCompatImageView2, TextView textView2) {
        super(object, view, i);
        this.O = appCompatImageView;
        this.P = constraintLayout;
        this.Q = textView;
        this.R = circularProgressIndicator;
        this.S = appCompatImageView2;
        this.T = textView2;
    }

    public static k1 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return k1.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static k1 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (k1)ViewDataBinding.z(layoutInflater, 2131558476, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrainingTimeMetrics.TrainingTimeDay trainingTimeDay);
}

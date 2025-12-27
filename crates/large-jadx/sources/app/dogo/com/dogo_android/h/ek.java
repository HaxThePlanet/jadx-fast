package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.g.d0;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;

/* compiled from: LayoutDashboardWeekSummaryBinding.java */
/* loaded from: classes.dex */
public abstract class ek extends ViewDataBinding {

    public final ConstraintLayout O;
    public final RecyclerView P;
    public final TextView Q;
    public final TextView R;
    public final yi S;
    protected d0 T;
    protected TrainingTimeMetrics U;
    protected ek(Object object, View view, int i, ConstraintLayout constraintLayout, RecyclerView recyclerView, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, yi yiVar) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = recyclerView;
        this.Q = textView;
        this.R = textView2;
        this.S = yiVar;
    }

    public static ek T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ek.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ek U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ek)ViewDataBinding.z(layoutInflater, 2131558770, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d0 d0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrainingTimeMetrics trainingTimeMetrics);
}

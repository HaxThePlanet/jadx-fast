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

/* loaded from: classes.dex */
public abstract class ek extends ViewDataBinding {

    public final ConstraintLayout O;
    public final RecyclerView P;
    public final TextView Q;
    public final TextView R;
    public final app.dogo.com.dogo_android.h.yi S;
    protected d0 T;
    protected TrainingTimeMetrics U;
    protected ek(Object object, View view2, int i3, ConstraintLayout constraintLayout4, RecyclerView recyclerView5, AppCompatImageView appCompatImageView6, TextView textView7, TextView textView8, app.dogo.com.dogo_android.h.yi yi9) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = recyclerView5;
        this.Q = textView7;
        this.R = textView8;
        this.S = yi9;
    }

    public static app.dogo.com.dogo_android.h.ek T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ek.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ek U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ek)ViewDataBinding.z(layoutInflater, 2131558770, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d0 d0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrainingTimeMetrics trainingTimeMetrics);
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.r;
import app.dogo.com.dogo_android.util.k0.e;
import app.dogo.com.dogo_android.view.dailytraining.l;

/* compiled from: FragmentDashboardBinding.java */
/* loaded from: classes.dex */
public abstract class ua extends ViewDataBinding {

    public final ei O;
    public final ConstraintLayout P;
    public final NestedScrollView Q;
    public final LinearLayout R;
    public final oj S;
    public final SwipeRefreshLayout T;
    public final ui U;
    protected r V;
    protected o W;
    protected e X;
    protected l Y;
    protected ua(Object object, View view, int i, ei eiVar, ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, LinearLayout linearLayout, oj ojVar, SwipeRefreshLayout swipeRefreshLayout, ui uiVar) {
        super(object, view, i);
        this.O = eiVar;
        this.P = constraintLayout;
        this.Q = nestedScrollView;
        this.R = linearLayout;
        this.S = ojVar;
        this.T = swipeRefreshLayout;
        this.U = uiVar;
    }

    public static ua T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ua.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ua U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ua)ViewDataBinding.z(layoutInflater, 2131558638, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o oVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e eVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(l lVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void Y(r rVar);
}

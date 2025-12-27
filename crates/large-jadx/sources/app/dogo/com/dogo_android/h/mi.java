package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.DashboardProgram;

/* compiled from: LayoutDashboardCombinedProgramCardBinding.java */
/* loaded from: classes.dex */
public abstract class mi extends ViewDataBinding {

    public final gj O;
    public final kj P;
    public final mj Q;
    public final si R;
    public final yj S;
    public final TextView T;
    protected DashboardProgram U;
    protected o V;
    protected mi(Object object, View view, int i, gj gjVar, kj kjVar, mj mjVar, si siVar, yj yjVar, TextView textView) {
        super(object, view, i);
        this.O = gjVar;
        this.P = kjVar;
        this.Q = mjVar;
        this.R = siVar;
        this.S = yjVar;
        this.T = textView;
    }

    public static mi T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return mi.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static mi U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (mi)ViewDataBinding.z(layoutInflater, 2131558748, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o oVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(DashboardProgram dashboardProgram);
}

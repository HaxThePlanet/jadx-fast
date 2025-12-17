package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.DashboardProgram;

/* loaded from: classes.dex */
public abstract class mi extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.gj O;
    public final app.dogo.com.dogo_android.h.kj P;
    public final app.dogo.com.dogo_android.h.mj Q;
    public final app.dogo.com.dogo_android.h.si R;
    public final app.dogo.com.dogo_android.h.yj S;
    public final TextView T;
    protected DashboardProgram U;
    protected o V;
    protected mi(Object object, View view2, int i3, app.dogo.com.dogo_android.h.gj gj4, app.dogo.com.dogo_android.h.kj kj5, app.dogo.com.dogo_android.h.mj mj6, app.dogo.com.dogo_android.h.si si7, app.dogo.com.dogo_android.h.yj yj8, TextView textView9) {
        super(object, view2, i3);
        this.O = gj4;
        this.P = kj5;
        this.Q = mj6;
        this.R = si7;
        this.S = yj8;
        this.T = textView9;
    }

    public static app.dogo.com.dogo_android.h.mi T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return mi.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.mi U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (mi)ViewDataBinding.z(layoutInflater, 2131558748, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o o);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(DashboardProgram dashboardProgram);
}

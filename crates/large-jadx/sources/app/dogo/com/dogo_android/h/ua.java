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

/* loaded from: classes.dex */
public abstract class ua extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.ei O;
    public final ConstraintLayout P;
    public final NestedScrollView Q;
    public final LinearLayout R;
    public final app.dogo.com.dogo_android.h.oj S;
    public final SwipeRefreshLayout T;
    public final app.dogo.com.dogo_android.h.ui U;
    protected r V;
    protected o W;
    protected e X;
    protected l Y;
    protected ua(Object object, View view2, int i3, app.dogo.com.dogo_android.h.ei ei4, ConstraintLayout constraintLayout5, NestedScrollView nestedScrollView6, LinearLayout linearLayout7, app.dogo.com.dogo_android.h.oj oj8, SwipeRefreshLayout swipeRefreshLayout9, app.dogo.com.dogo_android.h.ui ui10) {
        super(object, view2, i3);
        this.O = ei4;
        this.P = constraintLayout5;
        this.Q = nestedScrollView6;
        this.R = linearLayout7;
        this.S = oj8;
        this.T = swipeRefreshLayout9;
        this.U = ui10;
    }

    public static app.dogo.com.dogo_android.h.ua T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ua.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ua U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ua)ViewDataBinding.z(layoutInflater, 2131558638, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o o);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e e);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(l l);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void Y(r r);
}

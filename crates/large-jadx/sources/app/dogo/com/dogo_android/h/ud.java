package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.j;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class ud extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.wk O;
    public final app.dogo.com.dogo_android.h.yk P;
    public final ConstraintLayout Q;
    public final app.dogo.com.dogo_android.h.al R;
    public final app.dogo.com.dogo_android.h.el S;
    public final app.dogo.com.dogo_android.h.gl T;
    public final app.dogo.com.dogo_android.h.il U;
    public final SwipeRefreshLayout V;
    public final app.dogo.com.dogo_android.h.kl W;
    protected j X;
    protected g Y;
    protected ud(Object object, View view2, int i3, app.dogo.com.dogo_android.h.wk wk4, app.dogo.com.dogo_android.h.yk yk5, ConstraintLayout constraintLayout6, NestedScrollView nestedScrollView7, app.dogo.com.dogo_android.h.al al8, app.dogo.com.dogo_android.h.el el9, app.dogo.com.dogo_android.h.gl gl10, app.dogo.com.dogo_android.h.il il11, SwipeRefreshLayout swipeRefreshLayout12, MaterialToolbar materialToolbar13, app.dogo.com.dogo_android.h.kl kl14) {
        super(object, view2, i3);
        this.O = wk4;
        this.P = yk5;
        this.Q = constraintLayout6;
        this.R = al8;
        this.S = el9;
        this.T = gl10;
        this.U = il11;
        this.V = swipeRefreshLayout12;
        this.W = kl14;
    }

    public static app.dogo.com.dogo_android.h.ud T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ud.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ud U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ud)ViewDataBinding.z(layoutInflater, 2131558675, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(j j);
}

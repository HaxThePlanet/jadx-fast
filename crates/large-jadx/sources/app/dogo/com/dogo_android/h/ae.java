package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.n.m.r;
import app.dogo.com.dogo_android.view.compat.ChipGroupWithState;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class ae extends ViewDataBinding {

    public final ChipGroupWithState O;
    public final RecyclerView P;
    public final SwipeRefreshLayout Q;
    public final MaterialToolbar R;
    protected r S;
    protected o.a T;
    protected ae(Object object, View view2, int i3, ChipGroupWithState chipGroupWithState4, RecyclerView recyclerView5, HorizontalScrollView horizontalScrollView6, SwipeRefreshLayout swipeRefreshLayout7, MaterialToolbar materialToolbar8) {
        super(object, view2, i3);
        this.O = chipGroupWithState4;
        this.P = recyclerView5;
        this.Q = swipeRefreshLayout7;
        this.R = materialToolbar8;
    }

    public static app.dogo.com.dogo_android.h.ae T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ae.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ae U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ae)ViewDataBinding.z(layoutInflater, 2131558680, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o.a o$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(r r);
}

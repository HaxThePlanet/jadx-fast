package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.n.k.n.b;
import app.dogo.com.dogo_android.n.k.q;
import app.dogo.com.dogo_android.view.compat.ChipGroupWithState;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class sd extends ViewDataBinding {

    public final ChipGroupWithState O;
    public final RecyclerView P;
    public final SwipeRefreshLayout Q;
    public final MaterialToolbar R;
    protected q S;
    protected n.b T;
    protected sd(Object object, View view2, int i3, ChipGroupWithState chipGroupWithState4, RecyclerView recyclerView5, HorizontalScrollView horizontalScrollView6, SwipeRefreshLayout swipeRefreshLayout7, MaterialToolbar materialToolbar8) {
        super(object, view2, i3);
        this.O = chipGroupWithState4;
        this.P = recyclerView5;
        this.Q = swipeRefreshLayout7;
        this.R = materialToolbar8;
    }

    public static app.dogo.com.dogo_android.h.sd T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return sd.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.sd U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (sd)ViewDataBinding.z(layoutInflater, 2131558677, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n.b n$b);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(q q);
}

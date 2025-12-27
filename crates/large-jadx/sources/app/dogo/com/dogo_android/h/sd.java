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

/* compiled from: FragmentLibraryArticleListBinding.java */
/* loaded from: classes.dex */
public abstract class sd extends ViewDataBinding {

    public final ChipGroupWithState O;
    public final RecyclerView P;
    public final SwipeRefreshLayout Q;
    public final MaterialToolbar R;
    protected q S;
    protected n.b T;
    protected sd(Object object, View view, int i, ChipGroupWithState chipGroupWithState, RecyclerView recyclerView, HorizontalScrollView horizontalScrollView, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = chipGroupWithState;
        this.P = recyclerView;
        this.Q = swipeRefreshLayout;
        this.R = materialToolbar;
    }

    public static sd T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sd.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sd U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sd)ViewDataBinding.z(layoutInflater, 2131558677, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n.b bVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(q qVar);
}

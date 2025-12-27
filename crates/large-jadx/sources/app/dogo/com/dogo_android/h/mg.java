package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.f.m.e;
import app.dogo.com.dogo_android.n.m.o.a;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentSimpleTrickListBinding.java */
/* loaded from: classes.dex */
public abstract class mg extends ViewDataBinding {

    public final RecyclerView O;
    public final SwipeRefreshLayout P;
    public final MaterialToolbar Q;
    protected e R;
    protected o.a S;
    protected mg(Object object, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = recyclerView;
        this.P = swipeRefreshLayout;
        this.Q = materialToolbar;
    }

    public static mg T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return mg.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static mg U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (mg)ViewDataBinding.z(layoutInflater, 2131558713, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e eVar);
}

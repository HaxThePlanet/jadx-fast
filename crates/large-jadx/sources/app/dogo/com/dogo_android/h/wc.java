package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.y.o.q.a;
import app.dogo.com.dogo_android.y.o.t;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentExamHistoryBinding.java */
/* loaded from: classes.dex */
public abstract class wc extends ViewDataBinding {

    public final RecyclerView O;
    public final SwipeRefreshLayout P;
    public final MaterialToolbar Q;
    protected t R;
    protected q.a S;
    protected wc(Object object, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = recyclerView;
        this.P = swipeRefreshLayout;
        this.Q = materialToolbar;
    }

    public static wc T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wc.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wc U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wc)ViewDataBinding.z(layoutInflater, 2131558665, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(q.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(t tVar);
}

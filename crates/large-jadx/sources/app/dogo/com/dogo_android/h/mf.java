package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.y.o.u.b;
import app.dogo.com.dogo_android.y.o.x;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class mf extends ViewDataBinding {

    public final RecyclerView O;
    public final SwipeRefreshLayout P;
    public final MaterialToolbar Q;
    protected x R;
    protected u.b S;
    protected mf(Object object, View view2, int i3, RecyclerView recyclerView4, SwipeRefreshLayout swipeRefreshLayout5, MaterialToolbar materialToolbar6) {
        super(object, view2, i3);
        this.O = recyclerView4;
        this.P = swipeRefreshLayout5;
        this.Q = materialToolbar6;
    }

    public static app.dogo.com.dogo_android.h.mf T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return mf.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.mf U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (mf)ViewDataBinding.z(layoutInflater, 2131558700, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(u.b u$b);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(x x);
}

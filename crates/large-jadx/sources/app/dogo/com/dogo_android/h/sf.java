package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.y.y.e.a;
import app.dogo.com.dogo_android.y.y.h;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class sf extends ViewDataBinding {

    public final RecyclerView O;
    public final SwipeRefreshLayout P;
    public final MaterialToolbar Q;
    protected h R;
    protected e.a S;
    protected sf(Object object, View view2, int i3, ConstraintLayout constraintLayout4, RecyclerView recyclerView5, SwipeRefreshLayout swipeRefreshLayout6, MaterialToolbar materialToolbar7) {
        super(object, view2, i3);
        this.O = recyclerView5;
        this.P = swipeRefreshLayout6;
        this.Q = materialToolbar7;
    }

    public static app.dogo.com.dogo_android.h.sf T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return sf.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.sf U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (sf)ViewDataBinding.z(layoutInflater, 2131558703, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e.a e$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(h h);
}

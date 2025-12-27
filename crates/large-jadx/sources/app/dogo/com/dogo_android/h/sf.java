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

/* compiled from: FragmentProgramListBinding.java */
/* loaded from: classes.dex */
public abstract class sf extends ViewDataBinding {

    public final RecyclerView O;
    public final SwipeRefreshLayout P;
    public final MaterialToolbar Q;
    protected h R;
    protected e.a S;
    protected sf(Object object, View view, int i, ConstraintLayout constraintLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = recyclerView;
        this.P = swipeRefreshLayout;
        this.Q = materialToolbar;
    }

    public static sf T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sf.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sf U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sf)ViewDataBinding.z(layoutInflater, 2131558703, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(h hVar);
}

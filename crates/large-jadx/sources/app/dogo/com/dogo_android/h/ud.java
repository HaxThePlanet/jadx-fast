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

/* compiled from: FragmentLibraryBinding.java */
/* loaded from: classes.dex */
public abstract class ud extends ViewDataBinding {

    public final wk O;
    public final yk P;
    public final ConstraintLayout Q;
    public final al R;
    public final el S;
    public final gl T;
    public final il U;
    public final SwipeRefreshLayout V;
    public final kl W;
    protected j X;
    protected g Y;
    protected ud(Object object, View view, int i, wk wkVar, yk ykVar, ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, al alVar, el elVar, gl glVar, il ilVar, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar, kl klVar) {
        super(object, view, i);
        this.O = wkVar;
        this.P = ykVar;
        this.Q = constraintLayout;
        this.R = alVar;
        this.S = elVar;
        this.T = glVar;
        this.U = ilVar;
        this.V = swipeRefreshLayout;
        this.W = klVar;
    }

    public static ud T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ud.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ud U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ud)ViewDataBinding.z(layoutInflater, 2131558675, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g gVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(j jVar);
}

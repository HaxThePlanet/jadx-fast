package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.u.n.p.j;

/* compiled from: FragmentDogLogCalanderBinding.java */
/* loaded from: classes.dex */
public abstract class kc extends ViewDataBinding {

    public final ConstraintLayout O;
    public final RecyclerView P;
    public final ConstraintLayout Q;
    public final SwipeRefreshLayout R;
    public final RecyclerView S;
    public final ConstraintLayout T;
    public final ol U;
    public final Toolbar V;
    public final View W;
    protected j X;
    protected app.dogo.com.dogo_android.u.n.p.f Y;
    protected kc(Object object, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, RecyclerView recyclerView, ConstraintLayout constraintLayout2, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView2, ConstraintLayout constraintLayout3, ol olVar, Toolbar toolbar, View view2) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = constraintLayout;
        object2.P = recyclerView;
        object2.Q = constraintLayout2;
        object2.R = swipeRefreshLayout;
        object2.S = recyclerView2;
        object2.T = constraintLayout3;
        object2.U = olVar;
        object2.V = toolbar;
        object2.W = view2;
    }

    public static kc T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return kc.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static kc U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (kc)ViewDataBinding.z(layoutInflater, 2131558659, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(app.dogo.com.dogo_android.u.n.p.f fVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(j jVar);
}

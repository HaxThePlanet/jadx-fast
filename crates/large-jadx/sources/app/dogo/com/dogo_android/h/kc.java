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
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.u.n.p.f;
import app.dogo.com.dogo_android.u.n.p.j;

/* loaded from: classes.dex */
public abstract class kc extends ViewDataBinding {

    public final ConstraintLayout O;
    public final RecyclerView P;
    public final ConstraintLayout Q;
    public final SwipeRefreshLayout R;
    public final RecyclerView S;
    public final ConstraintLayout T;
    public final app.dogo.com.dogo_android.h.ol U;
    public final Toolbar V;
    public final View W;
    protected j X;
    protected f Y;
    protected kc(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout6, ConstraintLayout constraintLayout7, NestedScrollView nestedScrollView8, RecyclerView recyclerView9, ConstraintLayout constraintLayout10, SwipeRefreshLayout swipeRefreshLayout11, RecyclerView recyclerView12, ConstraintLayout constraintLayout13, app.dogo.com.dogo_android.h.ol ol14, Toolbar toolbar15, View view16) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = constraintLayout7;
        obj.P = recyclerView9;
        obj.Q = constraintLayout10;
        obj.R = swipeRefreshLayout11;
        obj.S = recyclerView12;
        obj.T = constraintLayout13;
        obj.U = ol14;
        obj.V = toolbar15;
        obj.W = view16;
    }

    public static app.dogo.com.dogo_android.h.kc T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return kc.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.kc U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (kc)ViewDataBinding.z(layoutInflater, 2131558659, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(f f);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(j j);
}

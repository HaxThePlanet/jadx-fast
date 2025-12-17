package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.y.w.l.b;
import app.dogo.com.dogo_android.y.w.o;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class qf extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.gm O;
    public final MaterialButton P;
    public final FrameLayout Q;
    public final ConstraintLayout R;
    public final NestedScrollView S;
    public final TextView T;
    public final TextView U;
    public final RecyclerView V;
    public final ConstraintLayout W;
    public final SwipeRefreshLayout X;
    public final MaterialToolbar Y;
    public final Button Z;
    protected o a0;
    protected l.b b0;
    protected Boolean c0;
    protected qf(Object object, View view2, int i3, app.dogo.com.dogo_android.h.gm gm4, MaterialButton materialButton5, FrameLayout frameLayout6, ConstraintLayout constraintLayout7, NestedScrollView nestedScrollView8, TextView textView9, TextView textView10, RecyclerView recyclerView11, ConstraintLayout constraintLayout12, SwipeRefreshLayout swipeRefreshLayout13, MaterialToolbar materialToolbar14, Button button15) {
        super(object, view2, i3);
        this.O = gm4;
        this.P = materialButton5;
        this.Q = frameLayout6;
        this.R = constraintLayout7;
        this.S = nestedScrollView8;
        this.T = textView9;
        this.U = textView10;
        this.V = recyclerView11;
        this.W = constraintLayout12;
        this.X = swipeRefreshLayout13;
        this.Y = materialToolbar14;
        this.Z = button15;
    }

    public static app.dogo.com.dogo_android.h.qf T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return qf.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.qf U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (qf)ViewDataBinding.z(layoutInflater, 2131558702, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l.b l$b);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(o o);
}

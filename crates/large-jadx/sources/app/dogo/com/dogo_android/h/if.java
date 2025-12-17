package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.s.i.a;
import app.dogo.com.dogo_android.y.s.l;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class if extends ViewDataBinding {

    public final SwipeRefreshLayout O;
    public final MaterialToolbar P;
    protected l Q;
    protected i.a R;
    protected if(Object object, View view2, int i3, SwipeRefreshLayout swipeRefreshLayout4, MaterialToolbar materialToolbar5) {
        super(object, view2, i3);
        this.O = swipeRefreshLayout4;
        this.P = materialToolbar5;
    }

    public static app.dogo.com.dogo_android.h.if T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return if.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.if U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (if)ViewDataBinding.z(layoutInflater, 2131558698, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i.a i$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l l);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(l l);
}

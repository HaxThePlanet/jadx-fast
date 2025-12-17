package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.d0.n.a;
import app.dogo.com.dogo_android.y.d0.o;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class cg extends ViewDataBinding {

    public final Button O;
    public final MaterialToolbar P;
    public final app.dogo.com.dogo_android.h.mm Q;
    protected n.a R;
    protected o S;
    protected cg(Object object, View view2, int i3, NestedScrollView nestedScrollView4, Button button5, MaterialToolbar materialToolbar6, app.dogo.com.dogo_android.h.mm mm7) {
        super(object, view2, i3);
        this.O = button5;
        this.P = materialToolbar6;
        this.Q = mm7;
    }

    public static app.dogo.com.dogo_android.h.cg T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return cg.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.cg U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (cg)ViewDataBinding.z(layoutInflater, 2131558708, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n.a n$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l l);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(o o);
}

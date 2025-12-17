package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.d.b.x;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public abstract class e8 extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.ci O;
    public final RecyclerView P;
    public final app.dogo.com.dogo_android.h.cn Q;
    protected e8(Object object, View view2, int i3, app.dogo.com.dogo_android.h.ci ci4, RecyclerView recyclerView5, app.dogo.com.dogo_android.h.cn cn6) {
        super(object, view2, i3);
        this.O = ci4;
        this.P = recyclerView5;
        this.Q = cn6;
    }

    public static app.dogo.com.dogo_android.h.e8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return e8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.e8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (e8)ViewDataBinding.z(layoutInflater, 2131558590, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(x x);
}

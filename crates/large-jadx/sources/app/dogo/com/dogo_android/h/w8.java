package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.u.n.p.m.b.a;
import app.dogo.com.dogo_android.u.n.p.m.e;

/* loaded from: classes.dex */
public abstract class w8 extends ViewDataBinding {

    public final RecyclerView O;
    protected e P;
    protected b.a Q;
    protected w8(Object object, View view2, int i3, RecyclerView recyclerView4) {
        super(object, view2, i3);
        this.O = recyclerView4;
    }

    public static app.dogo.com.dogo_android.h.w8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return w8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.w8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (w8)ViewDataBinding.z(layoutInflater, 2131558599, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b.a b$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e e);
}

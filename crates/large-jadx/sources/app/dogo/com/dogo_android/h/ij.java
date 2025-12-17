package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks;

/* loaded from: classes.dex */
public abstract class ij extends ViewDataBinding {

    public final RecyclerView O;
    protected RecentlyViewedTricks P;
    protected o.a Q;
    protected ij(Object object, View view2, int i3, TextView textView4, RecyclerView recyclerView5) {
        super(object, view2, i3);
        this.O = recyclerView5;
    }

    public static app.dogo.com.dogo_android.h.ij T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ij.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ij U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ij)ViewDataBinding.z(layoutInflater, 2131558759, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o.a o$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(RecentlyViewedTricks recentlyViewedTricks);
}

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

/* compiled from: LayoutDashboardRecentlyViewedTricksBinding.java */
/* loaded from: classes.dex */
public abstract class ij extends ViewDataBinding {

    public final RecyclerView O;
    protected RecentlyViewedTricks P;
    protected o.a Q;
    protected ij(Object object, View view, int i, TextView textView, RecyclerView recyclerView) {
        super(object, view, i);
        this.O = recyclerView;
    }

    public static ij T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ij.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ij U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ij)ViewDataBinding.z(layoutInflater, 2131558759, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(RecentlyViewedTricks recentlyViewedTricks);
}

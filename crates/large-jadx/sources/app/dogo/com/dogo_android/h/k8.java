package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.d.a.m;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: DialogChallengeFanListBinding.java */
/* loaded from: classes.dex */
public abstract class k8 extends ViewDataBinding {

    public final RecyclerView O;
    public final cn P;
    protected k8(Object object, View view, int i, RecyclerView recyclerView, cn cnVar) {
        super(object, view, i);
        this.O = recyclerView;
        this.P = cnVar;
    }

    public static k8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return k8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static k8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (k8)ViewDataBinding.z(layoutInflater, 2131558593, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(m mVar);
}

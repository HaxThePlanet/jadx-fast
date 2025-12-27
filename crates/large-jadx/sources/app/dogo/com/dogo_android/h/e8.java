package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.d.b.x;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: DialogChallengeCommentsBinding.java */
/* loaded from: classes.dex */
public abstract class e8 extends ViewDataBinding {

    public final ci O;
    public final RecyclerView P;
    public final cn Q;
    protected e8(Object object, View view, int i, ci ciVar, RecyclerView recyclerView, cn cnVar) {
        super(object, view, i);
        this.O = ciVar;
        this.P = recyclerView;
        this.Q = cnVar;
    }

    public static e8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return e8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static e8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (e8)ViewDataBinding.z(layoutInflater, 2131558590, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(x xVar);
}

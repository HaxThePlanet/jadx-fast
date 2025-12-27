package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.i.o0.a;
import app.dogo.com.dogo_android.i.s0;

/* compiled from: DialogJsonArrayEditBinding.java */
/* loaded from: classes.dex */
public abstract class k9 extends ViewDataBinding {

    public final RecyclerView O;
    public final Button P;
    protected s0 Q;
    protected o0.a R;
    protected k9(Object object, View view, int i, RecyclerView recyclerView, Button button) {
        super(object, view, i);
        this.O = recyclerView;
        this.P = button;
    }

    public static k9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return k9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static k9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (k9)ViewDataBinding.z(layoutInflater, 2131558608, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o0.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(s0 s0Var);
}

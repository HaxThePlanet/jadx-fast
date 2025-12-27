package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.u.n.q.m.a;
import app.dogo.com.dogo_android.u.n.q.p;

/* compiled from: DialogIntervalSelectBinding.java */
/* loaded from: classes.dex */
public abstract class g9 extends ViewDataBinding {

    public final Button O;
    public final ConstraintLayout P;
    public final RecyclerView Q;
    protected p R;
    protected m.a S;
    protected g9(Object object, View view, int i, Button button, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = constraintLayout;
        this.Q = recyclerView;
    }

    public static g9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return g9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static g9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (g9)ViewDataBinding.z(layoutInflater, 2131558606, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(p pVar);
}

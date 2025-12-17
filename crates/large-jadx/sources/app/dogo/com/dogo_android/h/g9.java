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

/* loaded from: classes.dex */
public abstract class g9 extends ViewDataBinding {

    public final Button O;
    public final ConstraintLayout P;
    public final RecyclerView Q;
    protected p R;
    protected m.a S;
    protected g9(Object object, View view2, int i3, Button button4, ConstraintLayout constraintLayout5, RecyclerView recyclerView6, TextView textView7) {
        super(object, view2, i3);
        this.O = button4;
        this.P = constraintLayout5;
        this.Q = recyclerView6;
    }

    public static app.dogo.com.dogo_android.h.g9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return g9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.g9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (g9)ViewDataBinding.z(layoutInflater, 2131558606, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m.a m$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(p p);
}

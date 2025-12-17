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

/* loaded from: classes.dex */
public abstract class k9 extends ViewDataBinding {

    public final RecyclerView O;
    public final Button P;
    protected s0 Q;
    protected o0.a R;
    protected k9(Object object, View view2, int i3, RecyclerView recyclerView4, Button button5) {
        super(object, view2, i3);
        this.O = recyclerView4;
        this.P = button5;
    }

    public static app.dogo.com.dogo_android.h.k9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return k9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.k9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (k9)ViewDataBinding.z(layoutInflater, 2131558608, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o0.a o0$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(s0 s0);
}

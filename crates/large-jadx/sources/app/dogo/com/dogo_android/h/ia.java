package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.d.c.h;

/* loaded from: classes.dex */
public abstract class ia extends ViewDataBinding {

    public final TextView O;
    public final RecyclerView P;
    public final app.dogo.com.dogo_android.h.cn Q;
    protected h R;
    protected ia(Object object, View view2, int i3, TextView textView4, RecyclerView recyclerView5, app.dogo.com.dogo_android.h.cn cn6) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = recyclerView5;
        this.Q = cn6;
    }

    public static app.dogo.com.dogo_android.h.ia T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ia.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ia U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ia)ViewDataBinding.z(layoutInflater, 2131558632, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h h);
}

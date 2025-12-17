package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import app.dogo.com.dogo_android.u.l.a;

/* loaded from: classes.dex */
public abstract class m7 extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.qm O;
    public final RecyclerView P;
    public final View Q;
    public final TextView R;
    public final TextView S;
    protected TrickItemWithVariations T;
    protected l.a U;
    protected m7(Object object, View view2, int i3, app.dogo.com.dogo_android.h.qm qm4, RecyclerView recyclerView5, ImageView imageView6, View view7, ImageView imageView8, TextView textView9, TextView textView10) {
        super(object, view2, i3);
        this.O = qm4;
        this.P = recyclerView5;
        this.Q = view7;
        this.R = textView9;
        this.S = textView10;
    }

    public static app.dogo.com.dogo_android.h.m7 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return m7.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.m7 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (m7)ViewDataBinding.z(layoutInflater, 2131558556, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l.a l$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrickItemWithVariations trickItemWithVariations);
}

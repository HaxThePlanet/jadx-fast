package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: CellChallengeFilterRowBinding.java */
/* loaded from: classes.dex */
public abstract class a1 extends ViewDataBinding {

    public final LinearLayout O;
    public final RecyclerView P;
    protected EntryFilterViewModel Q;
    protected g0 R;
    protected a0 S;
    protected a1(Object object, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView) {
        super(object, view, i);
        this.O = linearLayout;
        this.P = recyclerView;
    }

    public static a1 T(View view) {
        return a1.U(view, f.e());
    }

    @Deprecated
    public static a1 U(View view, Object object) {
        return (a1)ViewDataBinding.k(object, view, 2131558471);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(g0 g0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(EntryFilterViewModel entryFilterViewModel);
}

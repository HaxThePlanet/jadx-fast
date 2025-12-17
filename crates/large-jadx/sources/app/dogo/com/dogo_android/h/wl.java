package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.n.o.a;

/* loaded from: classes.dex */
public abstract class wl extends ViewDataBinding {

    public final RecyclerView O;
    protected SpecialProgramOverviewItem P;
    protected o.a Q;
    protected wl(Object object, View view2, int i3, TextView textView4, RecyclerView recyclerView5, TextView textView6) {
        super(object, view2, i3);
        this.O = recyclerView5;
    }

    public static app.dogo.com.dogo_android.h.wl T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return wl.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.wl U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (wl)ViewDataBinding.z(layoutInflater, 2131558793, viewGroup2, z3, object4);
    }
}

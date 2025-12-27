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

/* compiled from: LayoutPottyOverviewRemindersBinding.java */
/* loaded from: classes.dex */
public abstract class wl extends ViewDataBinding {

    public final RecyclerView O;
    protected SpecialProgramOverviewItem P;
    protected o.a Q;
    protected wl(Object object, View view, int i, TextView textView, RecyclerView recyclerView, TextView textView2) {
        super(object, view, i);
        this.O = recyclerView;
    }

    public static wl T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wl.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wl U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wl)ViewDataBinding.z(layoutInflater, 2131558793, viewGroup, z, object);
    }
}

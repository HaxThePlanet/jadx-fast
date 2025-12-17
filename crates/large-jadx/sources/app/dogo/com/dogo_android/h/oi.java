package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData;

/* loaded from: classes.dex */
public abstract class oi extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.uj O;
    public final app.dogo.com.dogo_android.h.sj P;
    public final TextView Q;
    protected ProgramDescriptionItem R;
    protected SpecialProgramOverviewItem.ProgramProgressData S;
    protected o T;
    protected oi(Object object, View view2, int i3, app.dogo.com.dogo_android.h.uj uj4, app.dogo.com.dogo_android.h.sj sj5, TextView textView6) {
        super(object, view2, i3);
        this.O = uj4;
        this.P = sj5;
        this.Q = textView6;
    }

    public static app.dogo.com.dogo_android.h.oi T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return oi.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.oi U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (oi)ViewDataBinding.z(layoutInflater, 2131558749, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o o);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(ProgramDescriptionItem programDescriptionItem);
}

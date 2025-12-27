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

/* compiled from: LayoutDashboardCombinedSpecialProgramCardBinding.java */
/* loaded from: classes.dex */
public abstract class oi extends ViewDataBinding {

    public final uj O;
    public final sj P;
    public final TextView Q;
    protected ProgramDescriptionItem R;
    protected SpecialProgramOverviewItem.ProgramProgressData S;
    protected o T;
    protected oi(Object object, View view, int i, uj ujVar, sj sjVar, TextView textView) {
        super(object, view, i);
        this.O = ujVar;
        this.P = sjVar;
        this.Q = textView;
    }

    public static oi T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return oi.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static oi U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (oi)ViewDataBinding.z(layoutInflater, 2131558749, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o oVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(SpecialProgramOverviewItem.ProgramProgressData programProgressData);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(ProgramDescriptionItem programDescriptionItem);
}

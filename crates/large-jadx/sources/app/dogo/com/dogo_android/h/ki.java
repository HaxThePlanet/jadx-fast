package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import java.util.List;

/* compiled from: LayoutDashboardCombinedPottyProgramCardBinding.java */
/* loaded from: classes.dex */
public abstract class ki extends ViewDataBinding {

    public final ej O;
    public final aj P;
    public final cj Q;
    public final View R;
    public final qj S;
    public final TextView T;
    protected ProgramDescriptionItem U;
    protected PottyProgramProgress V;
    protected o W;
    protected List<Boolean> X;
    protected ki(Object object, View view, int i, ej ejVar, TextView textView, ImageView imageView, aj ajVar, cj cjVar, View view2, qj qjVar, TextView textView2) {
        super(object, view, i);
        this.O = ejVar;
        this.P = ajVar;
        this.Q = cjVar;
        this.R = view2;
        this.S = qjVar;
        this.T = textView2;
    }

    public static ki T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ki.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ki U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ki)ViewDataBinding.z(layoutInflater, 2131558747, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o oVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(List<Boolean> list);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(ProgramDescriptionItem programDescriptionItem);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void Y(PottyProgramProgress pottyProgramProgress);
}

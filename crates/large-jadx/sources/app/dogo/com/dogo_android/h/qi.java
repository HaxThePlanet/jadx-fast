package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;

/* compiled from: LayoutDashboardCombinedWorkoutCardBinding.java */
/* loaded from: classes.dex */
public abstract class qi extends ViewDataBinding {

    public final ik O;
    public final gk P;
    protected WorkoutSession Q;
    protected e0 R;
    protected qi(Object object, View view, int i, ik ikVar, TextView textView, gk gkVar) {
        super(object, view, i);
        this.O = ikVar;
        this.P = gkVar;
    }

    public static qi T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return qi.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static qi U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (qi)ViewDataBinding.z(layoutInflater, 2131558750, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e0 e0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(WorkoutSession workoutSession);
}

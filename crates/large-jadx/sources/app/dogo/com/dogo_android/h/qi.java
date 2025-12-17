package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;

/* loaded from: classes.dex */
public abstract class qi extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.ik O;
    public final app.dogo.com.dogo_android.h.gk P;
    protected WorkoutSession Q;
    protected e0 R;
    protected qi(Object object, View view2, int i3, app.dogo.com.dogo_android.h.ik ik4, TextView textView5, app.dogo.com.dogo_android.h.gk gk6) {
        super(object, view2, i3);
        this.O = ik4;
        this.P = gk6;
    }

    public static app.dogo.com.dogo_android.h.qi T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return qi.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.qi U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (qi)ViewDataBinding.z(layoutInflater, 2131558750, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e0 e0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(WorkoutSession workoutSession);
}

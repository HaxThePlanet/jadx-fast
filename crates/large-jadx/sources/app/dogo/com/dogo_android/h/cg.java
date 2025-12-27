package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.d0.n.a;
import app.dogo.com.dogo_android.y.d0.o;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentProgramTrainingPlanBinding.java */
/* loaded from: classes.dex */
public abstract class cg extends ViewDataBinding {

    public final Button O;
    public final MaterialToolbar P;
    public final mm Q;
    protected n.a R;
    protected o S;
    protected cg(Object object, View view, int i, NestedScrollView nestedScrollView, Button button, MaterialToolbar materialToolbar, mm mmVar) {
        super(object, view, i);
        this.O = button;
        this.P = materialToolbar;
        this.Q = mmVar;
    }

    public static cg T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return cg.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static cg U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (cg)ViewDataBinding.z(layoutInflater, 2131558708, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l lVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(o oVar);
}

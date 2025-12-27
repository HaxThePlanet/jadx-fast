package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDogCreationRegisterBinding.java */
/* loaded from: classes.dex */
public abstract class ub extends ViewDataBinding {

    public final ie O;
    public final MaterialToolbar P;
    protected b0 Q;
    protected c0 R;
    protected ub(Object object, View view, int i, ie ieVar, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = ieVar;
        this.P = materialToolbar;
    }

    public static ub T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ub.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ub U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ub)ViewDataBinding.z(layoutInflater, 2131558651, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0Var);
}

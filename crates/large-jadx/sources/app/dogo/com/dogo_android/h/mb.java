package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDogCreationLoginBinding.java */
/* loaded from: classes.dex */
public abstract class mb extends ViewDataBinding {

    public final ee O;
    public final MaterialToolbar P;
    protected b0 Q;
    protected c0 R;
    protected mb(Object object, View view, int i, ee eeVar, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = eeVar;
        this.P = materialToolbar;
    }

    public static mb T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return mb.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static mb U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (mb)ViewDataBinding.z(layoutInflater, 2131558647, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0Var);
}

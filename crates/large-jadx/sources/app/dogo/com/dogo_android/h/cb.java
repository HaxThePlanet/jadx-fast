package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.l0;
import app.dogo.com.dogo_android.i.n0.b;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDebugFeatureEnablerDialogBinding.java */
/* loaded from: classes.dex */
public abstract class cb extends ViewDataBinding {

    public final MaterialToolbar O;
    protected l0 P;
    protected n0.b Q;
    protected cb(Object object, View view, int i, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = materialToolbar;
    }

    public static cb T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return cb.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static cb U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (cb)ViewDataBinding.z(layoutInflater, 2131558642, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n0.b bVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l0 l0Var);
}

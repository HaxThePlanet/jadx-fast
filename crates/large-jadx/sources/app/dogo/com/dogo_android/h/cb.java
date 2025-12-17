package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.l0;
import app.dogo.com.dogo_android.i.n0.b;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class cb extends ViewDataBinding {

    public final MaterialToolbar O;
    protected l0 P;
    protected n0.b Q;
    protected cb(Object object, View view2, int i3, MaterialToolbar materialToolbar4) {
        super(object, view2, i3);
        this.O = materialToolbar4;
    }

    public static app.dogo.com.dogo_android.h.cb T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return cb.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.cb U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (cb)ViewDataBinding.z(layoutInflater, 2131558642, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n0.b n0$b);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l0 l0);
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.a0.e.c;
import app.dogo.com.dogo_android.y.a0.h;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class wf extends ViewDataBinding {

    public final MaterialToolbar O;
    protected h P;
    protected e.c Q;
    protected wf(Object object, View view2, int i3, MaterialToolbar materialToolbar4) {
        super(object, view2, i3);
        this.O = materialToolbar4;
    }

    public static app.dogo.com.dogo_android.h.wf T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return wf.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.wf U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (wf)ViewDataBinding.z(layoutInflater, 2131558705, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e.c e$c);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(h h);
}

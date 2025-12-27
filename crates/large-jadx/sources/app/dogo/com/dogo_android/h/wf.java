package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.a0.e.c;
import app.dogo.com.dogo_android.y.a0.h;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentProgramQuestionBinding.java */
/* loaded from: classes.dex */
public abstract class wf extends ViewDataBinding {

    public final MaterialToolbar O;
    protected h P;
    protected e.c Q;
    protected wf(Object object, View view, int i, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = materialToolbar;
    }

    public static wf T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wf.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wf U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wf)ViewDataBinding.z(layoutInflater, 2131558705, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e.c cVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(h hVar);
}

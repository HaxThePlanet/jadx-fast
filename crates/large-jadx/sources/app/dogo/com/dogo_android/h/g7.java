package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.m0.a;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* compiled from: CellSimpleToogleSwitchBinding.java */
/* loaded from: classes.dex */
public abstract class g7 extends ViewDataBinding {

    public final TextView O;
    public final SwitchMaterial P;
    protected m0.a Q;
    protected g7(Object object, View view, int i, TextView textView, SwitchMaterial switchMaterial) {
        super(object, view, i);
        this.O = textView;
        this.P = switchMaterial;
    }

    public static g7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return g7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static g7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (g7)ViewDataBinding.z(layoutInflater, 2131558553, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m0.a aVar);
}

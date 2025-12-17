package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.m0.a;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* loaded from: classes.dex */
public abstract class g7 extends ViewDataBinding {

    public final TextView O;
    public final SwitchMaterial P;
    protected m0.a Q;
    protected g7(Object object, View view2, int i3, TextView textView4, SwitchMaterial switchMaterial5) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = switchMaterial5;
    }

    public static app.dogo.com.dogo_android.h.g7 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return g7.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.g7 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (g7)ViewDataBinding.z(layoutInflater, 2131558553, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m0.a m0$a);
}

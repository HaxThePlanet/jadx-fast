package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.m0;

/* loaded from: classes.dex */
public abstract class e7 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected m0 Q;
    protected e7(Object object, View view2, int i3, TextView textView4, TextView textView5, TextView textView6) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView6;
    }

    public static app.dogo.com.dogo_android.h.e7 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return e7.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.e7 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (e7)ViewDataBinding.z(layoutInflater, 2131558552, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m0 m0);
}

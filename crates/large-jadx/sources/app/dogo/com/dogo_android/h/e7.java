package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.m0;

/* compiled from: CellSimpleTextRoundedBinding.java */
/* loaded from: classes.dex */
public abstract class e7 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected m0 Q;
    protected e7(Object object, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = textView;
        this.P = textView3;
    }

    public static e7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return e7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static e7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (e7)ViewDataBinding.z(layoutInflater, 2131558552, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m0 m0Var);
}

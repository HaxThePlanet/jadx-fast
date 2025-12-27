package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.q0;

/* compiled from: CellJsonArrayEditBinding.java */
/* loaded from: classes.dex */
public abstract class w2 extends ViewDataBinding {

    public final CheckBox O;
    public final TextView P;
    protected q0 Q;
    protected w2(Object object, View view, int i, CheckBox checkBox, TextView textView) {
        super(object, view, i);
        this.O = checkBox;
        this.P = textView;
    }

    public static w2 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return w2.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static w2 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (w2)ViewDataBinding.z(layoutInflater, 2131558496, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(q0 q0Var);
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.q0;

/* loaded from: classes.dex */
public abstract class w2 extends ViewDataBinding {

    public final CheckBox O;
    public final TextView P;
    protected q0 Q;
    protected w2(Object object, View view2, int i3, CheckBox checkBox4, TextView textView5) {
        super(object, view2, i3);
        this.O = checkBox4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.w2 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return w2.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.w2 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (w2)ViewDataBinding.z(layoutInflater, 2131558496, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(q0 q0);
}

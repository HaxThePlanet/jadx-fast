package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class a5 extends ViewDataBinding {

    public final TextView O;
    protected String P;
    protected a5(Object object, View view2, int i3, TextView textView4) {
        super(object, view2, i3);
        this.O = textView4;
    }

    public static app.dogo.com.dogo_android.h.a5 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return a5.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.a5 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (a5)ViewDataBinding.z(layoutInflater, 2131558524, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String string);
}

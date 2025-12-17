package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class s2 extends ViewDataBinding {

    public final TextView O;
    protected Long P;
    protected s2(Object object, View view2, int i3, TextView textView4) {
        super(object, view2, i3);
        this.O = textView4;
    }

    public static app.dogo.com.dogo_android.h.s2 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return s2.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.s2 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (s2)ViewDataBinding.z(layoutInflater, 2131558494, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Long long);
}

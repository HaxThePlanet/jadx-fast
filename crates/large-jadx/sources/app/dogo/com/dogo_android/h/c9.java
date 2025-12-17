package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.d;

/* loaded from: classes.dex */
public abstract class c9 extends ViewDataBinding {

    public final Button O;
    public final Button P;
    protected d Q;
    protected c9(Object object, View view2, int i3, Button button4, TextView textView5, Button button6, TextView textView7) {
        super(object, view2, i3);
        this.O = button4;
        this.P = button6;
    }

    public static app.dogo.com.dogo_android.h.c9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return c9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.c9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (c9)ViewDataBinding.z(layoutInflater, 2131558603, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d d);
}

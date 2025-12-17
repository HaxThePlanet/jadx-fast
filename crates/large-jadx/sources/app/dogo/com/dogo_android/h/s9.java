package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.e;

/* loaded from: classes.dex */
public abstract class s9 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final Button Q;
    protected e R;
    protected s9(Object object, View view2, int i3, Button button4, TextView textView5, Button button6) {
        super(object, view2, i3);
        this.O = button4;
        this.P = textView5;
        this.Q = button6;
    }

    public static app.dogo.com.dogo_android.h.s9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return s9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.s9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (s9)ViewDataBinding.z(layoutInflater, 2131558612, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}

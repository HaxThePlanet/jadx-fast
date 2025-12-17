package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;

/* loaded from: classes.dex */
public abstract class ge extends ViewDataBinding {

    public final Button O;
    public final Button P;
    public final Button Q;
    public final Button R;
    public final TextView S;
    public final TextView T;
    public final TextView U;
    protected b0 V;
    protected c0 W;
    protected ge(Object object, View view2, int i3, TextView textView4, Button button5, Button button6, Button button7, Button button8, TextView textView9, TextView textView10, TextView textView11) {
        super(object, view2, i3);
        this.O = button5;
        this.P = button6;
        this.Q = button7;
        this.R = button8;
        this.S = textView9;
        this.T = textView10;
        this.U = textView11;
    }

    public static app.dogo.com.dogo_android.h.ge T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ge.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ge U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ge)ViewDataBinding.z(layoutInflater, 2131558684, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0);
}

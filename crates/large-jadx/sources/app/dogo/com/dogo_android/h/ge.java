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

/* compiled from: FragmentLoginProvidersBinding.java */
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
    protected ge(Object object, View view, int i, TextView textView, Button button, Button button2, Button button3, Button button4, TextView textView2, TextView textView3, TextView textView4) {
        super(object, view, i);
        this.O = button;
        this.P = button2;
        this.Q = button3;
        this.R = button4;
        this.S = textView2;
        this.T = textView3;
        this.U = textView4;
    }

    public static ge T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ge.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ge U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ge)ViewDataBinding.z(layoutInflater, 2131558684, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0Var);
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;

/* compiled from: FragmentLoginEmailBinding.java */
/* loaded from: classes.dex */
public abstract class ee extends ViewDataBinding {

    public final EditText O;
    public final Button P;
    public final EditText Q;
    public final Button R;
    public final TextView S;
    protected b0 T;
    protected c0 U;
    protected ee(Object object, View view, int i, EditText editText, Button button, EditText editText2, Button button2, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = editText;
        this.P = button;
        this.Q = editText2;
        this.R = button2;
        this.S = textView;
    }

    public static ee T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ee.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ee U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ee)ViewDataBinding.z(layoutInflater, 2131558683, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0Var);
}

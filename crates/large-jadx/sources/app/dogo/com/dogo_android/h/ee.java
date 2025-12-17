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

/* loaded from: classes.dex */
public abstract class ee extends ViewDataBinding {

    public final EditText O;
    public final Button P;
    public final EditText Q;
    public final Button R;
    public final TextView S;
    protected b0 T;
    protected c0 U;
    protected ee(Object object, View view2, int i3, EditText editText4, Button button5, EditText editText6, Button button7, TextView textView8, TextView textView9) {
        super(object, view2, i3);
        this.O = editText4;
        this.P = button5;
        this.Q = editText6;
        this.R = button7;
        this.S = textView8;
    }

    public static app.dogo.com.dogo_android.h.ee T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ee.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ee U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ee)ViewDataBinding.z(layoutInflater, 2131558683, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0);
}

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

/* compiled from: FragmentLoginRegistrationBinding.java */
/* loaded from: classes.dex */
public abstract class ie extends ViewDataBinding {

    public final EditText O;
    public final EditText P;
    public final Button Q;
    public final TextView R;
    protected b0 S;
    protected c0 T;
    protected ie(Object object, View view, int i, EditText editText, EditText editText2, Button button, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = editText;
        this.P = editText2;
        this.Q = button;
        this.R = textView;
    }

    public static ie T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ie.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ie U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ie)ViewDataBinding.z(layoutInflater, 2131558685, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0Var);
}

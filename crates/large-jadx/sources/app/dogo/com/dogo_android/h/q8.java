package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.e.e;

/* loaded from: classes.dex */
public abstract class q8 extends ViewDataBinding {

    public final Button O;
    public final AppCompatEditText P;
    public final Button Q;
    protected e R;
    protected q8(Object object, View view2, int i3, Button button4, AppCompatEditText appCompatEditText5, Button button6, TextView textView7) {
        super(object, view2, i3);
        this.O = button4;
        this.P = appCompatEditText5;
        this.Q = button6;
    }

    public static app.dogo.com.dogo_android.h.q8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return q8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.q8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (q8)ViewDataBinding.z(layoutInflater, 2131558596, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}

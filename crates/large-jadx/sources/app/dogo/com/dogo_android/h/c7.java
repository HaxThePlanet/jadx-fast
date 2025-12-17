package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.m0;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class c7 extends ViewDataBinding {

    public final TextView O;
    public final EditText P;
    public final TextView Q;
    public final MaterialButton R;
    protected m0 S;
    protected c7(Object object, View view2, int i3, TextView textView4, TextView textView5, EditText editText6, TextView textView7, MaterialButton materialButton8) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = editText6;
        this.Q = textView7;
        this.R = materialButton8;
    }

    public static app.dogo.com.dogo_android.h.c7 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return c7.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.c7 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (c7)ViewDataBinding.z(layoutInflater, 2131558551, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m0 m0);
}

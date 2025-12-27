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

/* compiled from: CellSimpleTextInputBinding.java */
/* loaded from: classes.dex */
public abstract class c7 extends ViewDataBinding {

    public final TextView O;
    public final EditText P;
    public final TextView Q;
    public final MaterialButton R;
    protected m0 S;
    protected c7(Object object, View view, int i, TextView textView, TextView textView2, EditText editText, TextView textView3, MaterialButton materialButton) {
        super(object, view, i);
        this.O = textView;
        this.P = editText;
        this.Q = textView3;
        this.R = materialButton;
    }

    public static c7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return c7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static c7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (c7)ViewDataBinding.z(layoutInflater, 2131558551, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m0 m0Var);
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.q.r.d;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public abstract class gh extends ViewDataBinding {

    public final TextInputEditText O;
    public final TextInputEditText P;
    public final Button Q;
    public final MaterialToolbar R;
    protected d S;
    protected gh(Object object, View view2, int i3, TextInputEditText textInputEditText4, TextView textView5, TextInputLayout textInputLayout6, TextInputLayout textInputLayout7, TextInputEditText textInputEditText8, TextView textView9, Button button10, MaterialToolbar materialToolbar11) {
        super(object, view2, i3);
        this.O = textInputEditText4;
        this.P = textInputEditText8;
        this.Q = button10;
        this.R = materialToolbar11;
    }

    public static app.dogo.com.dogo_android.h.gh T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return gh.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.gh U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (gh)ViewDataBinding.z(layoutInflater, 2131558723, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d d);
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.welcome_v2.g0;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public abstract class qe extends ViewDataBinding {

    public final TextInputEditText O;
    public final FrameLayout P;
    public final TextInputLayout Q;
    public final Button R;
    public final CoordinatorLayout S;
    public final app.dogo.com.dogo_android.h.ql T;
    protected g0 U;
    protected qe(Object object, View view2, int i3, TextInputEditText textInputEditText4, FrameLayout frameLayout5, TextInputLayout textInputLayout6, Button button7, CoordinatorLayout coordinatorLayout8, TextView textView9, app.dogo.com.dogo_android.h.ql ql10) {
        super(object, view2, i3);
        this.O = textInputEditText4;
        this.P = frameLayout5;
        this.Q = textInputLayout6;
        this.R = button7;
        this.S = coordinatorLayout8;
        this.T = ql10;
    }

    public static app.dogo.com.dogo_android.h.qe T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return qe.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.qe U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (qe)ViewDataBinding.z(layoutInflater, 2131558689, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g0 g0);
}

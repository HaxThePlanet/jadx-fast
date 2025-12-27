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

/* compiled from: FragmentOnboardingDogNameV2Binding.java */
/* loaded from: classes.dex */
public abstract class qe extends ViewDataBinding {

    public final TextInputEditText O;
    public final FrameLayout P;
    public final TextInputLayout Q;
    public final Button R;
    public final CoordinatorLayout S;
    public final ql T;
    protected g0 U;
    protected qe(Object object, View view, int i, TextInputEditText textInputEditText, FrameLayout frameLayout, TextInputLayout textInputLayout, Button button, CoordinatorLayout coordinatorLayout, TextView textView, ql qlVar) {
        super(object, view, i);
        this.O = textInputEditText;
        this.P = frameLayout;
        this.Q = textInputLayout;
        this.R = button;
        this.S = coordinatorLayout;
        this.T = qlVar;
    }

    public static qe T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return qe.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static qe U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (qe)ViewDataBinding.z(layoutInflater, 2131558689, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g0 g0Var);
}

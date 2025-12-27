package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.welcome_v2.AnimatedTextView;
import app.dogo.com.dogo_android.welcome_v2.n0;

/* compiled from: FragmentOnboardingProgramGenerationBinding.java */
/* loaded from: classes.dex */
public abstract class ue extends ViewDataBinding {

    public final ConstraintLayout O;
    public final Button P;
    public final ql Q;
    public final ImageView R;
    protected n0 S;
    protected ue(Object object, View view, int i, AnimatedTextView animatedTextView, ConstraintLayout constraintLayout, Button button, ql qlVar, ImageView imageView) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = button;
        this.Q = qlVar;
        this.R = imageView;
    }

    public static ue T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ue.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ue U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ue)ViewDataBinding.z(layoutInflater, 2131558691, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n0 n0Var);
}

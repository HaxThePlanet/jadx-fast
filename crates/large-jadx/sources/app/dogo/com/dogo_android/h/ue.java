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

/* loaded from: classes.dex */
public abstract class ue extends ViewDataBinding {

    public final ConstraintLayout O;
    public final Button P;
    public final app.dogo.com.dogo_android.h.ql Q;
    public final ImageView R;
    protected n0 S;
    protected ue(Object object, View view2, int i3, AnimatedTextView animatedTextView4, ConstraintLayout constraintLayout5, Button button6, app.dogo.com.dogo_android.h.ql ql7, ImageView imageView8) {
        super(object, view2, i3);
        this.O = constraintLayout5;
        this.P = button6;
        this.Q = ql7;
        this.R = imageView8;
    }

    public static app.dogo.com.dogo_android.h.ue T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ue.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ue U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ue)ViewDataBinding.z(layoutInflater, 2131558691, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n0 n0);
}

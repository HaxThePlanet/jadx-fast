package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.g0.h;
import app.dogo.com.dogo_android.welcome_v2.AnimatedTextView;

/* loaded from: classes.dex */
public abstract class wa extends ViewDataBinding {

    public final ConstraintLayout O;
    public final Button P;
    public final app.dogo.com.dogo_android.h.ql Q;
    public final ImageView R;
    protected h S;
    protected wa(Object object, View view2, int i3, AnimatedTextView animatedTextView4, ConstraintLayout constraintLayout5, ImageView imageView6, ImageView imageView7, Button button8, ImageView imageView9, ImageView imageView10, app.dogo.com.dogo_android.h.ql ql11, ImageView imageView12) {
        super(object, view2, i3);
        this.O = constraintLayout5;
        this.P = button8;
        this.Q = ql11;
        this.R = imageView12;
    }

    public static app.dogo.com.dogo_android.h.wa T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return wa.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.wa U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (wa)ViewDataBinding.z(layoutInflater, 2131558639, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h h);
}

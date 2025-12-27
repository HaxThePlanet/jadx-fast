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

/* compiled from: FragmentDashboardProgramGenerationBinding.java */
/* loaded from: classes.dex */
public abstract class wa extends ViewDataBinding {

    public final ConstraintLayout O;
    public final Button P;
    public final ql Q;
    public final ImageView R;
    protected h S;
    protected wa(Object object, View view, int i, AnimatedTextView animatedTextView, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, Button button, ImageView imageView3, ImageView imageView4, ql qlVar, ImageView imageView5) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = button;
        this.Q = qlVar;
        this.R = imageView5;
    }

    public static wa T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wa.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wa U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wa)ViewDataBinding.z(layoutInflater, 2131558639, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h hVar);
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.u.f;
import nl.dionsegijn.konfetti.KonfettiView;

/* loaded from: classes.dex */
public abstract class of extends ViewDataBinding {

    public final TextView O;
    public final KonfettiView P;
    public final TextView Q;
    public final ImageView R;
    public final Button S;
    public final Button T;
    protected f U;
    protected of(Object object, View view2, int i3, ImageView imageView4, TextView textView5, KonfettiView konfettiView6, TextView textView7, ImageView imageView8, Button button9, TextView textView10, Button button11) {
        super(object, view2, i3);
        this.O = textView5;
        this.P = konfettiView6;
        this.Q = textView7;
        this.R = imageView8;
        this.S = button9;
        this.T = button11;
    }

    public static app.dogo.com.dogo_android.h.of T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return of.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.of U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (of)ViewDataBinding.z(layoutInflater, 2131558701, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(f f);
}

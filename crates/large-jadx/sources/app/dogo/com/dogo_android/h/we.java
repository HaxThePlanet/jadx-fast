package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.welcome_v2.s0;
import nl.dionsegijn.konfetti.KonfettiView;

/* loaded from: classes.dex */
public abstract class we extends ViewDataBinding {

    public final FrameLayout O;
    public final Button P;
    public final Button Q;
    public final app.dogo.com.dogo_android.h.ql R;
    public final KonfettiView S;
    protected s0 T;
    protected we(Object object, View view2, int i3, FrameLayout frameLayout4, Button button5, Guideline guideline6, AppCompatImageView appCompatImageView7, Button button8, TextView textView9, TextView textView10, app.dogo.com.dogo_android.h.ql ql11, KonfettiView konfettiView12) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = button5;
        this.Q = button8;
        this.R = ql11;
        this.S = konfettiView12;
    }

    public static app.dogo.com.dogo_android.h.we T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return we.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.we U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (we)ViewDataBinding.z(layoutInflater, 2131558692, viewGroup2, z3, object4);
    }
}

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

/* compiled from: FragmentOnboardingStartBinding.java */
/* loaded from: classes.dex */
public abstract class we extends ViewDataBinding {

    public final FrameLayout O;
    public final Button P;
    public final Button Q;
    public final ql R;
    public final KonfettiView S;
    protected s0 T;
    protected we(Object object, View view, int i, FrameLayout frameLayout, Button button, Guideline guideline, AppCompatImageView appCompatImageView, Button button2, TextView textView, TextView textView2, ql qlVar, KonfettiView konfettiView) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = button;
        this.Q = button2;
        this.R = qlVar;
        this.S = konfettiView;
    }

    public static we T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return we.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static we U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (we)ViewDataBinding.z(layoutInflater, 2131558692, viewGroup, z, object);
    }
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.u.m.p;
import com.google.android.material.appbar.MaterialToolbar;
import nl.dionsegijn.konfetti.KonfettiView;

/* loaded from: classes.dex */
public abstract class y9 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final KonfettiView Q;
    public final LinearLayout R;
    public final TextView S;
    public final AppCompatImageView T;
    public final FrameLayout U;
    public final TextView V;
    public final TextView W;
    public final View X;
    public final NestedScrollView Y;
    public final FrameLayout Z;
    public final TextView a0;
    public final MaterialToolbar b0;
    public final Button c0;
    public final TextView d0;
    public final AppCompatImageView e0;
    public final View f0;
    public final AppCompatImageView g0;
    protected p h0;
    protected j i0;
    protected Boolean j0;
    protected y9(Object object, View view2, int i3, Button button4, TextView textView5, KonfettiView konfettiView6, LinearLayout linearLayout7, TextView textView8, AppCompatImageView appCompatImageView9, FrameLayout frameLayout10, TextView textView11, TextView textView12, View view13, NestedScrollView nestedScrollView14, FrameLayout frameLayout15, TextView textView16, MaterialToolbar materialToolbar17, Button button18, TextView textView19, AppCompatImageView appCompatImageView20, View view21, AppCompatImageView appCompatImageView22) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = button4;
        obj.P = textView5;
        obj.Q = konfettiView6;
        obj.R = linearLayout7;
        obj.S = textView8;
        obj.T = appCompatImageView9;
        obj.U = frameLayout10;
        obj.V = textView11;
        obj.W = textView12;
        obj.X = view13;
        obj.Y = nestedScrollView14;
        obj.Z = frameLayout15;
        obj.a0 = textView16;
        obj.b0 = materialToolbar17;
        obj.c0 = button18;
        obj.d0 = textView19;
        obj.e0 = appCompatImageView20;
        obj.f0 = view21;
        obj.g0 = appCompatImageView22;
    }

    public static app.dogo.com.dogo_android.h.y9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return y9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.y9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (y9)ViewDataBinding.z(layoutInflater, 2131558627, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(j j);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(p p);
}

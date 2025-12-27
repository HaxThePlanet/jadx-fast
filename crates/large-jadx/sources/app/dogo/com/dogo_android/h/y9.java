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

/* compiled from: FragmentBitingProgramOverviewBinding.java */
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
    protected y9(Object object, View view, int i, Button button, TextView textView, KonfettiView konfettiView, LinearLayout linearLayout, TextView textView2, AppCompatImageView appCompatImageView, FrameLayout frameLayout, TextView textView3, TextView textView4, View view2, NestedScrollView nestedScrollView, FrameLayout frameLayout2, TextView textView5, MaterialToolbar materialToolbar, Button button2, TextView textView6, AppCompatImageView appCompatImageView2, View view3, AppCompatImageView appCompatImageView3) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = button;
        object2.P = textView;
        object2.Q = konfettiView;
        object2.R = linearLayout;
        object2.S = textView2;
        object2.T = appCompatImageView;
        object2.U = frameLayout;
        object2.V = textView3;
        object2.W = textView4;
        object2.X = view2;
        object2.Y = nestedScrollView;
        object2.Z = frameLayout2;
        object2.a0 = textView5;
        object2.b0 = materialToolbar;
        object2.c0 = button2;
        object2.d0 = textView6;
        object2.e0 = appCompatImageView2;
        object2.f0 = view3;
        object2.g0 = appCompatImageView3;
    }

    public static y9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return y9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static y9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (y9)ViewDataBinding.z(layoutInflater, 2131558627, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(j jVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(p pVar);
}

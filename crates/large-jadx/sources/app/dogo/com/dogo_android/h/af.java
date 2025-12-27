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
import app.dogo.com.dogo_android.u.n.k;
import app.dogo.com.dogo_android.u.n.n;
import com.google.android.material.appbar.MaterialToolbar;
import nl.dionsegijn.konfetti.KonfettiView;

/* compiled from: FragmentPottyProgramOverviewBinding.java */
/* loaded from: classes.dex */
public abstract class af extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final KonfettiView Q;
    public final LinearLayout R;
    public final AppCompatImageView S;
    public final FrameLayout T;
    public final TextView U;
    public final NestedScrollView V;
    public final FrameLayout W;
    public final TextView X;
    public final MaterialToolbar Y;
    public final Button Z;
    public final TextView a0;
    protected n b0;
    protected k c0;
    protected af(Object object, View view, int i, Button button, TextView textView, KonfettiView konfettiView, LinearLayout linearLayout, TextView textView2, AppCompatImageView appCompatImageView, FrameLayout frameLayout, TextView textView3, NestedScrollView nestedScrollView, FrameLayout frameLayout2, TextView textView4, MaterialToolbar materialToolbar, Button button2, TextView textView5) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = button;
        object2.P = textView;
        object2.Q = konfettiView;
        object2.R = linearLayout;
        object2.S = appCompatImageView;
        object2.T = frameLayout;
        object2.U = textView3;
        object2.V = nestedScrollView;
        object2.W = frameLayout2;
        object2.X = textView4;
        object2.Y = materialToolbar;
        object2.Z = button2;
        object2.a0 = textView5;
    }

    public static af T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return af.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static af U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (af)ViewDataBinding.z(layoutInflater, 2131558694, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(k kVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(n nVar);
}

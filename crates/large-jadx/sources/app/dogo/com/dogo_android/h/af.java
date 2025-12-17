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
    protected af(Object object, View view2, int i3, Button button4, TextView textView5, KonfettiView konfettiView6, LinearLayout linearLayout7, TextView textView8, AppCompatImageView appCompatImageView9, FrameLayout frameLayout10, TextView textView11, NestedScrollView nestedScrollView12, FrameLayout frameLayout13, TextView textView14, MaterialToolbar materialToolbar15, Button button16, TextView textView17) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = button4;
        obj.P = textView5;
        obj.Q = konfettiView6;
        obj.R = linearLayout7;
        obj.S = appCompatImageView9;
        obj.T = frameLayout10;
        obj.U = textView11;
        obj.V = nestedScrollView12;
        obj.W = frameLayout13;
        obj.X = textView14;
        obj.Y = materialToolbar15;
        obj.Z = button16;
        obj.a0 = textView17;
    }

    public static app.dogo.com.dogo_android.h.af T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return af.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.af U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (af)ViewDataBinding.z(layoutInflater, 2131558694, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(k k);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(n n);
}

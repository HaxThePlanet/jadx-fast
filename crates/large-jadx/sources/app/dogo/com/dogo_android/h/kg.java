package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.t.b0;
import app.dogo.com.dogo_android.t.f0;
import app.dogo.com.dogo_android.view.dailytraining.l;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/* compiled from: FragmentSettingsBinding.java */
/* loaded from: classes.dex */
public abstract class kg extends ViewDataBinding {

    public final RelativeLayout O;
    public final RelativeLayout P;
    public final RelativeLayout Q;
    public final RelativeLayout R;
    public final RelativeLayout S;
    public final RelativeLayout T;
    public final RelativeLayout U;
    public final FrameLayout V;
    public final RelativeLayout W;
    public final RelativeLayout X;
    public final RelativeLayout Y;
    public final RelativeLayout Z;
    public final LinearLayout a0;
    public final RelativeLayout b0;
    public final RelativeLayout c0;
    public final RelativeLayout d0;
    public final SwitchCompat e0;
    public final CircularProgressIndicator f0;
    public final TextView g0;
    public final RelativeLayout h0;
    public final RelativeLayout i0;
    public final RelativeLayout j0;
    public final RelativeLayout k0;
    public final RelativeLayout l0;
    public final TextView m0;
    protected f0 n0;
    protected b0 o0;
    protected kg(Object object, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, TextView textView2, RelativeLayout relativeLayout7, FrameLayout frameLayout, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, LinearLayout linearLayout, RelativeLayout relativeLayout12, RelativeLayout relativeLayout13, RelativeLayout relativeLayout14, SwitchCompat switchCompat, CircularProgressIndicator circularProgressIndicator, TextView textView3, TextView textView4, RelativeLayout relativeLayout15, RelativeLayout relativeLayout16, ScrollView scrollView, RelativeLayout relativeLayout17, RelativeLayout relativeLayout18, RelativeLayout relativeLayout19, MaterialToolbar materialToolbar, TextView textView5) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = relativeLayout;
        object2.P = relativeLayout2;
        object2.Q = relativeLayout3;
        object2.R = relativeLayout4;
        object2.S = relativeLayout5;
        object2.T = relativeLayout6;
        object2.U = relativeLayout7;
        object2.V = frameLayout;
        object2.W = relativeLayout8;
        object2.X = relativeLayout9;
        object2.Y = relativeLayout10;
        object2.Z = relativeLayout11;
        object2.a0 = linearLayout;
        object2.b0 = relativeLayout12;
        object2.c0 = relativeLayout13;
        object2.d0 = relativeLayout14;
        object2.e0 = switchCompat;
        object2.f0 = circularProgressIndicator;
        object2.g0 = textView3;
        object2.h0 = relativeLayout15;
        object2.i0 = relativeLayout16;
        object2.j0 = relativeLayout17;
        object2.k0 = relativeLayout18;
        object2.l0 = relativeLayout19;
        object2.m0 = textView5;
    }

    public static kg T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return kg.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static kg U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (kg)ViewDataBinding.z(layoutInflater, 2131558712, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b0 b0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l lVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(f0 f0Var);
}

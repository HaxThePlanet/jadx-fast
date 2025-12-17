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
    protected kg(Object object, View view2, int i3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, TextView textView6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, TextView textView11, RelativeLayout relativeLayout12, FrameLayout frameLayout13, RelativeLayout relativeLayout14, RelativeLayout relativeLayout15, RelativeLayout relativeLayout16, RelativeLayout relativeLayout17, LinearLayout linearLayout18, RelativeLayout relativeLayout19, RelativeLayout relativeLayout20, RelativeLayout relativeLayout21, SwitchCompat switchCompat22, CircularProgressIndicator circularProgressIndicator23, TextView textView24, TextView textView25, RelativeLayout relativeLayout26, RelativeLayout relativeLayout27, ScrollView scrollView28, RelativeLayout relativeLayout29, RelativeLayout relativeLayout30, RelativeLayout relativeLayout31, MaterialToolbar materialToolbar32, TextView textView33) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = relativeLayout4;
        obj.P = relativeLayout5;
        obj.Q = relativeLayout7;
        obj.R = relativeLayout8;
        obj.S = relativeLayout9;
        obj.T = relativeLayout10;
        obj.U = relativeLayout12;
        obj.V = frameLayout13;
        obj.W = relativeLayout14;
        obj.X = relativeLayout15;
        obj.Y = relativeLayout16;
        obj.Z = relativeLayout17;
        obj.a0 = linearLayout18;
        obj.b0 = relativeLayout19;
        obj.c0 = relativeLayout20;
        obj.d0 = relativeLayout21;
        obj.e0 = switchCompat22;
        obj.f0 = circularProgressIndicator23;
        obj.g0 = textView24;
        obj.h0 = relativeLayout26;
        obj.i0 = relativeLayout27;
        obj.j0 = relativeLayout29;
        obj.k0 = relativeLayout30;
        obj.l0 = relativeLayout31;
        obj.m0 = textView33;
    }

    public static app.dogo.com.dogo_android.h.kg T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return kg.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.kg U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (kg)ViewDataBinding.z(layoutInflater, 2131558712, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b0 b0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l l);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(f0 f0);
}

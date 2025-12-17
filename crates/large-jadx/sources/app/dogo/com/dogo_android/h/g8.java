package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.g.f.d0;
import app.dogo.com.dogo_android.util.e0.a0;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class g8 extends ViewDataBinding {

    public final View O;
    public final ImageView P;
    public final CheckBox Q;
    public final FrameLayout R;
    public final View S;
    public final app.dogo.com.dogo_android.h.o0 T;
    public final app.dogo.com.dogo_android.h.o0 U;
    public final app.dogo.com.dogo_android.h.o0 V;
    public final ScrollView W;
    public final FrameLayout X;
    public final MaterialToolbar Y;
    public final app.dogo.com.dogo_android.h.um Z;
    protected d0 a0;
    protected a0 b0;
    protected g8(Object object, View view2, int i3, View view4, ImageView imageView5, CheckBox checkBox6, FrameLayout frameLayout7, View view8, app.dogo.com.dogo_android.h.o0 o09, app.dogo.com.dogo_android.h.o0 o010, app.dogo.com.dogo_android.h.o0 o011, ScrollView scrollView12, FrameLayout frameLayout13, MaterialToolbar materialToolbar14, app.dogo.com.dogo_android.h.um um15) {
        super(object, view2, i3);
        this.O = view4;
        this.P = imageView5;
        this.Q = checkBox6;
        this.R = frameLayout7;
        this.S = view8;
        this.T = o09;
        this.U = o010;
        this.V = o011;
        this.W = scrollView12;
        this.X = frameLayout13;
        this.Y = materialToolbar14;
        this.Z = um15;
    }

    public static app.dogo.com.dogo_android.h.g8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return g8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.g8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (g8)ViewDataBinding.z(layoutInflater, 2131558591, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(d0 d0);
}

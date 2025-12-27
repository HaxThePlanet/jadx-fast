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

/* compiled from: DialogChallengeDetailsBinding.java */
/* loaded from: classes.dex */
public abstract class g8 extends ViewDataBinding {

    public final View O;
    public final ImageView P;
    public final CheckBox Q;
    public final FrameLayout R;
    public final View S;
    public final o0 T;
    public final o0 U;
    public final o0 V;
    public final ScrollView W;
    public final FrameLayout X;
    public final MaterialToolbar Y;
    public final um Z;
    protected d0 a0;
    protected a0 b0;
    protected g8(Object object, View view, int i, View view2, ImageView imageView, CheckBox checkBox, FrameLayout frameLayout, View view3, o0 o0Var, o0 o0Var2, o0 o0Var3, ScrollView scrollView, FrameLayout frameLayout2, MaterialToolbar materialToolbar, um umVar) {
        super(object, view, i);
        this.O = view2;
        this.P = imageView;
        this.Q = checkBox;
        this.R = frameLayout;
        this.S = view3;
        this.T = o0Var;
        this.U = o0Var2;
        this.V = o0Var3;
        this.W = scrollView;
        this.X = frameLayout2;
        this.Y = materialToolbar;
        this.Z = umVar;
    }

    public static g8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return g8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static g8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (g8)ViewDataBinding.z(layoutInflater, 2131558591, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(d0 d0Var);
}

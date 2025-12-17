package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.g.f.f0;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public abstract class m8 extends ViewDataBinding {

    public final AppCompatCheckBox O;
    public final AppCompatCheckBox P;
    public final RelativeLayout Q;
    public final RelativeLayout R;
    protected f0 S;
    protected a0 T;
    protected m8(Object object, View view2, int i3, AppCompatCheckBox appCompatCheckBox4, AppCompatCheckBox appCompatCheckBox5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7) {
        super(object, view2, i3);
        this.O = appCompatCheckBox4;
        this.P = appCompatCheckBox5;
        this.Q = relativeLayout6;
        this.R = relativeLayout7;
    }

    public static app.dogo.com.dogo_android.h.m8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return m8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.m8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (m8)ViewDataBinding.z(layoutInflater, 2131558594, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(f0 f0);
}

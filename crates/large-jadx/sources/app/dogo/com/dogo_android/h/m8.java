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

/* compiled from: DialogChallengeFilterBinding.java */
/* loaded from: classes.dex */
public abstract class m8 extends ViewDataBinding {

    public final AppCompatCheckBox O;
    public final AppCompatCheckBox P;
    public final RelativeLayout Q;
    public final RelativeLayout R;
    protected f0 S;
    protected a0 T;
    protected m8(Object object, View view, int i, AppCompatCheckBox appCompatCheckBox, AppCompatCheckBox appCompatCheckBox2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
        super(object, view, i);
        this.O = appCompatCheckBox;
        this.P = appCompatCheckBox2;
        this.Q = relativeLayout;
        this.R = relativeLayout2;
    }

    public static m8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static m8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (m8)ViewDataBinding.z(layoutInflater, 2131558594, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(f0 f0Var);
}

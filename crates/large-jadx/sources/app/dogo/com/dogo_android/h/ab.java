package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.h0;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class ab extends ViewDataBinding {

    public final LinearLayout O;
    public final MaterialToolbar P;
    protected ab(Object object, View view2, int i3, LinearLayout linearLayout4, MaterialToolbar materialToolbar5) {
        super(object, view2, i3);
        this.O = linearLayout4;
        this.P = materialToolbar5;
    }

    public static app.dogo.com.dogo_android.h.ab T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ab.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ab U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ab)ViewDataBinding.z(layoutInflater, 2131558641, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h0 h0);
}

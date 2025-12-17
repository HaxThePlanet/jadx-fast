package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.dogcreation.j.n;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class gb extends ViewDataBinding {

    public final TextView O;
    public final Button P;
    public final TextView Q;
    public final MaterialToolbar R;
    public final TextView S;
    protected n T;
    protected g U;
    protected gb(Object object, View view2, int i3, TextView textView4, Button button5, TextView textView6, MaterialToolbar materialToolbar7, TextView textView8) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = button5;
        this.Q = textView6;
        this.R = materialToolbar7;
        this.S = textView8;
    }

    public static app.dogo.com.dogo_android.h.gb T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return gb.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.gb U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (gb)ViewDataBinding.z(layoutInflater, 2131558644, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(n n);
}

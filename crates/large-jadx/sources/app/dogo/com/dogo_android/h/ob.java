package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class ob extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.ge O;
    public final MaterialToolbar P;
    public final TextView Q;
    protected b0 R;
    protected c0 S;
    protected ob(Object object, View view2, int i3, app.dogo.com.dogo_android.h.ge ge4, MaterialToolbar materialToolbar5, TextView textView6) {
        super(object, view2, i3);
        this.O = ge4;
        this.P = materialToolbar5;
        this.Q = textView6;
    }

    public static app.dogo.com.dogo_android.h.ob T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ob.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ob U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ob)ViewDataBinding.z(layoutInflater, 2131558648, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0);
}

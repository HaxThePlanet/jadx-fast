package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class ub extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.ie O;
    public final MaterialToolbar P;
    protected b0 Q;
    protected c0 R;
    protected ub(Object object, View view2, int i3, app.dogo.com.dogo_android.h.ie ie4, MaterialToolbar materialToolbar5) {
        super(object, view2, i3);
        this.O = ie4;
        this.P = materialToolbar5;
    }

    public static app.dogo.com.dogo_android.h.ub T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ub.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ub U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ub)ViewDataBinding.z(layoutInflater, 2131558651, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0);
}

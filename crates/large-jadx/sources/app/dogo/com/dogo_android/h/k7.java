package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* loaded from: classes.dex */
public abstract class k7 extends ViewDataBinding {

    public final View O;
    protected TrickItem P;
    protected k7(Object object, View view2, int i3, View view4) {
        super(object, view2, i3);
        this.O = view4;
    }

    public static app.dogo.com.dogo_android.h.k7 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return k7.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.k7 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (k7)ViewDataBinding.z(layoutInflater, 2131558555, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}

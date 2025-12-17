package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;

/* loaded from: classes.dex */
public abstract class q3 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected PermissionDescription Q;
    protected q3(Object object, View view2, int i3, TextView textView4, TextView textView5) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.q3 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return q3.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.q3 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (q3)ViewDataBinding.z(layoutInflater, 2131558506, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(PermissionDescription permissionDescription);
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;

/* compiled from: CellPermissionExplanationBinding.java */
/* loaded from: classes.dex */
public abstract class q3 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected PermissionDescription Q;
    protected q3(Object object, View view, int i, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
    }

    public static q3 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q3.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q3)ViewDataBinding.z(layoutInflater, 2131558506, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(PermissionDescription permissionDescription);
}

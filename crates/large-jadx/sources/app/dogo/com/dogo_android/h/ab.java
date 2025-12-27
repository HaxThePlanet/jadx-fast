package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.i.h0;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDebugDataDialogBinding.java */
/* loaded from: classes.dex */
public abstract class ab extends ViewDataBinding {

    public final LinearLayout O;
    public final MaterialToolbar P;
    protected ab(Object object, View view, int i, LinearLayout linearLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = linearLayout;
        this.P = materialToolbar;
    }

    public static ab T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ab.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ab U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ab)ViewDataBinding.z(layoutInflater, 2131558641, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h0 h0Var);
}

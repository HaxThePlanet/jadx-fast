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

/* compiled from: FragmentDogCreationLoginProvidersBinding.java */
/* loaded from: classes.dex */
public abstract class ob extends ViewDataBinding {

    public final ge O;
    public final MaterialToolbar P;
    public final TextView Q;
    protected b0 R;
    protected c0 S;
    protected ob(Object object, View view, int i, ge geVar, MaterialToolbar materialToolbar, TextView textView) {
        super(object, view, i);
        this.O = geVar;
        this.P = materialToolbar;
        this.Q = textView;
    }

    public static ob T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ob.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ob U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ob)ViewDataBinding.z(layoutInflater, 2131558648, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0 c0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0Var);
}

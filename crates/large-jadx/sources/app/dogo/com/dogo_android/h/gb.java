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

/* compiled from: FragmentDogCreationBreedBinding.java */
/* loaded from: classes.dex */
public abstract class gb extends ViewDataBinding {

    public final TextView O;
    public final Button P;
    public final TextView Q;
    public final MaterialToolbar R;
    public final TextView S;
    protected n T;
    protected g U;
    protected gb(Object object, View view, int i, TextView textView, Button button, TextView textView2, MaterialToolbar materialToolbar, TextView textView3) {
        super(object, view, i);
        this.O = textView;
        this.P = button;
        this.Q = textView2;
        this.R = materialToolbar;
        this.S = textView3;
    }

    public static gb T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return gb.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static gb U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (gb)ViewDataBinding.z(layoutInflater, 2131558644, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g gVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(n nVar);
}

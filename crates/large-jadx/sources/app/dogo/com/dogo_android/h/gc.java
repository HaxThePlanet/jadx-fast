package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.q.p.e0;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDogEditNameBinding.java */
/* loaded from: classes.dex */
public abstract class gc extends ViewDataBinding {

    public final EditText O;
    public final Button P;
    public final MaterialToolbar Q;
    protected e0 R;
    protected gc(Object object, View view, int i, EditText editText, Button button, TextView textView, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = editText;
        this.P = button;
        this.Q = materialToolbar;
    }

    public static gc T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return gc.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static gc U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (gc)ViewDataBinding.z(layoutInflater, 2131558657, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e0 e0Var);
}

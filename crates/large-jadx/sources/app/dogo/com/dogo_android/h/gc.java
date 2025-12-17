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

/* loaded from: classes.dex */
public abstract class gc extends ViewDataBinding {

    public final EditText O;
    public final Button P;
    public final MaterialToolbar Q;
    protected e0 R;
    protected gc(Object object, View view2, int i3, EditText editText4, Button button5, TextView textView6, MaterialToolbar materialToolbar7) {
        super(object, view2, i3);
        this.O = editText4;
        this.P = button5;
        this.Q = materialToolbar7;
    }

    public static app.dogo.com.dogo_android.h.gc T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return gc.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.gc U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (gc)ViewDataBinding.z(layoutInflater, 2131558657, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e0 e0);
}

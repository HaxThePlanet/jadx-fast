package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.dogcreation.m.e;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class qb extends ViewDataBinding {

    public final EditText O;
    public final Button P;
    public final MaterialToolbar Q;
    protected e R;
    protected qb(Object object, View view2, int i3, EditText editText4, Button button5, TextView textView6, MaterialToolbar materialToolbar7) {
        super(object, view2, i3);
        this.O = editText4;
        this.P = button5;
        this.Q = materialToolbar7;
    }

    public static app.dogo.com.dogo_android.h.qb T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return qb.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.qb U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (qb)ViewDataBinding.z(layoutInflater, 2131558649, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}

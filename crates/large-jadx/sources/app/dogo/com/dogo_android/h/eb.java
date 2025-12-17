package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.dogcreation.i.f;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class eb extends ViewDataBinding {

    public final DatePicker O;
    public final Button P;
    public final TextView Q;
    public final MaterialToolbar R;
    public final TextView S;
    protected f T;
    protected eb(Object object, View view2, int i3, DatePicker datePicker4, Button button5, TextView textView6, MaterialToolbar materialToolbar7, TextView textView8) {
        super(object, view2, i3);
        this.O = datePicker4;
        this.P = button5;
        this.Q = textView6;
        this.R = materialToolbar7;
        this.S = textView8;
    }

    public static app.dogo.com.dogo_android.h.eb T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return eb.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.eb U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (eb)ViewDataBinding.z(layoutInflater, 2131558643, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(f f);
}

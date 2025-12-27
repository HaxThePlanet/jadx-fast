package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDogCreationBirthdayBinding.java */
/* loaded from: classes.dex */
public abstract class eb extends ViewDataBinding {

    public final DatePicker O;
    public final Button P;
    public final TextView Q;
    public final MaterialToolbar R;
    public final TextView S;
    protected app.dogo.com.dogo_android.dogcreation.i.f T;
    protected eb(Object object, View view, int i, DatePicker datePicker, Button button, TextView textView, MaterialToolbar materialToolbar, TextView textView2) {
        super(object, view, i);
        this.O = datePicker;
        this.P = button;
        this.Q = textView;
        this.R = materialToolbar;
        this.S = textView2;
    }

    public static eb T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return eb.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static eb U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (eb)ViewDataBinding.z(layoutInflater, 2131558643, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(app.dogo.com.dogo_android.dogcreation.i.f fVar);
}

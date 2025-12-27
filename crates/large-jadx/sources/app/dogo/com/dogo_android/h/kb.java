package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDogCreationGenderBinding.java */
/* loaded from: classes.dex */
public abstract class kb extends ViewDataBinding {

    public final NumberPicker O;
    public final Button P;
    public final TextView Q;
    public final MaterialToolbar R;
    public final TextView S;
    protected app.dogo.com.dogo_android.dogcreation.k.f T;
    protected kb(Object object, View view, int i, NumberPicker numberPicker, Button button, TextView textView, MaterialToolbar materialToolbar, TextView textView2) {
        super(object, view, i);
        this.O = numberPicker;
        this.P = button;
        this.Q = textView;
        this.R = materialToolbar;
        this.S = textView2;
    }

    public static kb T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return kb.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static kb U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (kb)ViewDataBinding.z(layoutInflater, 2131558646, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(app.dogo.com.dogo_android.dogcreation.k.f fVar);
}

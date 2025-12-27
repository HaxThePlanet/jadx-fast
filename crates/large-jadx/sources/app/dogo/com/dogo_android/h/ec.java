package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.q.p.b0;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDogEditGenderBinding.java */
/* loaded from: classes.dex */
public abstract class ec extends ViewDataBinding {

    public final NumberPicker O;
    public final Button P;
    public final TextView Q;
    public final MaterialToolbar R;
    protected String S;
    protected b0 T;
    protected ec(Object object, View view, int i, NumberPicker numberPicker, Button button, TextView textView, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = numberPicker;
        this.P = button;
        this.Q = textView;
        this.R = materialToolbar;
    }

    public static ec T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ec.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ec U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ec)ViewDataBinding.z(layoutInflater, 2131558656, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(b0 b0Var);
}

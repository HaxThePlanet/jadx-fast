package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.q.p.r;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDogEditBirthdayBinding.java */
/* loaded from: classes.dex */
public abstract class ac extends ViewDataBinding {

    public final DatePicker O;
    public final Button P;
    public final TextView Q;
    public final MaterialToolbar R;
    protected String S;
    protected r T;
    protected ac(Object object, View view, int i, DatePicker datePicker, Button button, TextView textView, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = datePicker;
        this.P = button;
        this.Q = textView;
        this.R = materialToolbar;
    }

    public static ac T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ac.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ac U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ac)ViewDataBinding.z(layoutInflater, 2131558654, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(r rVar);
}

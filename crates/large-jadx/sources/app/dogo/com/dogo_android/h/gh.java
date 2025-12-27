package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.q.r.d;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: FragmentUserInformationBinding.java */
/* loaded from: classes.dex */
public abstract class gh extends ViewDataBinding {

    public final TextInputEditText O;
    public final TextInputEditText P;
    public final Button Q;
    public final MaterialToolbar R;
    protected d S;
    protected gh(Object object, View view, int i, TextInputEditText textInputEditText, TextView textView, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, TextInputEditText textInputEditText2, TextView textView2, Button button, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = textInputEditText;
        this.P = textInputEditText2;
        this.Q = button;
        this.R = materialToolbar;
    }

    public static gh T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return gh.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static gh U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (gh)ViewDataBinding.z(layoutInflater, 2131558723, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d dVar);
}

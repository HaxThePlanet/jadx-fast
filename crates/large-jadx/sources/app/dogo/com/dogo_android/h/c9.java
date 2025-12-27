package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.d;

/* compiled from: DialogInAppRateBinding.java */
/* loaded from: classes.dex */
public abstract class c9 extends ViewDataBinding {

    public final Button O;
    public final Button P;
    protected d Q;
    protected c9(Object object, View view, int i, Button button, TextView textView, Button button2, TextView textView2) {
        super(object, view, i);
        this.O = button;
        this.P = button2;
    }

    public static c9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return c9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static c9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (c9)ViewDataBinding.z(layoutInflater, 2131558603, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d dVar);
}

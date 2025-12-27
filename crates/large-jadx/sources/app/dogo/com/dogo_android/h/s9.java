package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.e;

/* compiled from: DialogSharePromptBinding.java */
/* loaded from: classes.dex */
public abstract class s9 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final Button Q;
    protected e R;
    protected s9(Object object, View view, int i, Button button, TextView textView, Button button2) {
        super(object, view, i);
        this.O = button;
        this.P = textView;
        this.Q = button2;
    }

    public static s9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return s9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static s9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (s9)ViewDataBinding.z(layoutInflater, 2131558612, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e eVar);
}

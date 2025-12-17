package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.e0.e;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class eg extends ViewDataBinding {

    public final TextView O;
    public final MaterialButton P;
    public final TextView Q;
    public final TextView R;
    public final ImageView S;
    protected e T;
    protected eg(Object object, View view2, int i3, TextView textView4, TextView textView5, ImageView imageView6, MaterialButton materialButton7, TextView textView8, TextView textView9, TextView textView10, ImageView imageView11) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = materialButton7;
        this.Q = textView8;
        this.R = textView9;
        this.S = imageView11;
    }

    public static app.dogo.com.dogo_android.h.eg T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return eg.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.eg U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (eg)ViewDataBinding.z(layoutInflater, 2131558709, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}

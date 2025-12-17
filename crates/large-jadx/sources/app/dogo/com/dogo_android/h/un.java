package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class un extends ViewDataBinding {

    public final MaterialButton O;
    public final TextView P;
    protected un(Object object, View view2, int i3, MaterialButton materialButton4, TextView textView5, TextView textView6) {
        super(object, view2, i3);
        this.O = materialButton4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.un T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return un.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.un U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (un)ViewDataBinding.z(layoutInflater, 2131558929, viewGroup2, z3, object4);
    }
}

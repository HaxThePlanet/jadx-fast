package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class sn extends ViewDataBinding {

    public final MaterialButton O;
    protected sn(Object object, View view2, int i3, MaterialButton materialButton4, TextView textView5) {
        super(object, view2, i3);
        this.O = materialButton4;
    }

    public static app.dogo.com.dogo_android.h.sn T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return sn.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.sn U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (sn)ViewDataBinding.z(layoutInflater, 2131558928, viewGroup2, z3, object4);
    }
}

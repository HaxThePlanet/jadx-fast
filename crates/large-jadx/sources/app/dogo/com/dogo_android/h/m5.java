package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class m5 extends ViewDataBinding {

    public final ConstraintLayout O;
    protected m5(Object object, View view2, int i3, ConstraintLayout constraintLayout4, TextView textView5) {
        super(object, view2, i3);
        this.O = constraintLayout4;
    }

    public static app.dogo.com.dogo_android.h.m5 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return m5.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.m5 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (m5)ViewDataBinding.z(layoutInflater, 2131558530, viewGroup2, z3, object4);
    }
}

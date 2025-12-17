package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class ma extends ViewDataBinding {

    public final ConstraintLayout O;
    public final MaterialToolbar P;
    protected ma(Object object, View view2, int i3, ConstraintLayout constraintLayout4, TextView textView5, MaterialToolbar materialToolbar6) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = materialToolbar6;
    }

    public static app.dogo.com.dogo_android.h.ma T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ma.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ma U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ma)ViewDataBinding.z(layoutInflater, 2131558634, viewGroup2, z3, object4);
    }
}

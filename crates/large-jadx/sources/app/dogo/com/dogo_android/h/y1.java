package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class y1 extends ViewDataBinding {
    protected y1(Object object, View view2, int i3) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.y1 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return y1.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.y1 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (y1)ViewDataBinding.z(layoutInflater, 2131558483, viewGroup2, z3, object4);
    }
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class o4 extends ViewDataBinding {
    protected o4(Object object, View view2, int i3, TextView textView4, TextView textView5) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.o4 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return o4.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.o4 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (o4)ViewDataBinding.z(layoutInflater, 2131558518, viewGroup2, z3, object4);
    }
}

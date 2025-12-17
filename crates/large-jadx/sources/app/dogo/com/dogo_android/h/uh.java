package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.u.h;

/* loaded from: classes.dex */
public abstract class uh extends ViewDataBinding {

    protected h O;
    protected uh(Object object, View view2, int i3, TextView textView4) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.uh T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return uh.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.uh U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (uh)ViewDataBinding.z(layoutInflater, 2131558739, viewGroup2, z3, object4);
    }
}

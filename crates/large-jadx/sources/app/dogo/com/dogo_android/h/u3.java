package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class u3 extends ViewDataBinding {
    protected u3(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, TextView textView5, AppCompatImageView appCompatImageView6) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.u3 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return u3.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.u3 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (u3)ViewDataBinding.z(layoutInflater, 2131558508, viewGroup2, z3, object4);
    }
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class a7 extends ViewDataBinding {

    public final TextView O;
    protected a7(Object object, View view2, int i3, TextView textView4) {
        super(object, view2, i3);
        this.O = textView4;
    }

    public static app.dogo.com.dogo_android.h.a7 T(LayoutInflater layoutInflater) {
        return a7.U(layoutInflater, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.a7 U(LayoutInflater layoutInflater, Object object2) {
        return (a7)ViewDataBinding.z(layoutInflater, 2131558550, 0, false, object2);
    }
}

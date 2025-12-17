package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class y6 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    protected y6(Object object, View view2, int i3, Button button4, TextView textView5) {
        super(object, view2, i3);
        this.O = button4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.y6 T(LayoutInflater layoutInflater) {
        return y6.U(layoutInflater, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.y6 U(LayoutInflater layoutInflater, Object object2) {
        return (y6)ViewDataBinding.z(layoutInflater, 2131558549, 0, false, object2);
    }
}

package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellSimpleButtonBinding.java */
/* loaded from: classes.dex */
public abstract class y6 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    protected y6(Object object, View view, int i, Button button, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = textView;
    }

    public static y6 T(LayoutInflater layoutInflater) {
        return y6.U(layoutInflater, f.e());
    }

    @Deprecated
    public static y6 U(LayoutInflater layoutInflater, Object object) {
        return (y6)ViewDataBinding.z(layoutInflater, 2131558549, null, false, object);
    }
}

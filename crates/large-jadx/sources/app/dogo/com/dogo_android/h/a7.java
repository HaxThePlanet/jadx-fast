package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellSimpleTextBinding.java */
/* loaded from: classes.dex */
public abstract class a7 extends ViewDataBinding {

    public final TextView O;
    protected a7(Object object, View view, int i, TextView textView) {
        super(object, view, i);
        this.O = textView;
    }

    public static a7 T(LayoutInflater layoutInflater) {
        return a7.U(layoutInflater, f.e());
    }

    @Deprecated
    public static a7 U(LayoutInflater layoutInflater, Object object) {
        return (a7)ViewDataBinding.z(layoutInflater, 2131558550, null, false, object);
    }
}

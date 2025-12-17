package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class ai extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected ai(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, TextView textView5, TextView textView6) {
        super(object, view2, i3);
        this.O = textView5;
        this.P = textView6;
    }

    public static app.dogo.com.dogo_android.h.ai T(LayoutInflater layoutInflater) {
        return ai.U(layoutInflater, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ai U(LayoutInflater layoutInflater, Object object2) {
        return (ai)ViewDataBinding.z(layoutInflater, 2131558742, 0, false, object2);
    }
}

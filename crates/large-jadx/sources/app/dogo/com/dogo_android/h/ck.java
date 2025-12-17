package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.service.v2.b;

/* loaded from: classes.dex */
public abstract class ck extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final TextView Q;
    protected v2.b R;
    protected Long S;
    protected ck(Object object, View view2, int i3, TextView textView4, TextView textView5, TextView textView6) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView5;
        this.Q = textView6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Long long);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(v2.b v2$b);
}

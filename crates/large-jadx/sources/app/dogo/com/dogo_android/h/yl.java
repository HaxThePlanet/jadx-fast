package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes.dex */
public abstract class yl extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected String Q;
    protected String R;
    protected String S;
    protected yl(Object object, View view2, int i3, TextView textView4, TextView textView5) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView5;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(String string);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(String string);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String string);
}

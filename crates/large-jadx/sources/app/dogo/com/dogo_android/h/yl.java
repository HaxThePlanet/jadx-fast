package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* compiled from: LayoutProfileDataRowBinding.java */
/* loaded from: classes.dex */
public abstract class yl extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected String Q;
    protected String R;
    protected String S;
    protected yl(Object object, View view, int i, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}

package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.login_v2.b0;

/* loaded from: classes.dex */
public abstract class k extends ViewDataBinding {

    public final TextView O;
    protected b0 P;
    protected k(Object object, View view2, int i3, ProgressBar progressBar4, TextView textView5) {
        super(object, view2, i3);
        this.O = textView5;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(b0 b0);
}

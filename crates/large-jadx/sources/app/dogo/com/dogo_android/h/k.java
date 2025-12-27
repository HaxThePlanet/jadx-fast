package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.login_v2.b0;

/* compiled from: ActivityLoginStateBinding.java */
/* loaded from: classes.dex */
public abstract class k extends ViewDataBinding {

    public final TextView O;
    protected b0 P;
    protected k(Object object, View view, int i, ProgressBar progressBar, TextView textView) {
        super(object, view, i);
        this.O = textView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(b0 b0Var);
}

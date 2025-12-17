package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.util.g0.a;

/* loaded from: classes.dex */
public abstract class gi extends ViewDataBinding {

    public final Button O;
    protected a P;
    protected gi(Object object, View view2, int i3, Button button4) {
        super(object, view2, i3);
        this.O = button4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(a a);
}

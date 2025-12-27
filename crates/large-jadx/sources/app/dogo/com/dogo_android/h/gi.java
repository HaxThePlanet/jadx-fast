package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.util.g0.a;

/* compiled from: LayoutCustomFabBinding.java */
/* loaded from: classes.dex */
public abstract class gi extends ViewDataBinding {

    public final Button O;
    protected a P;
    protected gi(Object object, View view, int i, Button button) {
        super(object, view, i);
        this.O = button;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(a aVar);
}

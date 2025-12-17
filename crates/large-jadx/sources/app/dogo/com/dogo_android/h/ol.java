package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextSwitcher;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes.dex */
public abstract class ol extends ViewDataBinding {

    public final TextSwitcher O;
    protected Integer P;
    protected ol(Object object, View view2, int i3, TextSwitcher textSwitcher4) {
        super(object, view2, i3);
        this.O = textSwitcher4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public Integer T() {
        return this.P;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(Integer integer);
}

package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextSwitcher;
import androidx.databinding.ViewDataBinding;

/* compiled from: LayoutMonthTextSwitcherBinding.java */
/* loaded from: classes.dex */
public abstract class ol extends ViewDataBinding {

    public final TextSwitcher O;
    protected Integer P;
    protected ol(Object object, View view, int i, TextSwitcher textSwitcher) {
        super(object, view, i);
        this.O = textSwitcher;
    }

    @Override // androidx.databinding.ViewDataBinding
    public Integer T() {
        return this.P;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(Integer integer);
}

package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.service.v2.b;

/* compiled from: LayoutDiscountTimerSquareSegmentBinding.java */
/* loaded from: classes.dex */
public abstract class mk extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final TextView Q;
    protected v2.b R;
    protected Long S;
    protected mk(Object object, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
        this.Q = textView3;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Long long);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(v2.b bVar);
}

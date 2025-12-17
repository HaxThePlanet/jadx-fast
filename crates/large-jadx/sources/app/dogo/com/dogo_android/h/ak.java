package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;

/* loaded from: classes.dex */
public abstract class ak extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.ck O;
    public final app.dogo.com.dogo_android.h.ck P;
    public final app.dogo.com.dogo_android.h.ck Q;
    public final app.dogo.com.dogo_android.h.ck R;
    protected CouponTimer S;
    protected ak(Object object, View view2, int i3, app.dogo.com.dogo_android.h.ck ck4, app.dogo.com.dogo_android.h.ck ck5, app.dogo.com.dogo_android.h.ck ck6, app.dogo.com.dogo_android.h.ck ck7) {
        super(object, view2, i3);
        this.O = ck4;
        this.P = ck5;
        this.Q = ck6;
        this.R = ck7;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(CouponTimer couponTimer);
}

package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;

/* loaded from: classes.dex */
public abstract class kk extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.mk O;
    public final app.dogo.com.dogo_android.h.mk P;
    public final app.dogo.com.dogo_android.h.mk Q;
    public final app.dogo.com.dogo_android.h.mk R;
    protected CouponTimer S;
    protected kk(Object object, View view2, int i3, app.dogo.com.dogo_android.h.mk mk4, app.dogo.com.dogo_android.h.mk mk5, app.dogo.com.dogo_android.h.mk mk6, app.dogo.com.dogo_android.h.mk mk7) {
        super(object, view2, i3);
        this.O = mk4;
        this.P = mk5;
        this.Q = mk6;
        this.R = mk7;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(CouponTimer couponTimer);
}

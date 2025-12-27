package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;

/* compiled from: LayoutDashboardTimerBinding.java */
/* loaded from: classes.dex */
public abstract class ak extends ViewDataBinding {

    public final ck O;
    public final ck P;
    public final ck Q;
    public final ck R;
    protected CouponTimer S;
    protected ak(Object object, View view, int i, ck ckVar, ck ckVar2, ck ckVar3, ck ckVar4) {
        super(object, view, i);
        this.O = ckVar;
        this.P = ckVar2;
        this.Q = ckVar3;
        this.R = ckVar4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(CouponTimer couponTimer);
}

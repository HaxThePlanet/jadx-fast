package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;

/* compiled from: LayoutDiscountTimerBinding.java */
/* loaded from: classes.dex */
public abstract class kk extends ViewDataBinding {

    public final mk O;
    public final mk P;
    public final mk Q;
    public final mk R;
    protected CouponTimer S;
    protected kk(Object object, View view, int i, mk mkVar, mk mkVar2, mk mkVar3, mk mkVar4) {
        super(object, view, i);
        this.O = mkVar;
        this.P = mkVar2;
        this.Q = mkVar3;
        this.R = mkVar4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(CouponTimer couponTimer);
}

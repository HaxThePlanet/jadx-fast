package app.dogo.com.dogo_android.subscription.redeemcoupon;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class e implements n {

    public final app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel a;
    public e(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel redeemCodeViewModel) {
        super();
        this.a = redeemCodeViewModel;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return RedeemCodeViewModel.i(this.a, (CouponDiscount)object);
    }
}

package app.dogo.com.dogo_android.subscription.redeemcoupon;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class d implements n {

    public final app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel a;
    public final String b;
    public d(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel redeemCodeViewModel, String string2) {
        super();
        this.a = redeemCodeViewModel;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return RedeemCodeViewModel.h(this.a, this.b, (Boolean)object);
    }
}

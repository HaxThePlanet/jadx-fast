package app.dogo.com.dogo_android.subscription.redeemcoupon;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements n {

    public final /* synthetic */ RedeemCodeViewModel a;
    public /* synthetic */ e(RedeemCodeViewModel redeemCodeViewModel) {
        super();
        this.a = redeemCodeViewModel;
    }

    public final Object apply(Object object) {
        return RedeemCodeViewModel.tryToValidateAndSaveDiscount$lambda_1$lambda_0(this.a, object);
    }
}

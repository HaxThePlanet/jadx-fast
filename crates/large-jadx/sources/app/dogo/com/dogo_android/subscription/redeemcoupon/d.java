package app.dogo.com.dogo_android.subscription.redeemcoupon;

import i.b.l0.n;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements n {

    public final /* synthetic */ RedeemCodeViewModel a;
    public final /* synthetic */ String b;
    public /* synthetic */ d(RedeemCodeViewModel redeemCodeViewModel, String str) {
        super();
        this.a = redeemCodeViewModel;
        this.b = str;
    }

    public final Object apply(Object object) {
        return RedeemCodeViewModel.tryToValidateAndSaveDiscount$lambda_1(this.a, this.b, object);
    }
}

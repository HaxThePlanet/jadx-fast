package app.dogo.com.dogo_android.subscription.redeemcoupon;

import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class a implements y {

    public final app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog a;
    public a(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog redeemCodeDialog) {
        super();
        this.a = redeemCodeDialog;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        RedeemCodeDialog.B1(this.a, (Boolean)object);
    }
}

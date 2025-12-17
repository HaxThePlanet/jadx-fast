package app.dogo.com.dogo_android.subscription.redeemcoupon;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog a;
    public c(app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeDialog redeemCodeDialog) {
        super();
        this.a = redeemCodeDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        RedeemCodeDialog.D1(this.a, view);
    }
}

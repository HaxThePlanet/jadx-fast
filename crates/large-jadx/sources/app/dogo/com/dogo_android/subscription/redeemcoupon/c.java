package app.dogo.com.dogo_android.subscription.redeemcoupon;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final /* synthetic */ RedeemCodeDialog a;
    public /* synthetic */ c(RedeemCodeDialog redeemCodeDialog) {
        super();
        this.a = redeemCodeDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        RedeemCodeDialog.onViewCreated$lambda_2(this.a, view);
    }
}

package app.dogo.com.dogo_android.subscription.redeemcoupon;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final /* synthetic */ RedeemCodeDialog a;
    public /* synthetic */ b(RedeemCodeDialog redeemCodeDialog) {
        super();
        this.a = redeemCodeDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        RedeemCodeDialog.onViewCreated$lambda_1(this.a, view);
    }
}

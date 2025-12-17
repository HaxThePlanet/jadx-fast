package com.appsflyer.internal;

import com.android.billingclient.api.e;
import com.android.billingclient.api.g;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
final class au implements e {

    private com.appsflyer.internal.ax values;
    au(com.appsflyer.internal.ax ax) {
        this.values = ax;
        super();
    }

    @Override // com.android.billingclient.api.e
    public final void onBillingServiceDisconnected() {
    }

    @Override // com.android.billingclient.api.e
    public final void onBillingSetupFinished(g g) {
        final com.appsflyer.internal.ax values = this.values;
        ax.2 anon = new ax.2(values, g);
        values.AFKeystoreWrapper.submit(anon);
    }
}

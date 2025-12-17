package com.appsflyer.internal;

import android.content.Context;

/* loaded from: classes.dex */
public final class cj extends com.appsflyer.internal.ch {
    public cj(Context context) {
        super("af_purchase", Boolean.TRUE, context);
    }

    @Override // com.appsflyer.internal.ch
    public final com.appsflyer.internal.i values(String string) {
        return super.values(AFInAppEventType(string));
    }
}

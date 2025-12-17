package com.google.firebase.inappmessaging.internal;

import f.c.f.a.a.a.e.e;
import i.b.l0.a;

/* loaded from: classes2.dex */
public final class g implements a {

    public final com.google.firebase.inappmessaging.internal.CampaignCacheClient a;
    public final e b;
    public g(com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient, e e2) {
        super();
        this.a = campaignCacheClient;
        this.b = e2;
    }

    @Override // i.b.l0.a
    public final void run() {
        this.a.i(this.b);
    }
}

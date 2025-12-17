package com.google.firebase.inappmessaging.internal;

import i.b.l0.f;

/* loaded from: classes2.dex */
public final class h implements f {

    public final com.google.firebase.inappmessaging.internal.CampaignCacheClient a;
    public h(com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient) {
        super();
        this.a = campaignCacheClient;
    }

    @Override // i.b.l0.f
    public final void accept(Object object) {
        this.a.g((Throwable)object);
    }
}

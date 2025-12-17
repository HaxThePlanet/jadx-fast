package com.google.firebase.inappmessaging.internal;

import i.b.l0.o;

/* loaded from: classes2.dex */
public final class f implements o {

    public final com.google.firebase.inappmessaging.internal.CampaignCacheClient a;
    public f(com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient) {
        super();
        this.a = campaignCacheClient;
    }

    @Override // i.b.l0.o
    public final boolean test(Object object) {
        return CampaignCacheClient.a(this.a, (e)object);
    }
}

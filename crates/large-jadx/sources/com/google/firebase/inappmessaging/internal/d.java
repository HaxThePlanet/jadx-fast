package com.google.firebase.inappmessaging.internal;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class d implements Callable {

    public final com.google.firebase.inappmessaging.internal.CampaignCacheClient a;
    public d(com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient) {
        super();
        this.a = campaignCacheClient;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.c();
    }
}

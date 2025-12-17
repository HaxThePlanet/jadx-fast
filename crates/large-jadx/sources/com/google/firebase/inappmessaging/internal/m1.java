package com.google.firebase.inappmessaging.internal;

import i.b.l0.f;

/* loaded from: classes2.dex */
public final class m1 implements f {

    public final com.google.firebase.inappmessaging.internal.TestDeviceHelper a;
    public m1(com.google.firebase.inappmessaging.internal.TestDeviceHelper testDeviceHelper) {
        super();
        this.a = testDeviceHelper;
    }

    @Override // i.b.l0.f
    public final void accept(Object object) {
        this.a.processCampaignFetch((e)object);
    }
}

package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.g;
import i.b.m;

/* loaded from: classes2.dex */
public final class l1 implements g {

    public final m a;
    public l1(m m) {
        super();
        this.a = m;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        InAppMessageStreamManager.O(this.a, object);
    }
}

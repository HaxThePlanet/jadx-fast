package com.google.android.play.core.internal;

import android.os.IBinder.DeathRecipient;

/* loaded from: classes2.dex */
public final class j implements IBinder.DeathRecipient {

    public final com.google.android.play.core.internal.t a;
    public j(com.google.android.play.core.internal.t t) {
        super();
        this.a = t;
    }

    @Override // android.os.IBinder$DeathRecipient
    public final void binderDied() {
        t.i(this.a);
    }
}

package com.google.android.exoplayer2.util;

import android.os.Handler.Callback;
import android.os.Message;

/* loaded from: classes2.dex */
public final class b implements Handler.Callback {

    public final com.google.android.exoplayer2.util.u a;
    public b(com.google.android.exoplayer2.util.u u) {
        super();
        this.a = u;
    }

    @Override // android.os.Handler$Callback
    public final boolean handleMessage(Message message) {
        return u.e(this.a, message);
    }
}

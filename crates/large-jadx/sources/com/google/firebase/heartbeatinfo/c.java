package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class c implements Provider {

    public final Context a;
    public c(Context context) {
        super();
        this.a = context;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return DefaultHeartBeatInfo.d(this.a);
    }
}

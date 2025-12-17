package com.google.firebase.functions;

import android.content.Context;

/* loaded from: classes2.dex */
public final class h implements Runnable {

    public final Context a;
    public h(Context context) {
        super();
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseFunctions.e(this.a);
    }
}

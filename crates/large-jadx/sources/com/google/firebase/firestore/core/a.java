package com.google.firebase.firestore.core;

import android.app.Activity;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    public final Activity a;
    public final Runnable b;
    public a(Activity activity, Runnable runnable2) {
        super();
        this.a = activity;
        this.b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityScope.a(this.a, this.b);
    }
}

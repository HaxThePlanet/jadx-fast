package com.google.firebase.firestore.core;

import androidx.fragment.app.e;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final e a;
    public final Runnable b;
    public b(e e, Runnable runnable2) {
        super();
        this.a = e;
        this.b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityScope.b(this.a, this.b);
    }
}

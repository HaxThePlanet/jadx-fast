package com.google.android.play.core.splitinstall.g;

import com.google.android.play.core.splitinstall.d;

/* loaded from: classes2.dex */
public final class l implements Runnable {

    public final com.google.android.play.core.splitinstall.g.a a;
    public final d b;
    public l(com.google.android.play.core.splitinstall.g.a a, d d2) {
        super();
        this.a = a;
        this.b = d2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.i(this.b);
    }
}

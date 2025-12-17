package com.google.android.play.core.splitinstall.g;

import java.util.List;

/* loaded from: classes2.dex */
public final class m implements Runnable {

    public final com.google.android.play.core.splitinstall.g.a a;
    public final List b;
    public final List c;
    public m(com.google.android.play.core.splitinstall.g.a a, List list2, List list3) {
        super();
        this.a = a;
        this.b = list2;
        this.c = list3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.k(this.b, this.c);
    }
}

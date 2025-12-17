package com.google.android.play.core.splitinstall.g;

import java.util.List;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    public final com.google.android.play.core.splitinstall.g.a a;
    public final List b;
    public final List c;
    public final List v;
    public final long w;
    public f(com.google.android.play.core.splitinstall.g.a a, List list2, List list3, List list4, long l5) {
        super();
        this.a = a;
        this.b = list2;
        this.c = list3;
        this.v = list4;
        this.w = l5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.j(this.b, this.c, this.v, this.w);
    }
}

package com.google.android.play.core.splitinstall.g;

import java.util.List;

/* loaded from: classes2.dex */
public final class k implements Runnable {

    public final com.google.android.play.core.splitinstall.g.a a;
    public final long b;
    public final List c;
    public final List v;
    public final List w;
    public k(com.google.android.play.core.splitinstall.g.a a, long l2, List list3, List list4, List list5) {
        super();
        this.a = a;
        this.b = l2;
        this.c = list4;
        this.v = list5;
        this.w = obj6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h(this.b, obj2, this.c, this.v);
    }
}

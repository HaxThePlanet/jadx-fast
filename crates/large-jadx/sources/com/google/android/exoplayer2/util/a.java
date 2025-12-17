package com.google.android.exoplayer2.util;

import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    public final CopyOnWriteArraySet a;
    public final int b;
    public final com.google.android.exoplayer2.util.u.a c;
    public a(CopyOnWriteArraySet copyOnWriteArraySet, int i2, com.google.android.exoplayer2.util.u.a u$a3) {
        super();
        this.a = copyOnWriteArraySet;
        this.b = i2;
        this.c = a3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.f(this.a, this.b, this.c);
    }
}

package com.google.android.play.core.splitinstall;

/* loaded from: classes2.dex */
final class w0 implements Runnable {

    final com.google.android.play.core.splitinstall.d a;
    final int b;
    final int c;
    final com.google.android.play.core.splitinstall.x0 v;
    w0(com.google.android.play.core.splitinstall.x0 x0, com.google.android.play.core.splitinstall.d d2, int i3, int i4) {
        this.v = x0;
        this.a = d2;
        this.b = i3;
        this.c = i4;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        final com.google.android.play.core.splitinstall.d dVar = this.a;
        super(dVar.h(), this.b, this.c, dVar.a(), obj7, dVar.j(), obj9, dVar.l(), dVar.k(), dVar.g(), dVar.m());
        this.v.k(hVar2);
    }
}

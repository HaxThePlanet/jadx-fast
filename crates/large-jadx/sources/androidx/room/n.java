package androidx.room;

import d.s.a.j;

/* loaded from: classes.dex */
public final class n implements Runnable {

    public final androidx.room.o0 a;
    public final j b;
    public final androidx.room.r0 c;
    public n(androidx.room.o0 o0, j j2, androidx.room.r0 r03) {
        super();
        this.a = o0;
        this.b = j2;
        this.c = r03;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.r(this.b, this.c);
    }
}

package f.c.a.b.i.a0;

import f.c.a.b.h;
import f.c.a.b.i.j;
import f.c.a.b.i.p;

/* loaded from: classes.dex */
public final class a implements Runnable {

    public final f.c.a.b.i.a0.c a;
    public final p b;
    public final h c;
    public final j v;
    public a(f.c.a.b.i.a0.c c, p p2, h h3, j j4) {
        super();
        this.a = c;
        this.b = p2;
        this.c = h3;
        this.v = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e(this.b, this.c, this.v);
    }
}

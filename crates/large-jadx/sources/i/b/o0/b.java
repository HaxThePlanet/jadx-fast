package i.b.o0;

import i.b.j0.b;
import i.b.m0.j.i;
import i.b.y;

/* compiled from: DefaultObserver.java */
/* loaded from: classes3.dex */
public abstract class b<T> implements y<T> {

    private b a;
    public final void onSubscribe(b bVar) {
        if (i.d(this.a, bVar, getClass())) {
            this.a = bVar;
            a();
        }
    }

    protected void a() {
    }
}

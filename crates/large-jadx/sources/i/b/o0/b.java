package i.b.o0;

import i.b.j0.b;
import i.b.m0.j.i;
import i.b.y;

/* loaded from: classes3.dex */
public abstract class b<T>  implements y<T> {

    private b a;
    @Override // i.b.y
    protected void a() {
    }

    @Override // i.b.y
    public final void onSubscribe(b b) {
        if (i.d(this.a, b, getClass())) {
            this.a = b;
            a();
        }
    }
}

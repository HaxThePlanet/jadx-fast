package i.b.t0;

import i.b.r;
import i.b.y;

/* compiled from: Subject.java */
/* loaded from: classes3.dex */
public abstract class d<T> extends r<T> implements y<T> {
    @Override // i.b.r
    public final d<T> c() {
        if (this instanceof c) {
            return this;
        }
        return new c(this);
    }
}

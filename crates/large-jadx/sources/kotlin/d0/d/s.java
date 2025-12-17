package kotlin.d0.d;

import kotlin.i0.c;
import kotlin.i0.h.a;
import kotlin.i0.j;
import kotlin.i0.j.a;
import kotlin.i0.l.b;
import kotlin.i0.n;
import kotlin.i0.n.a;

/* loaded from: classes3.dex */
public abstract class s extends kotlin.d0.d.u implements j {
    public s(Object object, Class class2, String string3, String string4, int i5) {
        super(object, class2, string3, string4, i5);
    }

    @Override // kotlin.d0.d.u
    protected c computeReflected() {
        return c0.f(this);
    }

    @Override // kotlin.d0.d.u
    public l.b getGetter() {
        return getGetter();
    }

    @Override // kotlin.d0.d.u
    public n.a getGetter() {
        return (j)getReflected().getGetter();
    }

    @Override // kotlin.d0.d.u
    public h.a getSetter() {
        return getSetter();
    }

    @Override // kotlin.d0.d.u
    public j.a getSetter() {
        return (j)getReflected().getSetter();
    }

    @Override // kotlin.d0.d.u
    public Object invoke(Object object) {
        return get(object);
    }
}

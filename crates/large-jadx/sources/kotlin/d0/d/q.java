package kotlin.d0.d;

import kotlin.i0.c;
import kotlin.i0.h.a;
import kotlin.i0.i;
import kotlin.i0.i.a;
import kotlin.i0.l.b;
import kotlin.i0.m;
import kotlin.i0.m.a;

/* loaded from: classes3.dex */
public abstract class q extends kotlin.d0.d.u implements i {
    public q(Object object) {
        super(object);
    }

    public q(Object object, Class class2, String string3, String string4, int i5) {
        super(object, class2, string3, string4, i5);
    }

    @Override // kotlin.d0.d.u
    protected c computeReflected() {
        return c0.e(this);
    }

    @Override // kotlin.d0.d.u
    public Object getDelegate() {
        return (i)getReflected().getDelegate();
    }

    @Override // kotlin.d0.d.u
    public l.b getGetter() {
        return getGetter();
    }

    @Override // kotlin.d0.d.u
    public m.a getGetter() {
        return (i)getReflected().getGetter();
    }

    @Override // kotlin.d0.d.u
    public h.a getSetter() {
        return getSetter();
    }

    @Override // kotlin.d0.d.u
    public i.a getSetter() {
        return (i)getReflected().getSetter();
    }

    @Override // kotlin.d0.d.u
    public Object invoke() {
        return get();
    }
}

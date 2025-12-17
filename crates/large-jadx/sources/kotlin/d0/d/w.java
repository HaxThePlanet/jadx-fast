package kotlin.d0.d;

import kotlin.i0.c;
import kotlin.i0.l.b;
import kotlin.i0.n;
import kotlin.i0.n.a;

/* loaded from: classes3.dex */
public abstract class w extends kotlin.d0.d.y implements n {
    public w(Object object, Class class2, String string3, String string4, int i5) {
        super(object, class2, string3, string4, i5);
    }

    @Override // kotlin.d0.d.y
    protected c computeReflected() {
        return c0.g(this);
    }

    @Override // kotlin.d0.d.y
    public l.b getGetter() {
        return getGetter();
    }

    @Override // kotlin.d0.d.y
    public n.a getGetter() {
        return (n)getReflected().getGetter();
    }

    @Override // kotlin.d0.d.y
    public Object invoke(Object object) {
        return get(object);
    }
}

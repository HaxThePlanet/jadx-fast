package kotlin.d0.d;

import kotlin.i0.c;
import kotlin.i0.f;

/* loaded from: classes3.dex */
public class r extends kotlin.d0.d.q {
    public r(Class class, String string2, String string3, int i4) {
        super(c.NO_RECEIVER, class, string2, string3, i4);
    }

    public r(Object object, Class class2, String string3, String string4, int i5) {
        super(object, class2, string3, string4, i5);
    }

    public r(f f, String string2, String string3) {
        super(c.NO_RECEIVER, (d)f.d(), string2, string3, obj7 ^ 1);
    }

    @Override // kotlin.d0.d.q
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.d0.d.q
    public void set(Object object) {
        Object[] arr = new Object[1];
        getSetter().call(object);
    }
}

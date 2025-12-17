package kotlin.d0.d;

import kotlin.i0.c;
import kotlin.i0.f;

/* loaded from: classes3.dex */
public class t extends kotlin.d0.d.s {
    public t(f f, String string2, String string3) {
        super(c.NO_RECEIVER, (d)f.d(), string2, string3, obj7 ^ 1);
    }

    @Override // kotlin.d0.d.s
    public Object get(Object object) {
        Object[] arr = new Object[1];
        return getGetter().call(object);
    }

    @Override // kotlin.d0.d.s
    public void i(Object object, Object object2) {
        Object[] arr = new Object[2];
        getSetter().call(object, object2);
    }
}

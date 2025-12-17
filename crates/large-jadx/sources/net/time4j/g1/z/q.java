package net.time4j.g1.z;

import java.util.HashMap;
import java.util.Map;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
class q extends HashMap<p<?>, Object> {

    private static final long serialVersionUID = 1245025551222311435L;
    q(Map<? extends p<?>, ?> map) {
        super(map);
    }

    public Object a(p<?> p, Object object2) {
        Object obj3;
        final Object obj = super.put(p, object2);
        if (p != null && obj != null) {
            if (obj != null) {
                if (!obj.equals(object2)) {
                } else {
                }
                obj3 = new a(p);
                throw obj3;
            }
        }
        return obj;
    }

    @Override // java.util.HashMap
    public Object put(Object object, Object object2) {
        return a((p)object, object2);
    }
}

package net.time4j.g1.z;

import java.util.HashMap;
import java.util.Map;
import net.time4j.engine.p;

/* compiled from: NonAmbivalentMap.java */
/* loaded from: classes3.dex */
class q extends HashMap<p<?>, Object> {

    private static final long serialVersionUID = 1245025551222311435L;
    q(Map<? extends p<?>, ?> map) {
        super(map);
    }

    @Override // java.util.HashMap
    public Object a(p<?> pVar, Object object) throws a {
        final Object obj = super.put(pVar, object);
        return obj;
    }
}

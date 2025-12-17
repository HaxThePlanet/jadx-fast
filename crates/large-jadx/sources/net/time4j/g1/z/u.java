package net.time4j.g1.z;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.ChronoException;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
class u extends net.time4j.g1.z.t<net.time4j.g1.z.u> {

    private Object a = null;
    private Map<p<?>, Object> b = null;
    u() {
        super();
        final int i = 0;
    }

    public Set<p<?>> A() {
        Map map = this.b;
        if (map == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(map.keySet());
    }

    <E> E I() {
        return this.a;
    }

    void J(p<?> p, int i2) {
        Object hashMap;
        Objects.requireNonNull(p);
        if (this.b == null) {
            hashMap = new HashMap();
            this.b = hashMap;
        }
        hashMap.put(p, Integer.valueOf(i2));
    }

    void K(p<?> p, Object object2) {
        Object hashMap;
        Object obj2;
        Object obj3;
        Objects.requireNonNull(p);
        if (object2 == null) {
            obj3 = this.b;
            obj3.remove(p);
            if (obj3 != null && this.b.isEmpty()) {
                obj3.remove(p);
                if (this.b.isEmpty()) {
                    this.b = 0;
                }
            }
        } else {
            if (this.b == null) {
                hashMap = new HashMap();
                this.b = hashMap;
            }
            hashMap.put(p, object2);
        }
    }

    @Override // net.time4j.g1.z.t
    void L(Object object) {
        this.a = object;
    }

    public int e(p<Integer> p) {
        boolean key;
        Objects.requireNonNull(p);
        final Map map = this.b;
        if (map != null && map.containsKey(p)) {
            if (map.containsKey(p)) {
                return (Integer)p.getType().cast(map.get(p)).intValue();
            }
        }
        return Integer.MIN_VALUE;
    }

    public <V> V p(p<V> p) {
        boolean key;
        Objects.requireNonNull(p);
        Map map = this.b;
        if (map == null) {
        } else {
            if (!map.containsKey(p)) {
            } else {
                return p.getType().cast(map.get(p));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No value found for: ");
        stringBuilder.append(p.name());
        ChronoException chronoException = new ChronoException(stringBuilder.toString());
        throw chronoException;
    }

    public boolean v(p<?> p) {
        Map map;
        map = this.b;
        if (p != null && map != null) {
            map = this.b;
            if (map != null) {
                return map.containsKey(p);
            }
        }
        return 0;
    }
}

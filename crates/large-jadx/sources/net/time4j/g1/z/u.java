package net.time4j.g1.z;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.ChronoException;
import net.time4j.engine.p;

/* compiled from: ParsedValue.java */
/* loaded from: classes3.dex */
class u extends t<u> {

    private Object a = null;
    private Map<p<?>, Object> b = null;
    u() {
        super();
    }

    @Override // net.time4j.g1.z.t
    public Set<p<?>> A() {
        if (this.b == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(this.b.keySet());
    }

    @Override // net.time4j.g1.z.t
    <E> E I() {
        return this.a;
    }

    @Override // net.time4j.g1.z.t
    void J(p<?> pVar, int i) {
        Map map;
        Objects.requireNonNull(pVar);
        if (this.b == null) {
            this.b = new HashMap();
        }
        map.put(pVar, Integer.valueOf(i));
    }

    @Override // net.time4j.g1.z.t
    void K(p<?> pVar, Object object) {
        Map map;
        Objects.requireNonNull(pVar);
        if (object != null) {
            if (this.b == null) {
                this.b = new HashMap();
            }
            map.put(pVar, object);
        } else {
            if (this.b != null) {
                this.b.remove(pVar);
                if (this.b.isEmpty()) {
                    this.b = null;
                }
            }
        }
    }

    @Override // net.time4j.g1.z.t
    void L(Object object) {
        this.a = object;
    }

    @Override // net.time4j.g1.z.t
    public int e(p<Integer> pVar) {
        Objects.requireNonNull(pVar);
        if (this.b != null && this.b.containsKey(pVar)) {
            return (Integer)pVar.getType().cast(this.b.get(pVar)).intValue();
        }
        return -2147483648;
    }

    @Override // net.time4j.g1.z.t
    public <V> V p(p<V> pVar) throws ChronoException {
        Objects.requireNonNull(pVar);
        if (this.b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "No value found for: ";
            String name = pVar.name();
            pVar = str + name;
            throw new ChronoException(pVar);
        } else {
            if (this.b.containsKey(pVar)) {
                return pVar.getType().cast(this.b.get(pVar));
            }
        }
    }

    @Override // net.time4j.g1.z.t
    public boolean v(p<?> pVar) {
        if (pVar != null && this.b != null) {
            return this.b.containsKey(pVar);
        }
        return false;
    }
}

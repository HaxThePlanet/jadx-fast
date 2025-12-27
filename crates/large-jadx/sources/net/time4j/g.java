package net.time4j;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import net.time4j.engine.c0;

/* compiled from: ClockNormalizer.java */
/* loaded from: classes3.dex */
final class g implements c0<h> {

    private static final Map<h, g> a;
    private static final Map<h, g> b;
    private static final Map<h, g> c;
    static {
        g.a = g.a(0);
        g.b = g.a(1);
        g.c = g.a(2);
    }

    private g(h hVar, int i) {
        super();
    }

    private static Map<h, g> a(int i) {
        int i2 = 0;
        final EnumMap enumMap = new EnumMap(h.class);
        net.time4j.h[] values = h.values();
        i2 = 0;
        for (net.time4j.h hVar : values) {
            enumMap.put(hVar, new g(hVar, i));
        }
        return Collections.unmodifiableMap(enumMap);
    }

    static g b(h hVar) {
        Object value = g.a.get(hVar);
        if (value == null) {
            throw new IllegalArgumentException(hVar.name());
        } else {
            return value;
        }
    }

    static g c(h hVar) {
        Object value = g.c.get(hVar);
        if (value == null) {
            throw new IllegalArgumentException(hVar.name());
        } else {
            return value;
        }
    }

    static g d(h hVar) {
        Object value = g.b.get(hVar);
        if (value == null) {
            throw new IllegalArgumentException(hVar.name());
        } else {
            return value;
        }
    }
}

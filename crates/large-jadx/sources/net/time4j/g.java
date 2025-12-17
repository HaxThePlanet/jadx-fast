package net.time4j;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import net.time4j.engine.c0;

/* loaded from: classes3.dex */
final class g implements c0<net.time4j.h> {

    private static final Map<net.time4j.h, net.time4j.g> a;
    private static final Map<net.time4j.h, net.time4j.g> b;
    private static final Map<net.time4j.h, net.time4j.g> c;
    static {
        g.a = g.a(0);
        g.b = g.a(1);
        g.c = g.a(2);
    }

    private g(net.time4j.h h, int i2) {
        super();
    }

    private static Map<net.time4j.h, net.time4j.g> a(int i) {
        int i2;
        net.time4j.h hVar;
        net.time4j.g gVar;
        EnumMap enumMap = new EnumMap(h.class);
        net.time4j.h[] values = h.values();
        i2 = 0;
        while (i2 < values.length) {
            hVar = values[i2];
            gVar = new g(hVar, i);
            enumMap.put(hVar, gVar);
            i2++;
        }
        return Collections.unmodifiableMap(enumMap);
    }

    static net.time4j.g b(net.time4j.h h) {
        Object obj = g.a.get(h);
        if ((g)obj == null) {
        } else {
            return (g)obj;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(h.name());
        throw illegalArgumentException;
    }

    static net.time4j.g c(net.time4j.h h) {
        Object obj = g.c.get(h);
        if ((g)obj == null) {
        } else {
            return (g)obj;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(h.name());
        throw illegalArgumentException;
    }

    static net.time4j.g d(net.time4j.h h) {
        Object obj = g.b.get(h);
        if ((g)obj == null) {
        } else {
            return (g)obj;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(h.name());
        throw illegalArgumentException;
    }
}

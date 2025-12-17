package net.time4j.engine;

import java.util.Map;

/* loaded from: classes3.dex */
public final class j<T extends net.time4j.engine.l<T>>  extends net.time4j.engine.w<T> {

    private final Map<String, ? extends net.time4j.engine.k<T>> z;
    public net.time4j.engine.k<T> j() {
        ChronoException chronoException = new ChronoException("Cannot determine calendar system without variant.");
        throw chronoException;
    }

    public net.time4j.engine.k<T> k(String string) {
        final int i = 0;
        if (string.isEmpty()) {
        } else {
            Object obj = this.z.get(string);
            if ((k)obj == null) {
            } else {
                return (k)obj;
            }
            super.k(string);
            throw i;
        }
        j();
        throw i;
    }

    public boolean x(net.time4j.engine.p<?> p) {
        int obj2;
        if (!super.x(p)) {
            if (p instanceof z) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }
}

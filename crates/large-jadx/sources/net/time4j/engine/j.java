package net.time4j.engine;

import java.util.Map;

/* compiled from: CalendarFamily.java */
/* loaded from: classes3.dex */
public final class j<T extends l<T>> extends w<T> {

    private final Map<String, ? extends k<T>> z;
    @Override // net.time4j.engine.w
    public k<T> j() throws ChronoException {
        throw new ChronoException("Cannot determine calendar system without variant.");
    }

    @Override // net.time4j.engine.w
    public k<T> k(String str) {
        final int i = 0;
        if (str.isEmpty()) {
            j();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            Object value = this.z.get(str);
            if (value == null) {
                super.k(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                return value;
            }
        }
    }

    @Override // net.time4j.engine.w
    public boolean x(p<?> pVar) {
        boolean z3 = false;
        if (!super.x(pVar)) {
            z = pVar instanceof z;
            if (pVar instanceof z) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z3;
    }
}

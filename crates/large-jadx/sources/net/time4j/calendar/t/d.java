package net.time4j.calendar.t;

import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.Set;
import net.time4j.engine.e;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.g1.d;

/* compiled from: StdDateElement.java */
/* loaded from: classes3.dex */
public abstract class d<V extends Comparable<V>, T extends q<T>> extends d<V> implements net.time4j.calendar.p<V, T> {

    private final transient char b;
    private final Class<T> chrono;
    public d(String str, Class<T> cls, char c, boolean z) {
        super(str);
        this.chrono = cls;
        this.b = c;
    }

    @Override // net.time4j.g1.d
    protected boolean e(e<?> eVar) {
        boolean z = true;
        eVar = this.chrono == eVar.chrono ? 1 : 0;
        return (this.chrono == eVar.chrono ? 1 : 0);
    }

    @Override // net.time4j.g1.d
    public char getSymbol() {
        return this.b;
    }

    @Override // net.time4j.g1.d
    protected Class<T> k() {
        return this.chrono;
    }

    @Override // net.time4j.g1.d
    protected Object readResolve() throws InvalidObjectException {
        final String name = name();
        Iterator it = w.y(this.chrono).u().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.name().equals(name)) {
                return item;
            }
        }
        throw new InvalidObjectException(name);
    }

    @Override // net.time4j.g1.d
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.g1.d
    public boolean isTimeElement() {
        return false;
    }
}

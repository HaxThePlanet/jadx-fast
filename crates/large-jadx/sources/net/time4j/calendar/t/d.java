package net.time4j.calendar.t;

import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.Set;
import net.time4j.calendar.p;
import net.time4j.engine.e;
import net.time4j.engine.p;
import net.time4j.engine.w;
import net.time4j.g1.d;

/* loaded from: classes3.dex */
public abstract class d<V extends Comparable<V>, T extends net.time4j.engine.q<T>>  extends d<V> implements p<V, T> {

    private final transient char b;
    private final Class<T> chrono;
    public d(String string, Class<T> class2, char c3, boolean z4) {
        super(string);
        this.chrono = class2;
        this.b = c3;
    }

    protected boolean e(e<?> e) {
        int obj2;
        obj2 = this.chrono == e.chrono ? 1 : 0;
        return obj2;
    }

    @Override // net.time4j.g1.d
    public char getSymbol() {
        return this.b;
    }

    @Override // net.time4j.g1.d
    public boolean isDateElement() {
        return 1;
    }

    @Override // net.time4j.g1.d
    public boolean isTimeElement() {
        return 0;
    }

    protected Class<T> k() {
        return this.chrono;
    }

    @Override // net.time4j.g1.d
    protected Object readResolve() {
        Object next;
        boolean equals;
        final String name = name();
        Iterator iterator = w.y(this.chrono).u().iterator();
        for (p next : iterator) {
        }
        InvalidObjectException invalidObjectException = new InvalidObjectException(name);
        throw invalidObjectException;
    }
}

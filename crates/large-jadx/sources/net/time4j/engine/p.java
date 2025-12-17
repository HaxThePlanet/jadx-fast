package net.time4j.engine;

import java.util.Comparator;

/* loaded from: classes3.dex */
public interface p<V>  extends Comparator<net.time4j.engine.o> {
    public abstract V getDefaultMaximum();

    public abstract V getDefaultMinimum();

    @Override // java.util.Comparator
    public abstract char getSymbol();

    public abstract Class<V> getType();

    @Override // java.util.Comparator
    public abstract boolean isDateElement();

    @Override // java.util.Comparator
    public abstract boolean isLenient();

    @Override // java.util.Comparator
    public abstract boolean isTimeElement();

    @Override // java.util.Comparator
    public abstract String name();
}

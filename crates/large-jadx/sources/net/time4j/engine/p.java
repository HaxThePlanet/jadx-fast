package net.time4j.engine;

import java.util.Comparator;

/* compiled from: ChronoElement.java */
/* loaded from: classes3.dex */
public interface p<V> extends Comparator<o> {
    V getDefaultMaximum();

    V getDefaultMinimum();

    char getSymbol();

    Class<V> getType();

    boolean isDateElement();

    boolean isLenient();

    boolean isTimeElement();

    String name();
}
